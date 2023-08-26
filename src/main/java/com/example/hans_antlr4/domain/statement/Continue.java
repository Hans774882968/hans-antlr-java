package com.example.hans_antlr4.domain.statement;

import com.example.hans_antlr4.bytecode_gen.statement.StatementGenerator;
import com.example.hans_antlr4.data_processor.CheckOutsideLoopBreakContinueProcessor;
import com.example.hans_antlr4.data_processor.StatementTreeProcessor;

import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Getter
@Setter
public class Continue extends Statement {
    private int sourceLine;
    private RangedForStatement nearestForStatement;

    public Continue(int sourceLine) {
        this.sourceLine = sourceLine;
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

    @Override
    public void checkOutsideLoopBreakContinue(
            CheckOutsideLoopBreakContinueProcessor processor) {
        processor.check(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Continue)) {
            return false;
        }
        Continue continueStmt = (Continue) o;
        return Objects.equals(nearestForStatement, continueStmt.nearestForStatement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nearestForStatement);
    }
}
