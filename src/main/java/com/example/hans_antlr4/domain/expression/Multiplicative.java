package com.example.hans_antlr4.domain.expression;

import com.example.hans_antlr4.domain.type.Type;

public abstract class Multiplicative extends ArithmeticExpression {
    Multiplicative(Type type, Expression leftExpression, Expression rightExpression) {
        super(type, leftExpression, rightExpression);
    }
}
