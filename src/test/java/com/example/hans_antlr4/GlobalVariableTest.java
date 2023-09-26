package com.example.hans_antlr4;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.inOrder;

import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.InOrder;
import org.objectweb.asm.Handle;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.utils.Const;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class BootstrapMethodArgMatcher implements ArgumentMatcher<Object> {
    private int stringElementCount;

    @Override
    public boolean matches(Object right) {
        if (!(right instanceof String)) {
            return false;
        }
        return right.toString().equals("\u0001".repeat(stringElementCount));
    }
}

public class GlobalVariableTest implements Opcodes {
    @Test
    public void varDependencyTest() {
        MethodVisitor[] mvs = TestUtils.mockGenerateOneFunctionAndGlobalVar(
                "var vI1 = 123; var vI2 = vI1 + 2; void f() {print vI2}");
        MethodVisitor fnMv = mvs[0];
        InOrder inOrder0 = inOrder(fnMv);
        inOrder0.verify(fnMv).visitFieldInsn(
                eq(GETSTATIC),
                eq("java/lang/System"),
                eq("out"),
                eq("Ljava/io/PrintStream;"));
        inOrder0.verify(fnMv).visitFieldInsn(eq(GETSTATIC), eq(Const.mockPublicClass), eq("vI2"), eq("I"));
        inOrder0.verify(fnMv).visitMethodInsn(
                eq(INVOKEVIRTUAL),
                eq("java/io/PrintStream"),
                eq("println"),
                eq("(I)V"),
                eq(false));

        MethodVisitor clinitMv = mvs[1];
        InOrder inOrder1 = inOrder(clinitMv);
        inOrder1.verify(clinitMv).visitIntInsn(eq(BIPUSH), eq(123));
        inOrder1.verify(clinitMv).visitFieldInsn(eq(PUTSTATIC), eq(Const.mockPublicClass), eq("vI1"), eq("I"));
        inOrder1.verify(clinitMv).visitFieldInsn(eq(GETSTATIC), eq(Const.mockPublicClass), eq("vI1"), eq("I"));
        inOrder1.verify(clinitMv).visitInsn(eq(ICONST_2));
        inOrder1.verify(clinitMv).visitInsn(eq(IADD));
        inOrder1.verify(clinitMv).visitFieldInsn(eq(PUTSTATIC), eq(Const.mockPublicClass), eq("vI2"), eq("I"));
    }

    @Test
    public void varShadowTest() {
        MethodVisitor[] mvs = TestUtils.mockGenerateOneFunctionAndGlobalVar(
                "var s1 = \"hello\"; void f() { var s1 = `hi`; var s2 = `${s1} world` }");
        MethodVisitor fnMv = mvs[0];
        InOrder inOrder0 = inOrder(fnMv);
        inOrder0.verify(fnMv).visitLdcInsn(eq("hi"));
        inOrder0.verify(fnMv).visitVarInsn(eq(ASTORE), eq(0));
        inOrder0.verify(fnMv).visitLdcInsn(eq(""));
        inOrder0.verify(fnMv).visitVarInsn(eq(ALOAD), eq(0));
        inOrder0.verify(fnMv).visitLdcInsn(eq(" world"));
        inOrder0.verify(fnMv).visitInvokeDynamicInsn(
                eq("makeConcatWithConstants"),
                eq("(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;"),
                isA(Handle.class),
                argThat(new BootstrapMethodArgMatcher(3)));
        inOrder0.verify(fnMv).visitVarInsn(eq(ASTORE), eq(1));

        MethodVisitor clinitMv = mvs[1];
        InOrder inOrder1 = inOrder(clinitMv);
        inOrder1.verify(clinitMv).visitLdcInsn(eq("hello"));
        inOrder1.verify(clinitMv).visitFieldInsn(
                eq(PUTSTATIC), eq(Const.mockPublicClass), eq("s1"), eq("Ljava/lang/String;"));
    }
}
