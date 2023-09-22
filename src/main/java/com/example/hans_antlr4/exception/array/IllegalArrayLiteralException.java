package com.example.hans_antlr4.exception.array;

import java.util.List;

import com.example.hans_antlr4.domain.expression.Expression;

public class IllegalArrayLiteralException extends RuntimeException {
    public IllegalArrayLiteralException(List<Expression> items, int sourceLine) {
        super("Array literal should not be empty and should be the same type, but got "
                + items.size() + " kinds of type at line " + sourceLine);
    }
}
