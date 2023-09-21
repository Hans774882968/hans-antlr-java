package com.example.hans_antlr4.domain.expression;

import java.util.List;
import java.util.Objects;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.data_processor.ExpressionTreeProcessor;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.exception.IllegalTemplateStringException;

import lombok.Getter;

@Getter
public class TemplateString extends Expression {
    private List<String> strs;
    private List<Expression> expressions;

    public TemplateString(List<String> strs, List<Expression> expressions) {
        super(BuiltInType.STRING, null, null);
        this.strs = strs;
        this.expressions = expressions;
        if (strs.size() != expressions.size() + 1) {
            throw new IllegalTemplateStringException(strs, expressions);
        }
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
        if (!(o instanceof TemplateString)) {
            return false;
        }
        TemplateString templateString = (TemplateString) o;
        return Objects.equals(getType(), templateString.getType())
                && Objects.equals(strs, templateString.strs)
                && Objects.equals(expressions, templateString.expressions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), strs, expressions);
    }
}
