package com.example.hans_antlr4.domain.statement;

import org.objectweb.asm.Label;

import com.example.hans_antlr4.bytecode_gen.statement.StatementGenerator;
import com.example.hans_antlr4.data_processor.StatementTreeProcessor;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.type.Type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RangedForStatement extends Statement {
    private String iteratorVarName;
    private Expression startExpression;
    private Expression endExpression;
    private Statement bodyStatement;
    private Scope scope;
    private Statement iteratorVariableStatement;
    private Label operationLabel;
    private Label endLoopLabel;

    public RangedForStatement(
            Statement iteratorVariableStatement,
            String iteratorVarName,
            Expression startExpression,
            Expression endExpression,
            Statement bodyStatement,
            Scope scope) {
        this.iteratorVarName = iteratorVarName;
        this.startExpression = startExpression;
        this.endExpression = endExpression;
        this.bodyStatement = bodyStatement;
        this.scope = scope;
        this.iteratorVariableStatement = iteratorVariableStatement;
        this.operationLabel = new Label();
        this.endLoopLabel = new Label();
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

    public Type getEndExpressionType() {
        return endExpression.getType();
    }
}
