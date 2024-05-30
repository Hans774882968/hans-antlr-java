package com.example.hans_antlr4.domain.scope;

import com.example.hans_antlr4.domain.global.ValueInferResult;
import com.example.hans_antlr4.domain.type.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Variable {
    private String varName;
    private Type type;
    private ValueInferResult valueInferResult;
}
