package com.example.hans_antlr4.domain.statement;

import com.example.hans_antlr4.bytecode_gen.statement.StatementGenerator;
import com.example.hans_antlr4.data_processor.StatementTreeProcessor;
import com.example.hans_antlr4.domain.expression.Expression;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Objects;

@AllArgsConstructor
@Data
public class PrintStatement extends Statement {
    private Expression expression;

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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PrintStatement)) {
            return false;
        }
        PrintStatement printStatement = (PrintStatement) o;
        return Objects.equals(expression, printStatement.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression);
    }
}
