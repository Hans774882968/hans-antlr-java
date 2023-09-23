package com.example.hans_antlr4.array;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;

import java.util.List;

import org.junit.Test;
import org.mockito.InOrder;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.TestUtils;
import com.example.hans_antlr4.domain.global.Function;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.exception.func.MainMethodNotFoundInPublicClass;

public class ArrayLiteralTest implements Opcodes {
    @Test
    public void string2dTest() throws MainMethodNotFoundInPublicClass {
        Function mainMethod = TestUtils.getMainMethodFromCode(
                "var a = [[\"a\", `cm`], [new java.lang.String(`er`)]]");
        List<Statement> statements = mainMethod.getBody().getStatements();
        Scope scope = mainMethod.getBody().getScope();
        MethodVisitor mv = TestUtils.mockGenerateBytecode(statements, scope);
        InOrder inOrder = inOrder(mv);

        inOrder.verify(mv).visitInsn(eq(ICONST_2));
        inOrder.verify(mv).visitTypeInsn(eq(ANEWARRAY), eq("[Ljava/lang/String;"));

        inOrder.verify(mv).visitInsn(eq(DUP));
        inOrder.verify(mv).visitInsn(eq(ICONST_0));

        // a[0]
        inOrder.verify(mv).visitInsn(eq(ICONST_2));
        inOrder.verify(mv).visitTypeInsn(eq(ANEWARRAY), eq("java/lang/String"));

        inOrder.verify(mv).visitInsn(eq(DUP));
        inOrder.verify(mv).visitInsn(eq(ICONST_0));
        inOrder.verify(mv).visitLdcInsn(eq("a"));
        inOrder.verify(mv).visitInsn(eq(AASTORE));

        inOrder.verify(mv).visitInsn(eq(DUP));
        inOrder.verify(mv).visitInsn(eq(ICONST_1));
        inOrder.verify(mv).visitLdcInsn(eq("cm"));
        inOrder.verify(mv, times(2)).visitInsn(eq(AASTORE));

        // a[1]
        inOrder.verify(mv).visitInsn(eq(DUP));
        inOrder.verify(mv, times(2)).visitInsn(eq(ICONST_1));

        inOrder.verify(mv).visitTypeInsn(eq(ANEWARRAY), eq("java/lang/String"));

        inOrder.verify(mv).visitInsn(eq(DUP));
        inOrder.verify(mv).visitInsn(eq(ICONST_0));
        inOrder.verify(mv).visitLdcInsn(eq("er"));
        inOrder.verify(mv, times(2)).visitInsn(eq(AASTORE));
    }
}
