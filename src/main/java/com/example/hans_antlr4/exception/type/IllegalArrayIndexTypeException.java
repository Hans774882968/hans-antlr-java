package com.example.hans_antlr4.exception.type;

import com.example.hans_antlr4.domain.expression.Expression;

public class IllegalArrayIndexTypeException extends RuntimeException {
    public IllegalArrayIndexTypeException(Expression dimension, int sourceLine) {
        super("Array index type should be integer type, but got " + dimension.getType().getName()
                + " at line " + sourceLine);
    }
}
