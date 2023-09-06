package com.example.hans_antlr4.domain.statement;

import com.example.hans_antlr4.bytecode_gen.statement.StatementGenerator;
import com.example.hans_antlr4.data_processor.CheckOutsideLoopBreakContinueProcessor;
import com.example.hans_antlr4.data_processor.StatementTreeProcessor;
import com.example.hans_antlr4.domain.expression.Expression;

import lombok.Data;
import java.util.Objects;

@Data
public class PrintStatement extends Statement {
    private Expression expression;
    private boolean shouldNotPrintLine;

    public PrintStatement(Expression expression) {
        this.expression = expression;
        this.shouldNotPrintLine = false;
    }

    public PrintStatement(Expression expression, String printArg) {
        this.expression = expression;
        this.shouldNotPrintLine = printArg.equals("-n");
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
