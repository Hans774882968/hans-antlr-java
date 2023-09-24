package com.example.hans_antlr4.domain.scope;

import java.util.Objects;

import com.example.hans_antlr4.domain.type.Type;

import lombok.Data;

// 目前包含的字段与 src\main\java\com\example\hans_antlr4\domain\expression\VarReference.java 完全一致
@Data
public class LocalVariable extends Variable {
    public LocalVariable(String varName, Type type) {
        super(varName, type);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LocalVariable)) {
            return false;
        }
        LocalVariable localVariable = (LocalVariable) o;
        return Objects.equals(getVarName(), localVariable.getVarName())
                && Objects.equals(getType(), localVariable.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVarName(), getType());
    }
}
