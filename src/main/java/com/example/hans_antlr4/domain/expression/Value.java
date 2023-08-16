package com.example.hans_antlr4.domain.expression;

import com.example.hans_antlr4.bytecode_gen.ExpressionGenerator;
import com.example.hans_antlr4.domain.type.Type;

import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Setter
@Getter
public class Value extends Expression {
    private String value;

    public Value(Type type, String value) {
        super(type);
        this.value = value;
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
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
