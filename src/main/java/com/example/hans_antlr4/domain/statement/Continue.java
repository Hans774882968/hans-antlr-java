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
    private Loop nearestLoopStatement;

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
            Loop nearestLoopStatement) {
        processor.processStatementTree(this, parent, nearestLoopStatement);
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
        return Objects.equals(nearestLoopStatement, continueStmt.nearestLoopStatement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nearestLoopStatement);
    }
}
