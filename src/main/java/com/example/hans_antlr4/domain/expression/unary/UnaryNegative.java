package com.example.hans_antlr4.domain.expression.unary;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.domain.expression.Expression;

public class UnaryNegative extends Unary {
    public UnaryNegative(Expression expression) {
        super(expression.getType(), expression);
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }
}
