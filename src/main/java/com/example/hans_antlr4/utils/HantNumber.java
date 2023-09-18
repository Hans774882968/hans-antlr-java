package com.example.hans_antlr4.utils;

import org.apache.commons.lang3.math.NumberUtils;

import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;

public class HantNumber {
    public static boolean mayBeHex(String value) {
        return value.toLowerCase().startsWith("0x");
    }

    public static boolean mayBeOctal(String value) {
        return value.toLowerCase().startsWith("0o");
    }

    public static boolean mayBeBinary(String value) {
        return value.toLowerCase().startsWith("0b");
    }

    public static String getTypeSuffix(String value) {
        if (value.endsWith("l") || value.endsWith("L")) {
            return value.substring(value.length() - 1);
        }
        if (value.endsWith("d") || value.endsWith("D")
                || value.endsWith("f") || value.endsWith("F")) {
            if (mayBeHex(value)) {
                return null;
            }
            return value.substring(value.length() - 1);
        }
        if (value.endsWith("y") || value.endsWith("Y")) {
            return value.substring(value.length() - 1);
        }
        return null;
    }

    public static String getStringWithoutTypeSuffix(String value) {
        String typeSuffix = getTypeSuffix(value);
        String pureNumber = typeSuffix == null ? value : value.substring(0, value.length() - 1);
        return pureNumber;
    }

    public static boolean mayBeValidHantNumber(String value) {
        String pureNumber = getStringWithoutTypeSuffix(value);

        if (pureNumber == null || pureNumber.length() <= 0) {
            return false;
        }
        if (mayBeHex(pureNumber)) {
            return NumberUtils.isCreatable(pureNumber);
        }
        if (mayBeOctal(pureNumber)) {
            return NumberUtils.isCreatable("0" + pureNumber.substring(2));
        }
        if (mayBeBinary(pureNumber)) {
            return NumberUtils.isCreatable(pureNumber.substring(2));
        }
        // 00123 这种数在 hant 中期望为10进制数，但在 Java 中是8进制
        String valueWithoutPrefixZero = pureNumber.replaceFirst("^0*", "");
        if (valueWithoutPrefixZero.equals("")) {
            return true;
        }
        return NumberUtils.isCreatable(valueWithoutPrefixZero);
    }

    // isValidHantInteger、isValidHantLong 入参没有 typeSuffix
    public static boolean isValidHantInteger(String value) {
        if (Ints.tryParse(value) != null) {
            return true;
        }
        if (mayBeHex(value)) {
            return Ints.tryParse(value.substring(2), 16) != null;
        }
        if (mayBeOctal(value)) {
            return Ints.tryParse(value.substring(2), 8) != null;
        }
        if (mayBeBinary(value)) {
            return Ints.tryParse(value.substring(2), 2) != null;
        }
        return false;
    }

    public static boolean isValidHantLong(String value) {
        if (Longs.tryParse(value) != null) {
            return true;
        }
        if (mayBeHex(value)) {
            return Longs.tryParse(value.substring(2), 16) != null;
        }
        if (mayBeOctal(value)) {
            return Longs.tryParse(value.substring(2), 8) != null;
        }
        if (mayBeBinary(value)) {
            return Longs.tryParse(value.substring(2), 2) != null;
        }
        return false;
    }

    public static boolean isValidHantByte(String value) {
        if (Ints.tryParse(value) != null) {
            int v = Ints.tryParse(value);
            return Byte.MIN_VALUE <= v && v <= Byte.MAX_VALUE;
        }
        if (mayBeHex(value) && Ints.tryParse(value.substring(2), 16) != null) {
            int v = Ints.tryParse(value.substring(2), 16);
            return Byte.MIN_VALUE <= v && v <= Byte.MAX_VALUE;
        }
        if (mayBeOctal(value) && Ints.tryParse(value.substring(2), 8) != null) {
            int v = Ints.tryParse(value.substring(2), 8);
            return Byte.MIN_VALUE <= v && v <= Byte.MAX_VALUE;
        }
        if (mayBeBinary(value) && Ints.tryParse(value.substring(2), 2) != null) {
            int v = Ints.tryParse(value.substring(2), 2);
            return Byte.MIN_VALUE <= v && v <= Byte.MAX_VALUE;
        }
        return false;
    }
}
