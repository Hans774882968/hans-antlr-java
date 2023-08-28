package com.example.hans_antlr4.exception;

import com.example.hans_antlr4.domain.type.Type;

public class UnsupportedTypeForTildeExpressionException extends RuntimeException {
    public UnsupportedTypeForTildeExpressionException(Type type) {
        super("Unsupported type for tilde expression: " + type.getName());
    }
}
