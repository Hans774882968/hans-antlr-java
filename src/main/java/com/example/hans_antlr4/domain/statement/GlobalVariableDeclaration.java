package com.example.hans_antlr4.domain.statement;

import com.example.hans_antlr4.bytecode_gen.statement.StatementGenerator;
import com.example.hans_antlr4.domain.expression.Expression;

public class GlobalVariableDeclaration extends VariableDeclaration {
    public GlobalVariableDeclaration(String name, Expression expression) {
        super(name, expression);
    }

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }
}
