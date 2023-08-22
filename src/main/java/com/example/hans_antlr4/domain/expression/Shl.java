package com.example.hans_antlr4.domain.expression;

import java.util.Objects;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;

public class Shl extends Shift {
    public Shl(Expression leftExpression, Expression rightExpression) {
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
        if (!(o instanceof Shl)) {
            return false;
        }
        Shl shlExpression = (Shl) o;
        return Objects.equals(getType(), shlExpression.getType())
                && Objects.equals(getLeftExpression(), shlExpression.getLeftExpression())
                && Objects.equals(getRightExpression(), shlExpression.getRightExpression());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getLeftExpression(), getRightExpression());
    }
}
