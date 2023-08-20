package com.example.hans_antlr4.domain.statement;

import com.example.hans_antlr4.bytecode_gen.statement.StatementGenerator;

public interface Statement {
    void accept(StatementGenerator generator);
}
