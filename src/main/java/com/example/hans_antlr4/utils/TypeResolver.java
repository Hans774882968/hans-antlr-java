package com.example.hans_antlr4.utils;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.Type;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Floats;
import com.google.common.primitives.Ints;

public class TypeResolver {
    public static Type getFromValue(String value) {
        if (StringUtils.isEmpty(value))
            return BuiltInType.VOID;
        // TODO: 支持8进制 0o 和2进制 0b
        if (NumberUtils.isCreatable(value)) {
            if (Ints.tryParse(value) != null ||
                    (value.startsWith("0x") && Ints.tryParse(value.substring(2), 16) != null) ||
                    (value.startsWith("0o") && Ints.tryParse(value.substring(2), 8) != null) ||
                    (value.startsWith("0b") && Ints.tryParse(value.substring(2), 2) != null)) {
                return BuiltInType.INT;
            } else if (Floats.tryParse(value) != null) {
                return BuiltInType.FLOAT;
            } else if (Doubles.tryParse(value) != null) {
                return BuiltInType.DOUBLE;
            }
        }
        if (BooleanUtils.toBoolean(value)) {
            return BuiltInType.BOOLEAN;
        }
        return BuiltInType.STRING;
    }

    public static Object getValueFromString(String stringValue, Type type) {
        if (type == BuiltInType.INT) {
            if (stringValue.startsWith("0x")) {
                return Integer.valueOf(stringValue.substring(2), 16);
            }
            if (stringValue.startsWith("0o")) {
                return Integer.valueOf(stringValue.substring(2), 8);
            }
            if (stringValue.startsWith("0b")) {
                return Integer.valueOf(stringValue.substring(2), 2);
            }
            return Integer.valueOf(stringValue);
        }
        if (type == BuiltInType.FLOAT) {
            return Float.valueOf(stringValue);
        }
        if (type == BuiltInType.DOUBLE) {
            return Double.valueOf(stringValue);
        }
        if (type == BuiltInType.BOOLEAN) {
            return Boolean.valueOf(stringValue);
        }
        if (type == BuiltInType.STRING) {
            stringValue = StringUtils.removeStart(stringValue, "\"");
            stringValue = StringUtils.removeEnd(stringValue, "\"");
            return stringValue;
        }
        throw new AssertionError("Objects not yet implemented!");
    }
}
