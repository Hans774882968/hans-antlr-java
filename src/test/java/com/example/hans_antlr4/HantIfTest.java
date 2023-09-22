package com.example.hans_antlr4;

import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Test;
import org.mockito.InOrder;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.exception.func.MainMethodNotFoundInPublicClass;

public class HantIfTest implements Opcodes {
    @Test
    public void relationalExpressionTest() throws MainMethodNotFoundInPublicClass {
        List<Statement> statements = TestUtils.getStatementsFromCode("if 20 % 12 <= 8 {}");
        MethodVisitor mv = TestUtils.mockGenerateBytecode(statements);
        InOrder inOrder = inOrder(mv);
        inOrder.verify(mv).visitIntInsn(eq(BIPUSH), eq(20));
        inOrder.verify(mv).visitIntInsn(eq(BIPUSH), eq(12));
        inOrder.verify(mv).visitInsn(eq(IREM));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitIntInsn(eq(BIPUSH), eq(8));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitInsn(eq(ISUB));
        inOrder.verify(mv).visitJumpInsn(eq(IFGT), isA(Label.class));
        inOrder.verify(mv).visitJumpInsn(eq(GOTO), isA(Label.class));
    }

    @Test
    public void equalityExpressionTest() throws MainMethodNotFoundInPublicClass {
        List<Statement> statements = TestUtils.getStatementsFromCode("if 21 % 12 == -1 + 10 {}");
        MethodVisitor mv = TestUtils.mockGenerateBytecode(statements);
        InOrder inOrder = inOrder(mv);
        inOrder.verify(mv).visitIntInsn(eq(BIPUSH), eq(21));
        inOrder.verify(mv).visitIntInsn(eq(BIPUSH), eq(12));
        inOrder.verify(mv).visitInsn(eq(IREM));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitInsn(eq(ICONST_1));
        inOrder.verify(mv).visitInsn(eq(INEG));
        inOrder.verify(mv).visitIntInsn(eq(BIPUSH), eq(10));
        inOrder.verify(mv).visitInsn(eq(IADD));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitInsn(eq(ISUB));
        inOrder.verify(mv).visitJumpInsn(eq(IFNE), isA(Label.class));
        inOrder.verify(mv).visitJumpInsn(eq(GOTO), isA(Label.class));
    }

    @Test
    public void confirmNewScopeCreatedTest() throws MainMethodNotFoundInPublicClass {
        List<Statement> statements = TestUtils.getStatementsFromCode(
                "if 123 { var x = 10 if 456 var x = 12 else var x = 15 } var x = 20");
        MethodVisitor mv = TestUtils.mockGenerateBytecode(statements);

        verify(mv, times(1)).visitIntInsn(eq(Opcodes.BIPUSH), eq(10));
        verify(mv, times(1)).visitIntInsn(eq(Opcodes.BIPUSH), eq(12));
        verify(mv, times(1)).visitIntInsn(eq(Opcodes.BIPUSH), eq(15));
        verify(mv, times(1)).visitIntInsn(eq(Opcodes.BIPUSH), eq(20));
        verify(mv, times(2)).visitVarInsn(eq(Opcodes.ISTORE), eq(0));
        verify(mv, times(2)).visitVarInsn(eq(Opcodes.ISTORE), eq(1));
        verify(mv, times(0)).visitVarInsn(eq(Opcodes.ISTORE), eq(2));
    }

    @Test
    public void booleanInIf() throws MainMethodNotFoundInPublicClass {
        List<Statement> statements = TestUtils.getStatementsFromCode(
                "if true { print 1 }");
        MethodVisitor mv = TestUtils.mockGenerateBytecode(statements);

        InOrder inOrder = inOrder(mv);

        inOrder.verify(mv).visitLdcInsn(eq(true));
        inOrder.verify(mv).visitJumpInsn(eq(IFNE), isA(Label.class));
        inOrder.verify(mv).visitJumpInsn(eq(GOTO), isA(Label.class));
        inOrder.verify(mv).visitFieldInsn(
                eq(GETSTATIC),
                eq("java/lang/System"),
                eq("out"),
                eq("Ljava/io/PrintStream;"));
        inOrder.verify(mv).visitInsn(eq(ICONST_1));
        inOrder.verify(mv).visitMethodInsn(
                eq(INVOKEVIRTUAL),
                eq("java/io/PrintStream"),
                eq("println"),
                eq("(I)V"),
                eq(false));
    }
}
