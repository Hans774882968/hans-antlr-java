package com.example.hans_antlr4.domain.statement.var;

import java.util.List;

import com.example.hans_antlr4.bytecode_gen.statement.StatementGenerator;

public class GlobalVariableDeclaration extends VariableDeclaration {
    public GlobalVariableDeclaration(List<VarDefUnit> varDefUnits) {
        super(varDefUnits);
    }

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }
}
