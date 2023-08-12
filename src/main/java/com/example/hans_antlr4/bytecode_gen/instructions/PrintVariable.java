package com.example.hans_antlr4.bytecode_gen.instructions;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.HansAntlrLexer;
import com.example.hans_antlr4.Variable;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PrintVariable implements Instruction, Opcodes {
    Variable variable;

    @Override
    public void apply(MethodVisitor mv) {
        int id = variable.getVarIndex();
        int type = variable.getVarType();
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        if (type == HansAntlrLexer.NUMBER) {
            mv.visitVarInsn(ILOAD, id);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
        }
        if (type == HansAntlrLexer.STRING) {
            mv.visitVarInsn(ALOAD, id);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        }
    }
}
