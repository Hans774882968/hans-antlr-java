package com.example.hans_antlr4.utils;

import java.util.Optional;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.ClassType;
import com.example.hans_antlr4.domain.type.Type;
import com.example.hans_antlr4.exception.InvalidHantNumberException;
import com.example.hans_antlr4.parsing.HansAntlrParser;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Floats;

public class TypeResolver {
    public static Type getFromTypeName(HansAntlrParser.TypeContext typeContext) {
        if (typeContext == null)
            return BuiltInType.VOID;
        String typeName = typeContext.getText();
        Optional<? extends Type> buildInType = BuiltInType.getBuiltInType(typeName);
        if (buildInType.isPresent())
            return buildInType.get();
        return new ClassType(typeName);
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
}
