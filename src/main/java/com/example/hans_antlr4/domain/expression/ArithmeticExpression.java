package com.example.hans_antlr4.domain.expression;

import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.Type;

import lombok.Getter;

@Getter
public abstract class ArithmeticExpression extends Expression {
    private Expression leftExpression;
    private Expression rightExpression;

    public ArithmeticExpression(Expression leftExpression, Expression rightExpression) {
        super(getCommonType(leftExpression, rightExpression), null, null);
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    private static Type getCommonType(Expression leftExpression, Expression rightExpression) {
        if (rightExpression.getType() == BuiltInType.STRING) {
            return BuiltInType.STRING;
        }
        return leftExpression.getType();
    }
}
