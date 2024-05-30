package com.example.hans_antlr4.domain.expression;

import java.util.Objects;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.data_processor.ExpressionTreeProcessor;
import com.example.hans_antlr4.domain.global.ArithmeticSign;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.value_infer.ValueInferUtils;
import com.example.hans_antlr4.utils.Const;

public class And extends ArithmeticExpression {
    public And(Expression leftExpression, Expression rightExpression, int sourceLine) {
        super(leftExpression, rightExpression, ArithmeticSign.AND, sourceLine);
    }

    public static And andWithoutSourceLine(Expression leftExpression, Expression rightExpression) {
        return new And(leftExpression, rightExpression, Const.MOCK_SOURCE_LINE);
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
        this.setValueInferResult(ValueInferUtils.calcValueInferResultForAndXorOr(this));
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof And)) {
            return false;
        }
        And andExpression = (And) o;
        return Objects.equals(getType(), andExpression.getType())
                && Objects.equals(getLeftExpression(), andExpression.getLeftExpression())
                && Objects.equals(getRightExpression(), andExpression.getRightExpression());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getLeftExpression(), getRightExpression());
    }
}
