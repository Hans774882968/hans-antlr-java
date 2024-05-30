package com.example.hans_antlr4.domain.expression;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.data_processor.ExpressionTreeProcessor;
import com.example.hans_antlr4.domain.global.ValueInferResult;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.type.Type;
import com.example.hans_antlr4.utils.Const;

import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Setter
@Getter
public class Value extends Expression {
    private String value;

    public Value(Type type, String value, int sourceLine) {
        super(type, null, null, sourceLine, null);
        this.value = value;
        calculateValueInferResult();
    }

    public static Value valueWithoutSourceLine(Type type, String value) {
        return new Value(type, value, Const.MOCK_SOURCE_LINE);
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
        this.setValueInferResult(new ValueInferResult(true, this));
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Value)) {
            return false;
        }
        Value val = (Value) o;
        return Objects.equals(getType(), val.getType()) && Objects.equals(value, val.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), value);
    }
}
