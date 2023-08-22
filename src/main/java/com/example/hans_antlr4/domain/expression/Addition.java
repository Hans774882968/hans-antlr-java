package com.example.hans_antlr4.domain.expression;

import java.util.Objects;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;

public class Addition extends Additive {
    public Addition(Expression leftExpression, Expression rightExpression) {
        super(leftExpression.getType(), leftExpression, rightExpression);
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Addition)) {
            return false;
        }
        Addition addition = (Addition) o;
        return Objects.equals(getType(), addition.getType())
                && Objects.equals(getLeftExpression(), addition.getLeftExpression())
                && Objects.equals(getRightExpression(), addition.getRightExpression());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getLeftExpression(), getRightExpression());
    }
}
