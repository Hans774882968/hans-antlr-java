package com.example.hans_antlr4.domain.expression.unary;

import java.util.Objects;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.data_processor.ExpressionTreeProcessor;
import com.example.hans_antlr4.domain.expression.Expression;

public class UnaryPositive extends Unary {
    public UnaryPositive(Expression expression) {
        super(expression.getType(), expression);
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }

    @Override
    public void processSubExpressionTree(ExpressionTreeProcessor processor, Expression parent) {
        processor.processExpressionTree(this, parent);
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
