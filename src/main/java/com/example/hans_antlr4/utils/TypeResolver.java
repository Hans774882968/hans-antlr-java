package com.example.hans_antlr4.utils;

import java.util.Optional;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import com.example.hans_antlr4.domain.type.ArrayType;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.ClassType;
import com.example.hans_antlr4.domain.type.Type;
import com.example.hans_antlr4.exception.InvalidHantNumberException;
import com.example.hans_antlr4.exception.InvalidHantTypeNameException;
import com.example.hans_antlr4.parsing.HansAntlrParser;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Floats;

public class TypeResolver {
    public static Type getFromTypeContext(HansAntlrParser.TypeContext typeContext) {
        if (typeContext == null)
            return BuiltInType.VOID;
        return getFromTypeName(typeContext.getText());
    }

    public static Type getFromTypeName(String typeName) {
        if (typeName.equals("java.lang.String")) {
            return BuiltInType.STRING;
        }
        if (typeName.equals("java.lang.Object")) {
            return BuiltInType.OBJECT;
        }
        Optional<? extends Type> buildInType = BuiltInType.getBuiltInType(typeName);
        if (buildInType.isPresent()) {
            return buildInType.get();
        }
        if (!typeName.endsWith("[]")) {
            return ClassType.getTypeByQualifiedName(typeName);
        }

        int suffixIndex = typeName.indexOf("[");
        String elementTypeName = typeName.substring(0, suffixIndex);
        Type elementType = getFromTypeName(elementTypeName);
        int dimension = (typeName.length() - suffixIndex) / 2;

        if (!typeName.substring(suffixIndex).equals("[]".repeat(dimension))) {
            throw new InvalidHantTypeNameException(typeName);
        }

        return new ArrayType(elementType, dimension);
    }

    public static Type getFromJavaLangClass(Class<?> clazz) {
        return getFromTypeName(clazz.getCanonicalName());
    }

    public static Type getFromValue(String value) {
        if (StringUtils.isEmpty(value)) {
            return BuiltInType.VOID;
        }
        if (HantNumber.mayBeValidHantNumber(value)) {
            String typeSuffix = HantNumber.getTypeSuffix(value);
            String pureNumber = typeSuffix == null ? value : value.substring(0, value.length() - 1);
            if (typeSuffix != null) {
                if (typeSuffix.toLowerCase().equals("d")) {
                    if (Doubles.tryParse(pureNumber) != null) {
                        return BuiltInType.DOUBLE;
                    }
                    throw new InvalidHantNumberException(BuiltInType.DOUBLE, value);
                }
                if (typeSuffix.toLowerCase().equals("f")) {
                    if (Floats.tryParse(pureNumber) != null) {
                        return BuiltInType.FLOAT;
                    }
                    throw new InvalidHantNumberException(BuiltInType.FLOAT, value);
                }
                if (typeSuffix.toLowerCase().equals("l")) {
                    if (HantNumber.isValidHantLong(pureNumber)) {
                        return BuiltInType.LONG;
                    }
                    throw new InvalidHantNumberException(BuiltInType.LONG, value);
                }
                // 为了避免16进制的歧义， byte 类型字面量类型后缀约定为“byte”的第2个字母
                if (typeSuffix.toLowerCase().equals("y")) {
                    if (HantNumber.isValidHantByte(pureNumber)) {
                        return BuiltInType.BYTE;
                    }
                    throw new InvalidHantNumberException(BuiltInType.BYTE, value);
                }
            }
            if (HantNumber.isValidHantInteger(pureNumber)) {
                return BuiltInType.INT;
            } else if (Doubles.tryParse(pureNumber) != null) {
                return BuiltInType.DOUBLE;
            } else if (Floats.tryParse(pureNumber) != null) {
                return BuiltInType.FLOAT;
            }
        }
        if (BooleanUtils.toBooleanObject(value) != null) {
            return BuiltInType.BOOLEAN;
        }
        return BuiltInType.STRING;
    }

    private static Byte getByteValueFromString(String stringValue) {
        if (HantNumber.mayBeHex(stringValue)) {
            return Byte.valueOf(stringValue.substring(2), 16);
        }
        if (HantNumber.mayBeOctal(stringValue)) {
            return Byte.valueOf(stringValue.substring(2), 8);
        }
        if (HantNumber.mayBeBinary(stringValue)) {
            return Byte.valueOf(stringValue.substring(2), 2);
        }
        return Byte.valueOf(stringValue);
    }

    private static Integer getIntValueFromString(String stringValue) {
        if (HantNumber.mayBeHex(stringValue)) {
            return Integer.valueOf(stringValue.substring(2), 16);
        }
        if (HantNumber.mayBeOctal(stringValue)) {
            return Integer.valueOf(stringValue.substring(2), 8);
        }
        if (HantNumber.mayBeBinary(stringValue)) {
            return Integer.valueOf(stringValue.substring(2), 2);
        }
        return Integer.valueOf(stringValue);
    }

    private static Long getLongValueFromString(String stringValue) {
        if (HantNumber.mayBeHex(stringValue)) {
            return Long.valueOf(stringValue.substring(2), 16);
        }
        if (HantNumber.mayBeOctal(stringValue)) {
            return Long.valueOf(stringValue.substring(2), 8);
        }
        if (HantNumber.mayBeBinary(stringValue)) {
            return Long.valueOf(stringValue.substring(2), 2);
        }
        return Long.valueOf(stringValue);
    }

    public static String getTransformedString(String value) {
        value = StringUtils.removeStart(value, "\"");
        value = StringUtils.removeEnd(value, "\"");
        value = StringEscapeUtils.unescapeJava(value);
        return value;
    }

    // 约定：getValueFromString 调用时 stringValue 已经没有 typeSuffix
    public static Object getValueFromString(String stringValue, Type type) {
        if (type == BuiltInType.BYTE) {
            return getByteValueFromString(stringValue);
        }
        if (type == BuiltInType.INT) {
            return getIntValueFromString(stringValue);
        }
        if (type == BuiltInType.LONG) {
            return getLongValueFromString(stringValue);
        }
        if (type == BuiltInType.FLOAT) {
            try {
                return Float.valueOf(stringValue);
            } catch (NumberFormatException e) {
                return Float.valueOf(getIntValueFromString(stringValue));
            }
        }
        if (type == BuiltInType.DOUBLE) {
            try {
                return Double.valueOf(stringValue);
            } catch (NumberFormatException e) {
                return Double.valueOf(getLongValueFromString(stringValue));
            }
        }
        if (type == BuiltInType.BOOLEAN) {
            return Boolean.valueOf(stringValue);
        }
        if (type == BuiltInType.STRING) {
            return getTransformedString(stringValue);
        }
        throw new AssertionError("Objects not yet implemented!");
    }

    public static String getTransformedStringInTemplateString(String templateString) {
        return StringEscapeUtils.unescapeJava(templateString);
    }
}
