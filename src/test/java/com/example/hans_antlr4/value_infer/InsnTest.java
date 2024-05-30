package com.example.hans_antlr4.value_infer;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.inOrder;

import java.util.List;

import org.junit.Test;
import org.mockito.InOrder;
import org.objectweb.asm.Handle;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.MakeConcatWithConstArgMatcher;
import com.example.hans_antlr4.TestUtils;
import com.example.hans_antlr4.domain.global.Function;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.exception.func.MainMethodNotFoundInPublicClass;
import com.example.hans_antlr4.utils.Const;

public class InsnTest implements Opcodes {
    @Test
    public void testStringLiteral() throws MainMethodNotFoundInPublicClass {
        Function mainMethod = TestUtils.getMainMethodFromCode(
                "var a = `hello ${\"world\"}!`, b = `val = ${8.70}`, c = `${true} = v`, d = `v = ${0o24y}`");
        List<Statement> statements = mainMethod.getBody().getStatements();
        Scope scope = mainMethod.getBody().getScope();
        MethodVisitor mv = TestUtils.mockGenerateBytecode(statements, scope, true);
        InOrder inOrder = inOrder(mv);

        inOrder.verify(mv).visitLdcInsn(eq("hello world!"));
        inOrder.verify(mv).visitVarInsn(eq(ASTORE), eq(0));
        inOrder.verify(mv).visitLdcInsn(eq("val = 8.7"));
        inOrder.verify(mv).visitVarInsn(eq(ASTORE), eq(1));
        inOrder.verify(mv).visitLdcInsn(eq("true = v"));
        inOrder.verify(mv).visitVarInsn(eq(ASTORE), eq(2));
        inOrder.verify(mv).visitLdcInsn(eq("v = 20"));
        inOrder.verify(mv).visitVarInsn(eq(ASTORE), eq(3));
    }

    @Test
    public void testAddition() throws MainMethodNotFoundInPublicClass {
        Function mainMethod = TestUtils.getMainMethodFromCode(
                "var a = `hello ` + \"acmer\", b = 8.8f + 10L, c = 3.3 + 2, d = 63 + ` bits`\n"
                        + "var a1 = d + `!${\"!\"}`");
        List<Statement> statements = mainMethod.getBody().getStatements();
        Scope scope = mainMethod.getBody().getScope();
        MethodVisitor mv = TestUtils.mockGenerateBytecode(statements, scope, true);
        InOrder inOrder = inOrder(mv);

        inOrder.verify(mv).visitLdcInsn(eq("hello acmer"));
        inOrder.verify(mv).visitVarInsn(eq(ASTORE), eq(0));
        inOrder.verify(mv).visitLdcInsn(eq(18.8f));
        inOrder.verify(mv).visitVarInsn(eq(FSTORE), eq(1));
        inOrder.verify(mv).visitLdcInsn(eq(5.3));
        inOrder.verify(mv).visitVarInsn(eq(DSTORE), eq(2));
        inOrder.verify(mv).visitLdcInsn(eq("63 bits"));
        inOrder.verify(mv).visitVarInsn(eq(ASTORE), eq(4));

        inOrder.verify(mv).visitVarInsn(eq(ALOAD), eq(4));
        inOrder.verify(mv).visitLdcInsn(eq("!!"));
        inOrder.verify(mv).visitInvokeDynamicInsn(
                eq("makeConcatWithConstants"),
                eq("(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;"),
                isA(Handle.class),
                argThat(new MakeConcatWithConstArgMatcher(2)));
        inOrder.verify(mv).visitVarInsn(eq(ASTORE), eq(5));
    }

