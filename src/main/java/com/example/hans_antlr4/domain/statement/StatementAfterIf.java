package com.example.hans_antlr4.domain.statement;

import com.example.hans_antlr4.bytecode_gen.StatementGenerator;
import com.example.hans_antlr4.domain.scope.Scope;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StatementAfterIf implements Statement {
    private final Scope newScope;
    private final Statement statement;

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }
}
