package com.example.hans_antlr4.exception;

import com.example.hans_antlr4.domain.type.Type;

public class InvalidHantNumberException extends RuntimeException {
    public InvalidHantNumberException(Type expectedType, String value) {
        super("Invalid " + expectedType.getName() + " hant number: " + value);
    }
}
