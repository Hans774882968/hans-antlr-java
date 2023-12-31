package com.example.hans_antlr4.domain.expression;

import java.util.Objects;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.data_processor.ExpressionTreeProcessor;
import com.example.hans_antlr4.domain.global.ArithmeticSign;
import com.example.hans_antlr4.domain.statement.Statement;

public class Multiplication extends Multiplicative {
    public Multiplication(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression, ArithmeticSign.MUL);
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
        if (!(o instanceof Multiplication)) {
            return false;
        }
        Multiplication multiplication = (Multiplication) o;
        return Objects.equals(getType(), multiplication.getType())
                && Objects.equals(getLeftExpression(), multiplication.getLeftExpression())
                && Objects.equals(getRightExpression(), multiplication.getRightExpression());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getLeftExpression(), getRightExpression());
    }
}
