package com.example.hans_antlr4.bytecode_gen.statement;

import java.util.Optional;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.StandardForStatement;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StandardForStatementGenerator implements Opcodes {
    private MethodVisitor mv;
    private boolean constantFolding;

    public void generate(StandardForStatement standardForStatement) {
        final Scope newScope = standardForStatement.getScope();
        ExpressionGenerator expressionGenerator = new ExpressionGenerator(mv, newScope, constantFolding);
        StatementGenerator statementGenerator = new StatementGenerator(mv, newScope, constantFolding);
        Optional<Expression> nullableShouldEndLoopExpression = standardForStatement.getShouldEndLoopExpression();

        // 1. 生成 forInit
        standardForStatement.getStandardForInit().ifPresent(forInit -> {
            forInit.accept(statementGenerator);
        });

        // 2. 生成 GOTO 结束条件判断区的 label
        Label conditionLabel = new Label();
        if (nullableShouldEndLoopExpression.isPresent()) {
            mv.visitJumpInsn(GOTO, conditionLabel);
        }

        // 3. 方法体
        Label bodyLabel = new Label();
        mv.visitLabel(bodyLabel);
        standardForStatement.getBodyStatement().accept(statementGenerator);

        // 4. 生成 forUpdate
        mv.visitLabel(standardForStatement.getOperationLabel());
        standardForStatement.getStandardForUpdate().ifPresent(forUpdate -> {
            forUpdate.accept(statementGenerator);
        });

        // 5. 生成条件判断
        if (nullableShouldEndLoopExpression.isPresent()) {
            mv.visitLabel(conditionLabel);
            standardForStatement.getShouldEndLoopExpression().ifPresent(shouldEndLoopExpression -> {
                shouldEndLoopExpression.accept(expressionGenerator);
            });
            mv.visitJumpInsn(IFEQ, standardForStatement.getEndLoopLabel());
        }

        mv.visitJumpInsn(GOTO, bodyLabel);

        mv.visitLabel(standardForStatement.getEndLoopLabel());
    }
}
