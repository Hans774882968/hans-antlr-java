package com.example.hans_antlr4.domain.expression;

import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.Type;
import com.example.hans_antlr4.exception.UnsupportedArithmeticOperationException;

import lombok.Getter;
import java.util.Objects;

@Getter
public abstract class ArithmeticExpression extends Expression {
    private Expression leftExpression;
    private Expression rightExpression;

    public ArithmeticExpression(Type type, Expression leftExpression, Expression rightExpression) {
        super(type);
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        if (type != BuiltInType.INT) {
            throw new UnsupportedArithmeticOperationException(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ArithmeticExpression)) {
            return false;
        }
        ArithmeticExpression arithmeticExpression = (ArithmeticExpression) o;
        return Objects.equals(getType(), arithmeticExpression.getType())
                && Objects.equals(leftExpression, arithmeticExpression.leftExpression)
                && Objects.equals(rightExpression, arithmeticExpression.rightExpression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), leftExpression, rightExpression);
    }
}
