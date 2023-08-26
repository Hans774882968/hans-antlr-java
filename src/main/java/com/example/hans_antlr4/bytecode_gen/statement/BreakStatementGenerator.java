package com.example.hans_antlr4.bytecode_gen.statement;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.domain.statement.Break;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BreakStatementGenerator implements Opcodes {
    private MethodVisitor mv;

    public void generate(Break breakStatement) {
        mv.visitJumpInsn(GOTO, breakStatement.getNearestForStatement().getEndLoopLabel());
    }
}
