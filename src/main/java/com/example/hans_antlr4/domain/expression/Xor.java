package com.example.hans_antlr4.domain.expression;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;

public class Xor extends ArithmeticExpression {
    public Xor(Expression leftExpression, Expression rightExpression) {
        super(leftExpression.getType(), leftExpression, rightExpression);
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }
}
