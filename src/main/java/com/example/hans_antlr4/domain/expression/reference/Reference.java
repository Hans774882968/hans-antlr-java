package com.example.hans_antlr4.domain.expression.reference;

import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.type.Type;

import lombok.Getter;

@Getter
public abstract class Reference extends Expression {
    private String varName;

    public Reference(String varName, Type type, int sourceLine) {
        super(type, null, null, sourceLine, null);
        this.varName = varName;
        calculateValueInferResult();
    }
}
