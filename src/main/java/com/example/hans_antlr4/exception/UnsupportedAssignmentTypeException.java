package com.example.hans_antlr4.exception;

import com.example.hans_antlr4.domain.type.Type;

public class UnsupportedAssignmentTypeException extends RuntimeException {
    public UnsupportedAssignmentTypeException(Type type) {
        super("Unsupported assignment expression type: " + type.getName());
    }
}
