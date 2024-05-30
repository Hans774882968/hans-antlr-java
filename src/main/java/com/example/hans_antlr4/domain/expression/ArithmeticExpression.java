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
            ArithmeticSign sign,
            int sourceLine) {
        super(getCommonType(leftExpression, rightExpression, sign), null, null, sourceLine, null);
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.sign = sign;
        calculateValueInferResult();
    }

    private static Type getCommonType(
            Expression leftExpression,
            Expression rightExpression,
            ArithmeticSign sign) {
        Type leftType = leftExpression.getType();
        Type rightType = rightExpression.getType();
        if (sign.isShiftSign()) {
            return getShiftCommonType(leftType);
        }
        if (leftType == BuiltInType.STRING || rightType == BuiltInType.STRING) {
            return BuiltInType.STRING;
        }
        if (leftType == BuiltInType.BYTE && rightType == BuiltInType.BYTE) {
            return BuiltInType.INT;
        }
        if (leftType.getPriority().compareTo(rightType.getPriority()) >= 0) {
            return leftType;
        }
        return rightType;
    }

    private static Type getShiftCommonType(Type leftType) {
        if (leftType == BuiltInType.BYTE) {
            return BuiltInType.INT;
        }
        return leftType;
    }

    public Type getLeftType() {
        return leftExpression.getType();
    }

    public Type getRightType() {
        return rightExpression.getType();
    }
}
