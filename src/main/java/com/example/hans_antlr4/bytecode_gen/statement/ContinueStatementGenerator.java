package com.example.hans_antlr4.bytecode_gen.statement;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.domain.statement.Continue;
import com.example.hans_antlr4.exception.ContinueStatementOutsideLoopException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ContinueStatementGenerator implements Opcodes {
    private MethodVisitor mv;

    public void generate(Continue continueStatement) {
        if (continueStatement.getNearestLoopStatement() == null) {
            throw new ContinueStatementOutsideLoopException(continueStatement.getSourceLine());
        }
        mv.visitJumpInsn(GOTO, continueStatement.getNearestLoopStatement().getOperationLabel());
    }
}
