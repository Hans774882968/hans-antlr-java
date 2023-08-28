package com.example.hans_antlr4.domain.expression;

public abstract class Shift extends ArithmeticExpression {
    Shift(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }
}
