package com.example.hans_antlr4.exception;

import com.example.hans_antlr4.domain.expression.ArithmeticExpression;
import com.example.hans_antlr4.domain.expression.Expression;

public class UnsupportedArithmeticOperationException extends RuntimeException {
    public UnsupportedArithmeticOperationException(ArithmeticExpression arithmeticExpression) {
        super(getMessage(arithmeticExpression));
    }

    private static String getMessage(ArithmeticExpression arithmeticExpression) {
        Expression leftExpression = arithmeticExpression.getLeftExpression();
        Expression rightExpression = arithmeticExpression.getRightExpression();
        return "Unsupported arithmetic operation between " + leftExpression + " and " + rightExpression;
    }
}
