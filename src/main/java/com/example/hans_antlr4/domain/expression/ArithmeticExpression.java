package com.example.hans_antlr4.domain.expression;

import com.example.hans_antlr4.domain.global.ArithmeticSign;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.Type;

import lombok.Getter;

@Getter
public abstract class ArithmeticExpression extends Expression {
    private Expression leftExpression;
    private Expression rightExpression;
    private ArithmeticSign sign;

    public ArithmeticExpression(
            Expression leftExpression,
            Expression rightExpression,
            ArithmeticSign sign) {
        super(getCommonType(leftExpression, rightExpression), null, null);
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.sign = sign;
    }

    public ArithmeticExpression(
            Type type,
            Expression leftExpression,
            Expression rightExpression,
            ArithmeticSign sign) {
        super(type, null, null);
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.sign = sign;
    }

    private static Type getCommonType(Expression leftExpression, Expression rightExpression) {
        Type leftType = leftExpression.getType();
        Type rightType = rightExpression.getType();
        if (leftType == BuiltInType.STRING || rightType == BuiltInType.STRING) {
            return BuiltInType.STRING;
        }
        if (leftType.getPriority().compareTo(rightType.getPriority()) >= 0) {
            return leftType;
        }
        return rightType;
    }
}
