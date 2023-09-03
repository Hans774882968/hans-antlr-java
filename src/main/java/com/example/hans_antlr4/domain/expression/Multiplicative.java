package com.example.hans_antlr4.domain.expression;

import com.example.hans_antlr4.domain.global.ArithmeticSign;

public abstract class Multiplicative extends ArithmeticExpression {
    Multiplicative(Expression leftExpression, Expression rightExpression, ArithmeticSign sign) {
        super(leftExpression, rightExpression, sign);
    }
}
