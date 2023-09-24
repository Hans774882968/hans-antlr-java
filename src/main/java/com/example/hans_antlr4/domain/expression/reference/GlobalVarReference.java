package com.example.hans_antlr4.domain.expression.reference;

import java.util.Objects;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.data_processor.ExpressionTreeProcessor;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.type.Type;

public class GlobalVarReference extends Reference {
    public GlobalVarReference(String varName, Type type) {
        super(varName, type);
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
        if (!(o instanceof GlobalVarReference)) {
            return false;
        }
        GlobalVarReference globalVarReference = (GlobalVarReference) o;
        return Objects.equals(getType(), globalVarReference.getType())
                && Objects.equals(getVarName(), globalVarReference.getVarName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getVarName());
    }
}
