package com.example.hans_antlr4.domain.expression;

import java.util.Objects;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.data_processor.ExpressionTreeProcessor;
import com.example.hans_antlr4.domain.global.ArithmeticSign;
import com.example.hans_antlr4.domain.statement.Statement;

public class Or extends ArithmeticExpression {
    public Or(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression, ArithmeticSign.OR);
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
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Or)) {
            return false;
        }
        Or orExpression = (Or) o;
        return Objects.equals(getType(), orExpression.getType())
                && Objects.equals(getLeftExpression(), orExpression.getLeftExpression())
                && Objects.equals(getRightExpression(), orExpression.getRightExpression());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getLeftExpression(), getRightExpression());
    }
}
