package com.example.hans_antlr4.domain.expression.unary;

import java.util.Objects;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.data_processor.ExpressionTreeProcessor;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.statement.Statement;

public class UnaryTilde extends Unary {
    public UnaryTilde(Expression expression) {
        super(expression.getType(), expression);
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
        if (!(o instanceof UnaryTilde)) {
            return false;
        }
        UnaryTilde unaryTilde = (UnaryTilde) o;
        return Objects.equals(getType(), unaryTilde.getType())
                && Objects.equals(getExpression(), unaryTilde.getExpression());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getExpression());
    }
}
