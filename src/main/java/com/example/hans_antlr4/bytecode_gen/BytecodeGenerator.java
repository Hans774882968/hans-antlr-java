package com.example.hans_antlr4.bytecode_gen;

import java.util.Queue;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.bytecode_gen.instructions.Instruction;
import com.example.hans_antlr4.bytecode_gen.instructions.VariableDeclaration;

public class BytecodeGenerator implements Opcodes {
    public byte[] generateBytecode(Queue<Instruction> instructionQueue, String name) {
        ClassWriter cw = new ClassWriter(0);
        MethodVisitor mv;
        // version, access, name, signature, base class, interfaces
        cw.visit(52, ACC_PUBLIC + ACC_SUPER, name, null, "java/lang/Object", null);
        {
            // declare static void main
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            final long localVariablesCount = instructionQueue.stream()
                    .filter(instruction -> instruction instanceof VariableDeclaration)
                    .count();
            final int maxStack = 100; // TODO: do that properly

            // apply instructions generated from traversing parse tree!
            for (Instruction instruction : instructionQueue) {
                instruction.apply(mv);
            }
            mv.visitInsn(RETURN); // add return instruction

            mv.visitMaxs(maxStack, (int) localVariablesCount); // set max stack and max local variables
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}
