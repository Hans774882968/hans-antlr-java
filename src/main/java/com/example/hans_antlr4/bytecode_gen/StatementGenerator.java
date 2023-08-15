package com.example.hans_antlr4.bytecode_gen;

import org.objectweb.asm.MethodVisitor;

import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.PrintStatement;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.statement.VariableDeclaration;

public class StatementGenerator {
    private MethodVisitor mv;
    private ExpressionGenerator expressionGenerator;

    public StatementGenerator(MethodVisitor mv) {
        this.mv = mv;
        expressionGenerator = new ExpressionGenerator(mv);
    }

    public void generate(Statement expression, Scope scope) {
        if (expression instanceof PrintStatement) {
            PrintStatement printStatement = (PrintStatement) expression;
            new PrintStatementGenerator().generate(mv, printStatement, scope);
        } else if (expression instanceof VariableDeclaration) {
            VariableDeclaration variableDeclaration = (VariableDeclaration) expression;
            new VariableDeclarationStatementGenerator().generate(mv, variableDeclaration, scope);
        } else if (expression instanceof Expression) {
            expressionGenerator.generate((Expression) expression, scope);
        }
    }
}
