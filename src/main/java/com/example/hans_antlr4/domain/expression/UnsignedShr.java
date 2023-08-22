package com.example.hans_antlr4.domain.expression;

import java.util.Objects;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;

public class UnsignedShr extends Shift {
    public UnsignedShr(Expression leftExpression, Expression rightExpression) {
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
        if (!(o instanceof UnsignedShr)) {
            return false;
        }
        UnsignedShr unsignedShr = (UnsignedShr) o;
        return Objects.equals(getType(), unsignedShr.getType())
                && Objects.equals(getLeftExpression(), unsignedShr.getLeftExpression())
                && Objects.equals(getRightExpression(), unsignedShr.getRightExpression());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getLeftExpression(), getRightExpression());
    }
}
