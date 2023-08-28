package com.example.hans_antlr4.domain.expression;

public abstract class Additive extends ArithmeticExpression {
    Additive(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }
}
