package com.example.hans_antlr4.domain.expression;

import com.example.hans_antlr4.domain.global.ArithmeticSign;

public abstract class Shift extends ArithmeticExpression {
    public Shift(Expression leftExpression, Expression rightExpression, ArithmeticSign sign) {
        super(leftExpression.getType(), leftExpression, rightExpression, sign);
    }
}
