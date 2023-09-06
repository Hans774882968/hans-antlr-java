package com.example.hans_antlr4.type;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.inOrder;

import java.util.List;

import org.junit.Test;
import org.mockito.InOrder;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.TestUtils;
import com.example.hans_antlr4.domain.global.MetaData;
import com.example.hans_antlr4.domain.scope.LocalVariable;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.type.BuiltInType;

public class ExpressionTypeCastTest implements Opcodes {
    @Test
    public void arithmeticExpressionTypeCastTest() {
        List<Statement> statements = TestUtils.getStatementsFromCode(
                "var tmpL = 0x3fl\nvar tmpD = 0.3\nprint tmpL * 4 % tmpD");
        Scope scope = new Scope(new MetaData(null));
        scope.addLocalVariables(
                new LocalVariable("tmpL", BuiltInType.LONG),
                new LocalVariable("tmpD", BuiltInType.DOUBLE));
        MethodVisitor mv = TestUtils.mockGenerateBytecode(statements, scope);
        InOrder inOrder = inOrder(mv);

        inOrder.verify(mv).visitLdcInsn(eq(63L));
        inOrder.verify(mv).visitVarInsn(eq(LSTORE), eq(0));
        inOrder.verify(mv).visitLdcInsn(eq(0.3));
        inOrder.verify(mv).visitVarInsn(eq(DSTORE), eq(2));

        inOrder.verify(mv).visitFieldInsn(
                eq(GETSTATIC),
                eq("java/lang/System"),
                eq("out"),
                eq("Ljava/io/PrintStream;"));
        inOrder.verify(mv).visitVarInsn(eq(LLOAD), eq(0));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitInsn(eq(ICONST_4));
        inOrder.verify(mv).visitInsn(eq(I2L));
        inOrder.verify(mv).visitInsn(eq(LMUL));
        inOrder.verify(mv).visitInsn(eq(L2D));
        inOrder.verify(mv).visitVarInsn(eq(DLOAD), eq(2));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitInsn(eq(DREM));
        inOrder.verify(mv).visitMethodInsn(
                eq(INVOKEVIRTUAL),
                eq("java/io/PrintStream"),
                eq("println"),
                eq("(D)V"),
                eq(false));
    }

    @Test
    public void shiftExpressionTypeCastTest() {
        List<Statement> statements = TestUtils.getStatementsFromCode(
                "var tmpL = 0b10010l\nvar tmpI = 3\nprint (tmpL >> (tmpI << tmpL)) >>> tmpI");
        Scope scope = new Scope(new MetaData(null));
        scope.addLocalVariables(
                new LocalVariable("tmpL", BuiltInType.LONG),
                new LocalVariable("tmpI", BuiltInType.INT));
        MethodVisitor mv = TestUtils.mockGenerateBytecode(statements, scope);
        InOrder inOrder = inOrder(mv);

        inOrder.verify(mv).visitLdcInsn(eq(18L));
        inOrder.verify(mv).visitVarInsn(eq(LSTORE), eq(0));
        inOrder.verify(mv).visitInsn(eq(ICONST_3));
        inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(2));

        inOrder.verify(mv).visitFieldInsn(
                eq(GETSTATIC),
                eq("java/lang/System"),
                eq("out"),
                eq("Ljava/io/PrintStream;"));

        inOrder.verify(mv).visitVarInsn(eq(LLOAD), eq(0));

        inOrder.verify(mv).visitVarInsn(eq(ILOAD), eq(2));
        inOrder.verify(mv).visitVarInsn(eq(LLOAD), eq(0));
        inOrder.verify(mv).visitInsn(eq(L2I));
        inOrder.verify(mv).visitInsn(eq(ISHL));
        inOrder.verify(mv).visitInsn(eq(NOP));

        inOrder.verify(mv).visitInsn(eq(LSHR));

        inOrder.verify(mv).visitVarInsn(eq(ILOAD), eq(2));
        inOrder.verify(mv).visitInsn(eq(NOP));

        inOrder.verify(mv).visitInsn(eq(LUSHR));

        inOrder.verify(mv).visitMethodInsn(
                eq(INVOKEVIRTUAL),
                eq("java/io/PrintStream"),
                eq("println"),
                eq("(J)V"),
                eq(false));
    }
}
