package com.example.hans_antlr4.domain.expression;

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

    public ArithmeticExpression(Type type, Expression leftExpression, Expression rightExpression) {
        super(type, null, null);
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    private static Type getCommonType(Expression leftExpression, Expression rightExpression) {
        Type leftType = leftExpression.getType();
        Type rightType = rightExpression.getType();
        if (leftType.getPriority().compareTo(rightType.getPriority()) >= 0) {
            return leftType;
        }
        return rightType;
    }
}
