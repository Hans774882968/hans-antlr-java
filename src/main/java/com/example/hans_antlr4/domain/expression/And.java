package com.example.hans_antlr4.domain.expression;

import com.example.hans_antlr4.bytecode_gen.ExpressionGenerator;

public class And extends ArithmeticExpression {
    public And(Expression leftExpression, Expression rightExpression) {
        super(leftExpression.getType(), leftExpression, rightExpression);
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }
}
