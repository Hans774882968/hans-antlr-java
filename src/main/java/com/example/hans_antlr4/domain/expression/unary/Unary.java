package com.example.hans_antlr4.domain.expression.unary;

import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.type.Type;

import lombok.Getter;

@Getter
public abstract class Unary extends Expression {
    private Expression expression;

    public Unary(Type type, Expression expression) {
        super(type);
        this.expression = expression;
    }
}
