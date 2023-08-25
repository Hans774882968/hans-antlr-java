package com.example.hans_antlr4.domain.expression;

import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.Type;
import com.example.hans_antlr4.exception.UnsupportedArithmeticOperationException;

import lombok.Getter;

@Getter
public abstract class ArithmeticExpression extends Expression {
    private Expression leftExpression;
    private Expression rightExpression;

    public ArithmeticExpression(Type type, Expression leftExpression, Expression rightExpression) {
        super(type, null, null);
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        if (type != BuiltInType.INT) {
            throw new UnsupportedArithmeticOperationException(this);
        }
    }
}
