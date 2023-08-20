package com.example.hans_antlr4.domain.statement;

import java.util.Optional;

import com.example.hans_antlr4.bytecode_gen.StatementGenerator;
import com.example.hans_antlr4.domain.expression.Expression;

import lombok.Getter;

@Getter
public class IfStatement implements Statement {
    private final Expression condition;
    private final StatementAfterIf trueStatement;
    private final Optional<StatementAfterIf> falseStatement;

    public IfStatement(Expression condition, StatementAfterIf trueStatement, StatementAfterIf falseStatement) {
        this.condition = condition;
        this.trueStatement = trueStatement;
        this.falseStatement = Optional.ofNullable(falseStatement);
    }

    public IfStatement(Expression condition, StatementAfterIf trueStatement) {
        this.condition = condition;
        this.trueStatement = trueStatement;
        this.falseStatement = Optional.empty();
    }

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }

    public Optional<StatementAfterIf> getFalseStatement() {
        return falseStatement;
    }
}