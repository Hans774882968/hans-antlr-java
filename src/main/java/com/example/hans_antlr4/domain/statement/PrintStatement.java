package com.example.hans_antlr4.domain.statement;

import com.example.hans_antlr4.bytecode_gen.StatementGenerator;
import com.example.hans_antlr4.domain.expression.Expression;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PrintStatement implements Statement {
    private Expression expression;

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }
}
