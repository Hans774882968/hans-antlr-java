package com.example.hans_antlr4.domain.expression;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.domain.global.CompareSign;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.exception.MixedComparisonNotAllowedException;

import lombok.Getter;
import java.util.Objects;

@Getter
public class ConditionalExpression extends Expression {
    private final CompareSign compareSign;
    private final Expression leftExpression;
    private final Expression rightExpression;
    private final boolean isPrimitiveComparison;

    public ConditionalExpression(Expression leftExpression, Expression rightExpression, CompareSign compareSign) {
        super(BuiltInType.BOOLEAN);
        this.compareSign = compareSign;
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        boolean leftExpressionIsPrimitive = leftExpression.getType().getTypeClass().isPrimitive();
        boolean rightExpressionIsPrimitive = rightExpression.getType().getTypeClass().isPrimitive();
        isPrimitiveComparison = leftExpressionIsPrimitive && rightExpressionIsPrimitive;
        boolean isObjectsComparison = !leftExpressionIsPrimitive && !rightExpressionIsPrimitive;
        boolean isMixedComparison = !isPrimitiveComparison && !isObjectsComparison;
        if (isMixedComparison) {
            throw new MixedComparisonNotAllowedException(leftExpression.getType(), rightExpression.getType());
        }
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ConditionalExpression)) {
            return false;
        }
        ConditionalExpression conditionalExpression = (ConditionalExpression) o;
        return Objects.equals(compareSign, conditionalExpression.compareSign)
                && Objects.equals(leftExpression, conditionalExpression.leftExpression)
                && Objects.equals(rightExpression, conditionalExpression.rightExpression)
                && Objects.equals(getType(), conditionalExpression.getType())
                && isPrimitiveComparison == conditionalExpression.isPrimitiveComparison;
    }

    @Override
    public int hashCode() {
        return Objects.hash(compareSign, leftExpression, rightExpression, getType(), isPrimitiveComparison);
    }
}
