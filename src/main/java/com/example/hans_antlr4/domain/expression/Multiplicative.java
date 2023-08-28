package com.example.hans_antlr4.domain.expression;

public abstract class Multiplicative extends ArithmeticExpression {
    Multiplicative(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }
}
