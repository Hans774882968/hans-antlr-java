package com.example.hans_antlr4.domain.expression;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.data_processor.ExpressionTreeProcessor;
import com.example.hans_antlr4.domain.global.ArithmeticSign;
import com.example.hans_antlr4.domain.statement.Statement;

import java.util.Objects;

public class Subtraction extends Additive {
    public Subtraction(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression, ArithmeticSign.MINUS);
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
        if (!(o instanceof Subtraction)) {
            return false;
        }
        Subtraction subtraction = (Subtraction) o;
        return Objects.equals(getType(), subtraction.getType())
                && Objects.equals(getLeftExpression(), subtraction.getLeftExpression())
                && Objects.equals(getRightExpression(), subtraction.getRightExpression());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getLeftExpression(), getRightExpression());
    }
}