    @Test
    public void testSubtraction() throws MainMethodNotFoundInPublicClass {
        Function mainMethod = TestUtils.getMainMethodFromCode(
                "var a = 13 - 0x71L, b = 22y - 0b10111y, c = 22y - 27");
        List<Statement> statements = mainMethod.getBody().getStatements();
        Scope scope = mainMethod.getBody().getScope();
        MethodVisitor mv = TestUtils.mockGenerateBytecode(statements, scope, true);
        InOrder inOrder = inOrder(mv);

        inOrder.verify(mv).visitLdcInsn(eq(-100L));
        inOrder.verify(mv).visitVarInsn(eq(LSTORE), eq(0));
        inOrder.verify(mv).visitInsn(eq(ICONST_M1));
        inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(2));
        inOrder.verify(mv).visitIntInsn(eq(BIPUSH), eq(-5));
        inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(3));
    }

    @Test
    public void testPow() throws MainMethodNotFoundInPublicClass {
        Function mainMethod = TestUtils.getMainMethodFromCode(
                "var a = 2 ** 3, b = 1.23 ** 8.88, c = 3 ** 6L, d = 4.55f ** (2.490f + 0.002f)");
        List<Statement> statements = mainMethod.getBody().getStatements();
        Scope scope = mainMethod.getBody().getScope();
        MethodVisitor mv = TestUtils.mockGenerateBytecode(statements, scope, true);
        InOrder inOrder = inOrder(mv);

        inOrder.verify(mv).visitIntInsn(eq(BIPUSH), eq(8));
        inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(0));
        inOrder.verify(mv).visitLdcInsn(eq(6.285754132679758));
        inOrder.verify(mv).visitVarInsn(eq(DSTORE), eq(1));
        inOrder.verify(mv).visitLdcInsn(eq(729L));
        inOrder.verify(mv).visitVarInsn(eq(LSTORE), eq(3));
        inOrder.verify(mv).visitLdcInsn(eq(43.627922f));
        inOrder.verify(mv).visitVarInsn(eq(FSTORE), eq(5));
    }

    @Test
    public void testMulDivMod1() throws MainMethodNotFoundInPublicClass {
        Function mainMethod = TestUtils.getMainMethodFromCode(
                "var a = 4l * 25, b = 4f / 8d, c = 20y % 8y, d = 18y * 20f");
        List<Statement> statements = mainMethod.getBody().getStatements();
        Scope scope = mainMethod.getBody().getScope();
        MethodVisitor mv = TestUtils.mockGenerateBytecode(statements, scope, true);
        InOrder inOrder = inOrder(mv);

        inOrder.verify(mv).visitLdcInsn(eq(100L));
        inOrder.verify(mv).visitVarInsn(eq(LSTORE), eq(0));
        inOrder.verify(mv).visitLdcInsn(eq(0.5));
        inOrder.verify(mv).visitVarInsn(eq(DSTORE), eq(2));
        inOrder.verify(mv).visitInsn(eq(ICONST_4));
        inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(4));
        inOrder.verify(mv).visitLdcInsn(eq(360f));
        inOrder.verify(mv).visitVarInsn(eq(FSTORE), eq(5));
    }

    @Test
    public void testMulDivMod2() throws MainMethodNotFoundInPublicClass {
        Function mainMethod = TestUtils.getMainMethodFromCode(
                "var a = (288 / 33y) % (77L * 13L - 996)");
        List<Statement> statements = mainMethod.getBody().getStatements();
        Scope scope = mainMethod.getBody().getScope();
        MethodVisitor mv = TestUtils.mockGenerateBytecode(statements, scope, true);
        InOrder inOrder = inOrder(mv);

        inOrder.verify(mv).visitLdcInsn(eq(3L));
        inOrder.verify(mv).visitVarInsn(eq(LSTORE), eq(0));
    }

    @Test
    public void testShift() throws MainMethodNotFoundInPublicClass {
        Function mainMethod = TestUtils.getMainMethodFromCode(
                "var a = 0b11 << 0o11L, b = (13y << (6 + 2)) + 20y, c = 0o337522L >> 3, d = 0x1d4b42L >>> 12y");
        List<Statement> statements = mainMethod.getBody().getStatements();
        Scope scope = mainMethod.getBody().getScope();
        MethodVisitor mv = TestUtils.mockGenerateBytecode(statements, scope, true);
        InOrder inOrder = inOrder(mv);

        inOrder.verify(mv).visitIntInsn(eq(SIPUSH), eq(1536));
        inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(0));
        inOrder.verify(mv).visitIntInsn(eq(SIPUSH), eq(3348));
        inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(1));
        inOrder.verify(mv).visitLdcInsn(eq(14314L));
        inOrder.verify(mv).visitVarInsn(eq(LSTORE), eq(2));
        inOrder.verify(mv).visitLdcInsn(eq(468L));
        inOrder.verify(mv).visitVarInsn(eq(LSTORE), eq(4));
    }

    @Test
    public void testAndXorOr() throws MainMethodNotFoundInPublicClass {
        Function mainMethod = TestUtils.getMainMethodFromCode(
                "var a = 0b101011 & 0o11L, b = 0b101101y ^ 0b010010, c = 0b101101L | 0b010010y, d = 0b101101y ^ 0b010010y");
        List<Statement> statements = mainMethod.getBody().getStatements();
        Scope scope = mainMethod.getBody().getScope();
        MethodVisitor mv = TestUtils.mockGenerateBytecode(statements, scope, true);
        InOrder inOrder = inOrder(mv);

        inOrder.verify(mv).visitLdcInsn(eq(9L));
        inOrder.verify(mv).visitVarInsn(eq(LSTORE), eq(0));
        inOrder.verify(mv).visitIntInsn(eq(BIPUSH), eq(63));
        inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(2));
        inOrder.verify(mv).visitLdcInsn(eq(63L));
        inOrder.verify(mv).visitVarInsn(eq(LSTORE), eq(3));
        inOrder.verify(mv).visitIntInsn(eq(BIPUSH), eq(63));
        inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(5));
    }

    @Test
    public void testUnary() throws MainMethodNotFoundInPublicClass {
        Function mainMethod = TestUtils.getMainMethodFromCode(
                "var v1 = -(64y << 1y), v2 = +(64y << 1y), v3 = ~((64y << 1y) + 1y)\n"
                        + "var v4 = -127y, v5 = +127y, v6 = ~127y\n"
                        + "var tmpB = 12y, v7 = +tmpB, v8 = -tmpB, v9 = ~tmpB");
        List<Statement> statements = mainMethod.getBody().getStatements();
        Scope scope = mainMethod.getBody().getScope();
        MethodVisitor mv = TestUtils.mockGenerateBytecode(statements, scope, true);
        InOrder inOrder = inOrder(mv);

        inOrder.verify(mv).visitIntInsn(eq(BIPUSH), eq(-128));
        inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(0));
        inOrder.verify(mv).visitIntInsn(eq(SIPUSH), eq(128));
        inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(1));
        inOrder.verify(mv).visitIntInsn(eq(SIPUSH), eq(-130));
        inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(2));
        inOrder.verify(mv).visitIntInsn(eq(BIPUSH), eq(-127));
        inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(3));
        inOrder.verify(mv).visitIntInsn(eq(BIPUSH), eq(127));
        inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(4));
        inOrder.verify(mv).visitIntInsn(eq(BIPUSH), eq(-128));
        inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(5));

        inOrder.verify(mv).visitLdcInsn(eq((byte) 12));
        inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(6));
        inOrder.verify(mv).visitVarInsn(eq(ILOAD), eq(6));
        inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(7));
        inOrder.verify(mv).visitVarInsn(eq(ILOAD), eq(6));
        inOrder.verify(mv).visitInsn(eq(INEG));
        inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(8));
        inOrder.verify(mv).visitVarInsn(eq(ILOAD), eq(6));
        inOrder.verify(mv).visitInsn(eq(ICONST_M1));
        inOrder.verify(mv).visitInsn(eq(IXOR));
        inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(9));
    }

    @Test
    public void testGlobalVarWithConstFolding() {
        MethodVisitor mv = TestUtils.mockGenerateGlobalVar(
                "var g1 = 13y + 127y, g2 = `hello ${13y - 213L}`, g3 = 13L << 2y, g4 = 13y >> 1\n"
                        + "var g5 = ((31y << 1 | 1) * (31y >> 1)) ** 2y, g6 = (8y | 16L) & (16y ^ 1y)",
                true);
        InOrder inOrder = inOrder(mv);

        inOrder.verify(mv).visitIntInsn(eq(SIPUSH), eq(140));
        inOrder.verify(mv).visitFieldInsn(eq(PUTSTATIC), eq(Const.mockPublicClass), eq("g1"), eq("I"));
        inOrder.verify(mv).visitLdcInsn(eq("hello -200"));
        inOrder.verify(mv).visitFieldInsn(eq(PUTSTATIC), eq(Const.mockPublicClass), eq("g2"), eq("Ljava/lang/String;"));
        inOrder.verify(mv).visitLdcInsn(eq(52L));
        inOrder.verify(mv).visitFieldInsn(eq(PUTSTATIC), eq(Const.mockPublicClass), eq("g3"), eq("J"));
        inOrder.verify(mv).visitIntInsn(eq(BIPUSH), eq(6));
        inOrder.verify(mv).visitFieldInsn(eq(PUTSTATIC), eq(Const.mockPublicClass), eq("g4"), eq("I"));
        inOrder.verify(mv).visitLdcInsn(eq(893025));
        inOrder.verify(mv).visitFieldInsn(eq(PUTSTATIC), eq(Const.mockPublicClass), eq("g5"), eq("I"));
        inOrder.verify(mv).visitLdcInsn(eq(16L));
        inOrder.verify(mv).visitFieldInsn(eq(PUTSTATIC), eq(Const.mockPublicClass), eq("g6"), eq("J"));
    }

    @Test
    public void testGlobalVarWithoutConstFolding() {
        MethodVisitor mv = TestUtils.mockGenerateGlobalVar(
                "var g1 = 13y + 127y",
                false);
        InOrder inOrder = inOrder(mv);

        inOrder.verify(mv).visitLdcInsn(eq((byte) 13));
        inOrder.verify(mv).visitLdcInsn(eq((byte) 127));
        inOrder.verify(mv).visitInsn(eq(IADD));
        inOrder.verify(mv).visitFieldInsn(eq(PUTSTATIC), eq(Const.mockPublicClass), eq("g1"), eq("I"));
    }
}
