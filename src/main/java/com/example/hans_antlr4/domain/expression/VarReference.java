package com.example.hans_antlr4.domain.expression;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.domain.type.Type;

import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Setter
@Getter
public class VarReference extends Expression {
    private String varName;

    public VarReference(String varName, Type type) {
        super(type);
        this.varName = varName;
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof VarReference)) {
            return false;
        }
        VarReference varReference = (VarReference) o;
        return Objects.equals(getType(), varReference.getType()) && Objects.equals(varName, varReference.varName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), varName);
    }
}
