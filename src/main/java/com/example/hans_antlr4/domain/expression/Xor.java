package com.example.hans_antlr4.domain.expression;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import java.util.Objects;

public class Xor extends ArithmeticExpression {
    public Xor(Expression leftExpression, Expression rightExpression) {
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
        if (!(o instanceof Xor)) {
            return false;
        }
        Xor xorExpression = (Xor) o;
        return Objects.equals(getType(), xorExpression.getType())
                && Objects.equals(getLeftExpression(), xorExpression.getLeftExpression())
                && Objects.equals(getRightExpression(), xorExpression.getRightExpression());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getLeftExpression(), getRightExpression());
    }
}
