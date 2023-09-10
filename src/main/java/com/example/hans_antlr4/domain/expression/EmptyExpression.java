package com.example.hans_antlr4.domain.expression;

import java.util.Objects;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.data_processor.ExpressionTreeProcessor;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.type.Type;

import lombok.Getter;

@Getter
public class EmptyExpression extends Expression {
    public EmptyExpression(Type type) {
        super(type, null, null);
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
        if (!(o instanceof EmptyExpression)) {
            return false;
        }
        EmptyExpression emptyExpression = (EmptyExpression) o;
        return Objects.equals(getType(), emptyExpression.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType());
    }
}
