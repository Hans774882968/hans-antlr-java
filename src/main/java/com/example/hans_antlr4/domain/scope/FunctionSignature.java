package com.example.hans_antlr4.domain.scope;

import java.util.Collections;
import java.util.List;

import com.example.hans_antlr4.domain.expression.Parameter;
import com.example.hans_antlr4.domain.type.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FunctionSignature {
    private final String name;
    private final List<Parameter> parameters;
    private final Type returnType;

    public List<Parameter> getParameters() {
        return Collections.unmodifiableList(parameters);
    }
}
