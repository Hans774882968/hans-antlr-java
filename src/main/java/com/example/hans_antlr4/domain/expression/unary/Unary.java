package com.example.hans_antlr4.domain.expression.unary;

import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.Type;

import lombok.Getter;

@Getter
public abstract class Unary extends Expression {
    private Expression expression;

    public Unary(Expression expression, int sourceLine) {
        super(getCommonType(expression), null, null, sourceLine, null);
        this.expression = expression;
        calculateValueInferResult();
    }

    private static Type getCommonType(Expression expression) {
        if (expression.getType() == BuiltInType.BYTE) {
            return BuiltInType.INT;
        }
        return expression.getType();
    }
}
