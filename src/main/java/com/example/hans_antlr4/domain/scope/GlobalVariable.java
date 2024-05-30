package com.example.hans_antlr4.domain.scope;

import lombok.Getter;
import java.util.Objects;

import com.example.hans_antlr4.domain.global.ValueInferResult;
import com.example.hans_antlr4.domain.type.Type;

@Getter
public class GlobalVariable extends Variable {
    public GlobalVariable(String varName, Type type, ValueInferResult valueInferResult) {
        super(varName, type, valueInferResult);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GlobalVariable)) {
            return false;
        }
        GlobalVariable globalVariable = (GlobalVariable) o;
        return Objects.equals(getVarName(), globalVariable.getVarName())
                && Objects.equals(getType(), globalVariable.getType())
                && Objects.equals(getValueInferResult(), globalVariable.getValueInferResult());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVarName(), getType(), getValueInferResult());
    }
}
