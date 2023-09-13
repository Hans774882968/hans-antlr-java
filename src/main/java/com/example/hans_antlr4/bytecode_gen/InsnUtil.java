package com.example.hans_antlr4.bytecode_gen;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class InsnUtil implements Opcodes {
    public static void generateIntInsn(MethodVisitor mv, int intValue) {
        if (intValue == -1) {
            mv.visitInsn(ICONST_M1);
        } else if (intValue == 0) {
            mv.visitInsn(ICONST_0);
        } else if (intValue == 1) {
            mv.visitInsn(ICONST_1);
        } else if (intValue == 2) {
            mv.visitInsn(ICONST_2);
        } else if (intValue == 3) {
            mv.visitInsn(ICONST_3);
        } else if (intValue == 4) {
            mv.visitInsn(ICONST_4);
        } else if (intValue == 5) {
            mv.visitInsn(ICONST_5);
        } else if (Byte.MIN_VALUE <= intValue && intValue <= Byte.MAX_VALUE) {
            mv.visitIntInsn(BIPUSH, intValue);
        } else if (Short.MIN_VALUE <= intValue && intValue <= Short.MAX_VALUE) {
            mv.visitIntInsn(SIPUSH, intValue);
        } else {
            mv.visitLdcInsn(intValue);
        }
    }
}
