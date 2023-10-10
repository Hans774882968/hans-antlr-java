package com.example.hans_antlr4.domain.statement.var;

import com.example.hans_antlr4.bytecode_gen.statement.StatementGenerator;
import com.example.hans_antlr4.data_processor.CheckOutsideLoopBreakContinueProcessor;
import com.example.hans_antlr4.data_processor.StatementTreeProcessor;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.statement.Loop;
import com.example.hans_antlr4.domain.statement.Statement;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Getter
public class VariableDeclaration extends Statement {
    private List<VarDefUnit> varDefUnits;

    public VariableDeclaration(String name, Expression expression) {
        this.varDefUnits = Arrays.asList(new VarDefUnit(name, expression));
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
        if (!(o instanceof VariableDeclaration)) {
            return false;
        }
        VariableDeclaration variableDeclaration = (VariableDeclaration) o;
        return Objects.equals(varDefUnits, variableDeclaration.varDefUnits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(varDefUnits);
    }
}
