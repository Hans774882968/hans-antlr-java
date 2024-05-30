package com.example.hans_antlr4.exception.type;

import com.example.hans_antlr4.domain.expression.unary.Unary;

public class IllegalUnaryNegPosTypeException extends RuntimeException {
    public IllegalUnaryNegPosTypeException(Unary unary, int sourceLine) {
        super("Operator '+' and '-' can only be used for numeric types, but got type "
                + unary.getType().getName() + " at line " + sourceLine);
    }
}
