package com.example.hans_antlr4.domain.statement;

import java.util.Objects;
import java.util.Optional;

import com.example.hans_antlr4.bytecode_gen.statement.StatementGenerator;
import com.example.hans_antlr4.data_processor.CheckOutsideLoopBreakContinueProcessor;
import com.example.hans_antlr4.data_processor.StatementTreeProcessor;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.scope.Scope;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StandardForStatement extends Loop {
    private Optional<Statement> standardForInit;
    private Optional<Expression> shouldEndLoopExpression;
    private Optional<Statement> standardForUpdate;

    public StandardForStatement(
            Statement standardForInit,
            Expression shouldEndLoopExpression,
            Statement standardForUpdate,
            Statement bodyStatement,
            Scope scope) {
        super(bodyStatement, scope);
        this.standardForInit = Optional.ofNullable(standardForInit);
        this.shouldEndLoopExpression = Optional.ofNullable(shouldEndLoopExpression);
        this.standardForUpdate = Optional.ofNullable(standardForUpdate);
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
        if (!(o instanceof StandardForStatement)) {
            return false;
        }
        StandardForStatement standardForStatement = (StandardForStatement) o;
        return Objects.equals(standardForInit, standardForStatement.standardForInit)
                && Objects.equals(shouldEndLoopExpression, standardForStatement.shouldEndLoopExpression)
                && Objects.equals(standardForUpdate, standardForStatement.standardForUpdate)
                && Objects.equals(getBodyStatement(), standardForStatement.getBodyStatement())
                && Objects.equals(getScope(), standardForStatement.getScope())
                && Objects.equals(getOperationLabel(), standardForStatement.getOperationLabel())
                && Objects.equals(getEndLoopLabel(), standardForStatement.getEndLoopLabel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(standardForInit, shouldEndLoopExpression, standardForUpdate,
                getBodyStatement(), getScope(), getOperationLabel(), getEndLoopLabel());
    }
}
