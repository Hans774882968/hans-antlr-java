package com.example.hans_antlr4.domain.expression;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.data_processor.ExpressionTreeProcessor;
import com.example.hans_antlr4.domain.global.CompareSign;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.Type;
import com.example.hans_antlr4.domain.value_infer.ValueInferUtils;
import com.example.hans_antlr4.exception.MixedComparisonNotAllowedException;

import lombok.Getter;
import java.util.Objects;

@Getter
public class ConditionalExpression extends Expression {
    private final CompareSign compareSign;
    private final Expression leftExpression;
    private final Expression rightExpression;
    private final boolean isPrimitiveComparison;

    public ConditionalExpression(
            Expression leftExpression,
            Expression rightExpression,
            CompareSign compareSign,
            int sourceLine) {
        super(BuiltInType.BOOLEAN, null, null, sourceLine, null);
        this.compareSign = compareSign;
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        boolean leftExpressionIsPrimitive = leftExpression.getType().getTypeClass().isPrimitive();
        boolean rightExpressionIsPrimitive = rightExpression.getType().getTypeClass().isPrimitive();
        isPrimitiveComparison = leftExpressionIsPrimitive && rightExpressionIsPrimitive;
        boolean isObjectsComparison = !leftExpressionIsPrimitive && !rightExpressionIsPrimitive;
        boolean isMixedComparison = !isPrimitiveComparison && !isObjectsComparison;
        if (isMixedComparison) {
            throw new MixedComparisonNotAllowedException(leftExpression.getType(),
                    rightExpression.getType());
        }
        calculateValueInferResult();
    }

    public Type getMaxPriorityNumericType() {
        Type leftType = leftExpression.getType();
        Type rightType = rightExpression.getType();
        if (leftType.getPriority().compareTo(rightType.getPriority()) >= 0) {
            return leftType;
        }
        return rightType;
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }

    @Override
    public void processSubExpressionTree(
            ExpressionTreeProcessor processor,
            Expression parent,
            Statement belongStatement) {
        processor.processExpressionTree(this, parent, belongStatement);
    }

    @Override
    public void calculateValueInferResult() {
        this.setValueInferResult(ValueInferUtils.calcValueInferResultForConditionalExpression(this));
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
