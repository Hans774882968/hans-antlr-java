package com.example.hans_antlr4.bytecode_gen.instructions;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.HansAntlrLexer;
import com.example.hans_antlr4.Variable;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class VariableDeclaration implements Instruction, Opcodes {
    Variable variable;

    @Override
    public void apply(MethodVisitor mv) {
        final int type = variable.getVarType();
        if (type == HansAntlrLexer.NUMBER) {
            int val = Integer.valueOf(variable.getVarTextValue());
            mv.visitIntInsn(SIPUSH, val);
            mv.visitVarInsn(ISTORE, variable.getVarIndex());
        }
        if (type == HansAntlrLexer.STRING) {
            mv.visitLdcInsn(variable.getVarTextValue());
            mv.visitVarInsn(ASTORE, variable.getVarIndex());
        }
    }
}
