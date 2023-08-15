package com.example.hans_antlr4.domain.statement;

import com.example.hans_antlr4.domain.expression.Expression;

import lombok.Data;

@Data
public class VariableDeclaration implements Statement {
    private String name;
    private Expression expression;

    public VariableDeclaration(String name, Expression expression) {
        this.name = name;
        this.expression = expression;
    }
}
