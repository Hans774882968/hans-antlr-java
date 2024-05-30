package com.example.hans_antlr4.func;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;

import org.junit.Test;
import org.mockito.InOrder;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.MakeConcatWithConstArgMatcher;
import com.example.hans_antlr4.TestUtils;

public class BooleanRelevantFunctionsTest implements Opcodes {
    @Test
    public void returnBooleanFunction() {
        MethodVisitor[] mvs = TestUtils.mockGenerateFunctions("boolean isIn(int v, int l, int r) {\r\n" +
                "    if v < l return false\r\n" +
                "    if v > r return false\r\n" +
                "    return true\r\n" +
                "}\r\nvoid f() { print isIn(2, 2, 3) }");

        InOrder inOrder0 = inOrder(mvs[0]);
        inOrder0.verify(mvs[0]).visitCode();

        inOrder0.verify(mvs[0]).visitVarInsn(eq(ILOAD), eq(0));
        inOrder0.verify(mvs[0]).visitInsn(eq(NOP));
        inOrder0.verify(mvs[0]).visitVarInsn(eq(ILOAD), eq(1));
        inOrder0.verify(mvs[0]).visitInsn(eq(NOP));
        inOrder0.verify(mvs[0]).visitInsn(eq(ISUB));
        inOrder0.verify(mvs[0]).visitJumpInsn(eq(IFGE), isA(Label.class));
        inOrder0.verify(mvs[0]).visitInsn(eq(ICONST_1));
        inOrder0.verify(mvs[0]).visitJumpInsn(eq(GOTO), isA(Label.class));
        inOrder0.verify(mvs[0]).visitInsn(eq(ICONST_0));
        inOrder0.verify(mvs[0]).visitJumpInsn(eq(IFNE), isA(Label.class));
        inOrder0.verify(mvs[0]).visitJumpInsn(eq(GOTO), isA(Label.class));
        inOrder0.verify(mvs[0]).visitLdcInsn(eq(false));
        inOrder0.verify(mvs[0]).visitInsn(eq(IRETURN));

        inOrder0.verify(mvs[0]).visitVarInsn(eq(ILOAD), eq(0));
        inOrder0.verify(mvs[0]).visitInsn(eq(NOP));
        inOrder0.verify(mvs[0]).visitVarInsn(eq(ILOAD), eq(2));
        inOrder0.verify(mvs[0]).visitInsn(eq(NOP));
        inOrder0.verify(mvs[0]).visitInsn(eq(ISUB));
        inOrder0.verify(mvs[0]).visitJumpInsn(eq(IFLE), isA(Label.class));
        inOrder0.verify(mvs[0]).visitInsn(eq(ICONST_1));
        inOrder0.verify(mvs[0]).visitJumpInsn(eq(GOTO), isA(Label.class));
        inOrder0.verify(mvs[0]).visitInsn(eq(ICONST_0));
        inOrder0.verify(mvs[0]).visitJumpInsn(eq(IFNE), isA(Label.class));
        inOrder0.verify(mvs[0]).visitJumpInsn(eq(GOTO), isA(Label.class));
        inOrder0.verify(mvs[0]).visitLdcInsn(eq(false));
        inOrder0.verify(mvs[0]).visitInsn(eq(IRETURN));

        inOrder0.verify(mvs[0]).visitLdcInsn(eq(true));
        inOrder0.verify(mvs[0]).visitInsn(eq(IRETURN));

        inOrder0.verify(mvs[0]).visitMaxs(eq(-1), eq(-1));
        inOrder0.verify(mvs[0]).visitEnd();

        InOrder inOrder1 = inOrder(mvs[1]);
        inOrder1.verify(mvs[1]).visitCode();

        inOrder1.verify(mvs[1]).visitFieldInsn(
                eq(GETSTATIC),
                eq("java/lang/System"),
                eq("out"),
                eq("Ljava/io/PrintStream;"));
        inOrder1.verify(mvs[1], times(2)).visitInsn(eq(ICONST_2));
        inOrder1.verify(mvs[1]).visitInsn(eq(ICONST_3));
        inOrder1.verify(mvs[1]).visitMethodInsn(
                eq(INVOKESTATIC), anyString(), eq("isIn"), eq("(III)Z"), eq(false));
        inOrder1.verify(mvs[1]).visitMethodInsn(
                eq(INVOKEVIRTUAL),
                eq("java/io/PrintStream"),
                eq("println"),
                eq("(Z)V"),
                eq(false));

        inOrder1.verify(mvs[1]).visitInsn(eq(RETURN));

        inOrder1.verify(mvs[1]).visitMaxs(eq(-1), eq(-1));
        inOrder1.verify(mvs[1]).visitEnd();
    }

    @Test
    public void hasBooleanParamFunction() {
        MethodVisitor mv = TestUtils.mockGenerateOneFunction(
                "string getRedOrBlueText(string s, boolean isRed) { if isRed return \"\\033[31m\" + s + \"\\033[0m\" return \"\\033[34m\" + s + \"\\033[0m\" }");

        InOrder inOrder = inOrder(mv);
        inOrder.verify(mv).visitCode();

        inOrder.verify(mv).visitVarInsn(eq(ILOAD), eq(1));
        inOrder.verify(mv).visitJumpInsn(eq(IFNE), isA(Label.class));
        inOrder.verify(mv).visitJumpInsn(eq(GOTO), isA(Label.class));

        inOrder.verify(mv).visitLdcInsn(eq("\u001b[31m"));
        inOrder.verify(mv).visitVarInsn(eq(ALOAD), eq(0));
        inOrder.verify(mv).visitInvokeDynamicInsn(
                eq("makeConcatWithConstants"),
                eq("(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;"),
                isA(Handle.class),
                argThat(new MakeConcatWithConstArgMatcher(2)));
        inOrder.verify(mv).visitLdcInsn(eq("\u001b[0m"));
        inOrder.verify(mv).visitInvokeDynamicInsn(
                eq("makeConcatWithConstants"),
                eq("(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;"),
                isA(Handle.class),
                argThat(new MakeConcatWithConstArgMatcher(2)));

        inOrder.verify(mv).visitInsn(eq(ARETURN));

        // line 2
        inOrder.verify(mv).visitLdcInsn(eq("\u001b[34m"));
        inOrder.verify(mv).visitVarInsn(eq(ALOAD), eq(0));
        inOrder.verify(mv).visitInvokeDynamicInsn(
                eq("makeConcatWithConstants"),
                eq("(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;"),
                isA(Handle.class),
                argThat(new MakeConcatWithConstArgMatcher(2)));
        inOrder.verify(mv).visitLdcInsn(eq("\u001b[0m"));
        inOrder.verify(mv).visitInvokeDynamicInsn(
                eq("makeConcatWithConstants"),
                eq("(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;"),
                isA(Handle.class),
                argThat(new MakeConcatWithConstArgMatcher(2)));

        inOrder.verify(mv).visitInsn(eq(ARETURN));

        inOrder.verify(mv).visitMaxs(eq(-1), eq(-1));
        inOrder.verify(mv).visitEnd();
    }
}
