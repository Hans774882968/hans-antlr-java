package com.example.hans_antlr4.domain.expression;

import com.example.hans_antlr4.bytecode_gen.ExpressionGenerator;
import com.example.hans_antlr4.domain.type.Type;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class Expression {
    private Type type;

    public abstract void accept(ExpressionGenerator generator);
}
