package com.example.hans_antlr4.domain.statement;

import com.example.hans_antlr4.bytecode_gen.statement.StatementGenerator;
import com.example.hans_antlr4.data_processor.CheckOutsideLoopBreakContinueProcessor;
import com.example.hans_antlr4.data_processor.StatementTreeProcessor;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.Type;
import com.example.hans_antlr4.exception.UnsupportedRangedLoopTypesException;

import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Getter
@Setter
public class RangedForStatement extends Loop {
    private String iteratorVarName;
    private Expression startExpression;
    private Expression endExpression;
    private Statement iteratorVariableStatement;

    public RangedForStatement(
            Statement iteratorVariableStatement,
            String iteratorVarName,
            Expression startExpression,
            Expression endExpression,
            Statement bodyStatement,
            Scope scope) {
        super(bodyStatement, scope);
        this.iteratorVarName = iteratorVarName;
        this.startExpression = startExpression;
        this.endExpression = endExpression;
        this.iteratorVariableStatement = iteratorVariableStatement;
        // TODO: RangedForStatement 支持 long
        Type startExpressionType = startExpression.getType();
        Type endExpressionType = endExpression.getType();
        boolean typesAreIntegers = startExpressionType == BuiltInType.INT && endExpressionType == BuiltInType.INT;
        if (!typesAreIntegers) {
            throw new UnsupportedRangedLoopTypesException(startExpressionType, endExpressionType);
        }
    }

    public Type getEndExpressionType() {
        return endExpression.getType();
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
        if (!(o instanceof RangedForStatement)) {
            return false;
        }
        RangedForStatement rangedForStatement = (RangedForStatement) o;
        return Objects.equals(iteratorVarName, rangedForStatement.iteratorVarName)
                && Objects.equals(startExpression, rangedForStatement.startExpression)
                && Objects.equals(endExpression, rangedForStatement.endExpression)
                && Objects.equals(getBodyStatement(), rangedForStatement.getBodyStatement())
                && Objects.equals(getScope(), rangedForStatement.getScope())
                && Objects.equals(iteratorVariableStatement, rangedForStatement.iteratorVariableStatement)
                && Objects.equals(getOperationLabel(), rangedForStatement.getOperationLabel())
                && Objects.equals(getEndLoopLabel(), rangedForStatement.getEndLoopLabel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(iteratorVarName, startExpression, endExpression, getBodyStatement(), getScope(),
                iteratorVariableStatement, getOperationLabel(), getEndLoopLabel());
    }
}
