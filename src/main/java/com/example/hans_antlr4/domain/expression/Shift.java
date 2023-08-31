package com.example.hans_antlr4.domain.expression;

public abstract class Shift extends ArithmeticExpression {
    public Shift(Expression leftExpression, Expression rightExpression) {
        super(leftExpression.getType(), leftExpression, rightExpression);
    }
}
