package com.example.hans_antlr4.bytecode_gen.statement;

import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.MethodVisitor;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.IfStatement;
import com.example.hans_antlr4.domain.statement.StatementAfterIf;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class IfStatementGenerator implements Opcodes {
    private MethodVisitor mv;
    private Scope scope;

    public void generate(IfStatement ifStatement) {
        Expression condition = ifStatement.getCondition();
        condition.accept(new ExpressionGenerator(mv, scope));
        Label trueLabel = new Label();
        Label endLabel = new Label();
        mv.visitJumpInsn(IFNE, trueLabel);

        ifStatement.getFalseStatement().ifPresent(falseStatement -> {
            StatementGenerator statementGenerator = new StatementGenerator(mv, falseStatement.getNewScope());
            falseStatement.accept(statementGenerator);
        });

        mv.visitJumpInsn(GOTO, endLabel);
        mv.visitLabel(trueLabel);
        StatementAfterIf trueStatement = ifStatement.getTrueStatement();
        StatementGenerator statementGenerator = new StatementGenerator(mv, trueStatement.getNewScope());
        trueStatement.accept(statementGenerator);
        mv.visitLabel(endLabel);
    }
}
