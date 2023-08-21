package com.example.hans_antlr4.domain.expression.unary;

import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.type.Type;

import lombok.Getter;
import java.util.Objects;

@Getter
public abstract class Unary extends Expression {
    private Expression expression;

    public Unary(Type type, Expression expression) {
        super(type);
        this.expression = expression;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Unary)) {
            return false;
        }
        Unary unary = (Unary) o;
        return Objects.equals(getType(), expression.getType()) && Objects.equals(expression, unary.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), expression);
    }
}
