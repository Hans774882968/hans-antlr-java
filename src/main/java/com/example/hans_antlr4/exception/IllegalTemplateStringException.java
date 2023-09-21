package com.example.hans_antlr4.exception;

import java.util.List;

import com.example.hans_antlr4.domain.expression.Expression;

public class IllegalTemplateStringException extends RuntimeException {
    public IllegalTemplateStringException(List<String> strs, List<Expression> expressions) {
        super("strs.size() should be expressions.size() + 1, but got strs.size() = "
                + strs.size() + ", expressions.size() = " + expressions.size());
    }
}
