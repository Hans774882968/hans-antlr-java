package com.example.hans_antlr4.domain.scope;

import java.util.Objects;

import com.example.hans_antlr4.domain.type.Type;

import lombok.AllArgsConstructor;
import lombok.Data;

// 目前包含的字段与 src\main\java\com\example\hans_antlr4\domain\expression\VarReference.java 完全一致
@AllArgsConstructor
@Data
public class LocalVariable {
    private String varName;
    private Type type;

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LocalVariable)) {
            return false;
        }
        LocalVariable localVariable = (LocalVariable) o;
        return Objects.equals(varName, localVariable.varName) && Objects.equals(type, localVariable.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(varName, type);
    }
}
