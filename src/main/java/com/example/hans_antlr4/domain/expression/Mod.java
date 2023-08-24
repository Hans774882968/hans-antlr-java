package com.example.hans_antlr4.domain.expression;

import java.util.Objects;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.data_processor.ExpressionTreeProcessor;

public class Mod extends Multiplicative {
    public Mod(Expression leftExpression, Expression rightExpression) {
        super(leftExpression.getType(), leftExpression, rightExpression);
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }

    @Override
    public void processSubExpressionTree(ExpressionTreeProcessor processor, Expression parent) {
        processor.processExpressionTree(this, parent);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Mod)) {
            return false;
        }
        Mod modExpression = (Mod) o;
        return Objects.equals(getType(), modExpression.getType())
                && Objects.equals(getLeftExpression(), modExpression.getLeftExpression())
                && Objects.equals(getRightExpression(), modExpression.getRightExpression());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getLeftExpression(), getRightExpression());
    }
}
