package com.example.hans_antlr4.exception.type;

import com.example.hans_antlr4.domain.expression.unary.UnaryTilde;

public class IllegalUnaryTildeTypeException extends RuntimeException {
    public IllegalUnaryTildeTypeException(UnaryTilde unaryTilde, int sourceLine) {
        super("The '~' operator can only be used for integer types, but got type "
                + unaryTilde.getType().getName() + " at line " + sourceLine);
    }
}
