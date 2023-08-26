package com.example.hans_antlr4.domain.statement;

import java.util.Optional;

import com.example.hans_antlr4.bytecode_gen.statement.StatementGenerator;
import com.example.hans_antlr4.data_processor.StatementTreeProcessor;
import com.example.hans_antlr4.domain.expression.Expression;

import lombok.Getter;
import java.util.Objects;

@Getter
public class IfStatement extends Statement {
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

    @Override
    public void processSubStatementTree(
            StatementTreeProcessor processor,
            Statement parent,
            RangedForStatement nearestForStatement) {
        processor.processStatementTree(this, parent, nearestForStatement);
    }

    public Optional<StatementAfterIf> getFalseStatement() {
        return falseStatement;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof IfStatement)) {
            return false;
        }
        IfStatement ifStatement = (IfStatement) o;
        return Objects.equals(condition, ifStatement.condition)
                && Objects.equals(trueStatement, ifStatement.trueStatement)
                && Objects.equals(falseStatement, ifStatement.falseStatement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(condition, trueStatement, falseStatement);
    }
}
