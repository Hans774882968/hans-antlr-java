package com.example.hans_antlr4.func;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.inOrder;

import org.junit.Test;
import org.mockito.InOrder;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.TestUtils;

public class ReturnVoidTest implements Opcodes {
    @Test
    public void functionBodyHasNoStatement() {
        MethodVisitor mv = TestUtils.mockGenerateOneFunction("void voidFn() {}");
        InOrder inOrder = inOrder(mv);

        inOrder.verify(mv).visitCode();
        inOrder.verify(mv).visitInsn(eq(RETURN));
        inOrder.verify(mv).visitMaxs(eq(-1), eq(-1));
        inOrder.verify(mv).visitEnd();
    }

    @Test
    public void returnVoidFunctionBodyHasOneReturnStatement() {
        MethodVisitor mv = TestUtils.mockGenerateOneFunction("void voidFn() {return}");
        InOrder inOrder = inOrder(mv);

        inOrder.verify(mv).visitCode();
        inOrder.verify(mv).visitInsn(eq(RETURN));
        inOrder.verify(mv).visitMaxs(eq(-1), eq(-1));
        inOrder.verify(mv).visitEnd();
    }
}
