package com.example.hans_antlr4.domain.expression.unary;

import java.util.Objects;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.data_processor.ExpressionTreeProcessor;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.value_infer.ValueInferUtils;
import com.example.hans_antlr4.utils.Const;

public class UnaryPositive extends Unary {
    public UnaryPositive(Expression expression, int sourceLine) {
        super(expression, sourceLine);
    }

    public static UnaryPositive unaryPositiveWithoutSourceLine(Expression expression) {
        return new UnaryPositive(expression, Const.MOCK_SOURCE_LINE);
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
        this.setValueInferResult(ValueInferUtils.calcValueInferResultForUnaryNegPos(this));
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UnaryPositive)) {
            return false;
        }
        UnaryPositive unaryPositive = (UnaryPositive) o;
        return Objects.equals(getType(), unaryPositive.getType())
                && Objects.equals(getExpression(), unaryPositive.getExpression());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getExpression());
    }
}
