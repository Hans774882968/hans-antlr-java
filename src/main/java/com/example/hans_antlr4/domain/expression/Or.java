package com.example.hans_antlr4.domain.expression;

import com.example.hans_antlr4.bytecode_gen.ExpressionGenerator;

public class Or extends ArithmeticExpression {
    public Or(Expression leftExpression, Expression rightExpression) {
        super(leftExpression.getType(), leftExpression, rightExpression);
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }
}
