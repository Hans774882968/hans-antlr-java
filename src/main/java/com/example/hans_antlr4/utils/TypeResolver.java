package com.example.hans_antlr4.utils;

import org.apache.commons.lang3.StringUtils;

import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.Type;

public class TypeResolver {
    public static Type getFromValue(String value) {
        if (StringUtils.isEmpty(value))
            return BuiltInType.VOID;
        if (StringUtils.isNumeric(value)) {
            return BuiltInType.INT;
        }
        return BuiltInType.STRING;
    }
}
