package com.example.hans_antlr4.domain.statement;

import java.util.Collections;
import java.util.List;

import com.example.hans_antlr4.bytecode_gen.StatementGenerator;
import com.example.hans_antlr4.domain.scope.Scope;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Block implements Statement {
    private final List<Statement> statements;
    private final Scope scope;

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }

    public List<Statement> getStatements() {
        return Collections.unmodifiableList(statements);
    }
}
