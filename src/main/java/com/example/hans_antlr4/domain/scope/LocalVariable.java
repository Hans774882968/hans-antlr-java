package com.example.hans_antlr4.domain.scope;

import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.type.Type;

import lombok.Getter;
import lombok.Setter;

// 目前实现与 src\main\java\com\example\hans_antlr4\domain\expression\VarReference.java 完全一致
@Setter
@Getter
public class LocalVariable extends Expression {
    private String varName;

    public LocalVariable(String varName, Type type) {
        super(type);
        this.varName = varName;
    }
}
