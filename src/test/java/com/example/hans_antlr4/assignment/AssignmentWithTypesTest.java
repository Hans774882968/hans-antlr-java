package com.example.hans_antlr4.assignment;

import static org.mockito.Matchers.argThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.inOrder;

import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.InOrder;
import org.objectweb.asm.Handle;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.TestUtils;
import com.example.hans_antlr4.domain.global.MetaData;
import com.example.hans_antlr4.domain.scope.LocalVariable;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.type.BuiltInType;

class BootstrapMethodArgMatcher extends ArgumentMatcher<Object> {
    @Override
    public boolean matches(Object right) {
        if (!(right instanceof String)) {
            return false;
        }
        return right.toString().equals("\u0001\u0001");
    }
}

public class AssignmentWithTypesTest implements Opcodes {
    @Test
    public void assignmentNumericTest1() {
        List<Statement> statements = TestUtils.getStatementsFromCode(
                "var tmpL = 0xfcL\nvar tmpF = 2.34f\ntmpF *= tmpF + (tmpL |= tmpL ^= tmpL &= 0x3f1)");
        Scope scope = new Scope(new MetaData(null));
        scope.addLocalVariables(
                new LocalVariable("tmpL", BuiltInType.LONG),
                new LocalVariable("tmpF", BuiltInType.FLOAT));
        MethodVisitor mv = TestUtils.mockGenerateBytecode(statements, scope);
        InOrder inOrder = inOrder(mv);

        inOrder.verify(mv).visitVarInsn(eq(FLOAD), eq(2));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitVarInsn(eq(FLOAD), eq(2));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitVarInsn(eq(LLOAD), eq(0));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitVarInsn(eq(LLOAD), eq(0));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitVarInsn(eq(LLOAD), eq(0));
        inOrder.verify(mv).visitInsn(eq(NOP));

        inOrder.verify(mv).visitIntInsn(eq(SIPUSH), eq(1009));
        inOrder.verify(mv).visitInsn(eq(I2L));
        inOrder.verify(mv).visitInsn(eq(LAND));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitInsn(eq(DUP2));
        inOrder.verify(mv).visitVarInsn(eq(LSTORE), eq(0));

        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitInsn(eq(LXOR));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitInsn(eq(DUP2));
        inOrder.verify(mv).visitVarInsn(eq(LSTORE), eq(0));

        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitInsn(eq(LOR));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitInsn(eq(DUP2));
        inOrder.verify(mv).visitVarInsn(eq(LSTORE), eq(0));

        inOrder.verify(mv).visitInsn(eq(L2F));
        inOrder.verify(mv).visitInsn(eq(FADD));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitInsn(eq(FMUL));
        inOrder.verify(mv).visitVarInsn(eq(FSTORE), eq(2));
    }

    @Test
    public void assignmentStringTest1() {
        List<Statement> statements = TestUtils.getStatementsFromCode(
                "var x = \"str\"\nvar y = 1.23\nx += x = x + y");
        Scope scope = new Scope(new MetaData(null));
        scope.addLocalVariable(new LocalVariable("x", BuiltInType.STRING));
        scope.addLocalVariable(new LocalVariable("y", BuiltInType.DOUBLE));
        MethodVisitor mv = TestUtils.mockGenerateBytecode(statements, scope);
        InOrder inOrder = inOrder(mv);

        inOrder.verify(mv).visitVarInsn(eq(ALOAD), eq(0));

        inOrder.verify(mv).visitTypeInsn(eq(NEW), eq("java/lang/StringBuilder"));
        inOrder.verify(mv).visitInsn(eq(DUP));
        inOrder.verify(mv).visitMethodInsn(
                eq(INVOKESPECIAL),
                eq("java/lang/StringBuilder"),
                eq("<init>"),
                eq("()V"),
                eq(false));
        inOrder.verify(mv).visitVarInsn(eq(ALOAD), eq(0));
        inOrder.verify(mv).visitMethodInsn(eq(INVOKEVIRTUAL), eq("java/lang/StringBuilder"), eq("append"),
                eq("(Ljava/lang/String;)Ljava/lang/StringBuilder;"), eq(false));
        inOrder.verify(mv).visitVarInsn(eq(DLOAD), eq(1));
        inOrder.verify(mv).visitMethodInsn(eq(INVOKEVIRTUAL), eq("java/lang/StringBuilder"), eq("append"),
                eq("(D)Ljava/lang/StringBuilder;"), eq(false));
        inOrder.verify(mv).visitMethodInsn(eq(INVOKEVIRTUAL), eq("java/lang/StringBuilder"), eq("toString"),
                eq("()Ljava/lang/String;"), eq(false));

        inOrder.verify(mv).visitInsn(eq(DUP));
        inOrder.verify(mv).visitVarInsn(eq(ASTORE), eq(0));

        // The third and fourth parameters correspond to X and Y, respectively
        // new Handle(H_INVOKESTATIC, "java/lang/invoke/StringConcatFactory", "makeConcatWithConstants",
        // "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;",
        // false),
        // eq(new Object[] { "\u0001\u0001" })
        inOrder.verify(mv).visitInvokeDynamicInsn(
                eq("makeConcatWithConstants"),
                eq("(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;"),
                isA(Handle.class),
                argThat(new BootstrapMethodArgMatcher()));
        inOrder.verify(mv).visitVarInsn(eq(ASTORE), eq(0));
    }
}
