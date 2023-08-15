package com.example.hans_antlr4.domain.expression;

import com.example.hans_antlr4.domain.type.Type;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VarReference extends Expression {
    private String varName;

    public VarReference(String varName, Type type) {
        super(type);
        this.varName = varName;
    }
}
