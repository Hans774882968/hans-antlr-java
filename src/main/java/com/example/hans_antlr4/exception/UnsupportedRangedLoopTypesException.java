package com.example.hans_antlr4.exception;

import com.example.hans_antlr4.domain.type.Type;

public class UnsupportedRangedLoopTypesException extends RuntimeException {
    public UnsupportedRangedLoopTypesException(
            Type startExpressionType, Type endExpressionType) {
        super("Only integer types are supported so far, but startExpressionType is " + startExpressionType.getName()
                + ", and endExpressionType is " + endExpressionType.getName());
    }
}
