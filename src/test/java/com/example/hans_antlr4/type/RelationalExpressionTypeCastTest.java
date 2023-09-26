package com.example.hans_antlr4.type;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.inOrder;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.InOrder;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.TestUtils;
import com.example.hans_antlr4.domain.global.CompareSign;
import com.example.hans_antlr4.domain.global.MetaData;
import com.example.hans_antlr4.domain.scope.LocalVariable;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.exception.func.MainMethodNotFoundInPublicClass;

public class RelationalExpressionTypeCastTest implements Opcodes {
    @Test
    public void intAndLong() {
        Arrays.stream(CompareSign.values()).forEach(cmpSign -> {
            String code = "var x = 44L\nvar y = 44\nvar x1 = x " + cmpSign.getSign() + " y\nprint x1";

            List<Statement> statements;
            try {
                statements = TestUtils.getStatementsFromCode(code);
            } catch (MainMethodNotFoundInPublicClass e) {
                e.printStackTrace();
                return;
            }
            Scope scope = new Scope(new MetaData(null));
            scope.addLocalVariables(
                    new LocalVariable("x", BuiltInType.LONG),
                    new LocalVariable("y", BuiltInType.INT),
                    new LocalVariable("x1", BuiltInType.BOOLEAN));
            MethodVisitor mv = TestUtils.mockGenerateBytecode(statements, scope);
            InOrder inOrder = inOrder(mv);

            inOrder.verify(mv).visitLdcInsn(eq(44L));
            inOrder.verify(mv).visitVarInsn(eq(LSTORE), eq(0));
            inOrder.verify(mv).visitIntInsn(eq(BIPUSH), eq(44));
            inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(2));

            inOrder.verify(mv).visitVarInsn(eq(LLOAD), eq(0));
            inOrder.verify(mv).visitInsn(eq(NOP));
            inOrder.verify(mv).visitVarInsn(eq(ILOAD), eq(2));
            inOrder.verify(mv).visitInsn(eq(I2L));
            inOrder.verify(mv).visitInsn(eq(LCMP));
            inOrder.verify(mv).visitJumpInsn(eq(cmpSign.getOppositeCompareSign().getOpcode()), isA(Label.class));
            inOrder.verify(mv).visitInsn(eq(ICONST_1));
            inOrder.verify(mv).visitJumpInsn(eq(GOTO), isA(Label.class));
            inOrder.verify(mv).visitInsn(eq(ICONST_0));
            inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(3));

            inOrder.verify(mv).visitFieldInsn(
                    eq(GETSTATIC),
                    eq("java/lang/System"),
                    eq("out"),
                    eq("Ljava/io/PrintStream;"));
            inOrder.verify(mv).visitVarInsn(eq(ILOAD), eq(3));
            inOrder.verify(mv).visitMethodInsn(
                    eq(INVOKEVIRTUAL),
                    eq("java/io/PrintStream"),
                    eq("println"),
                    eq("(Z)V"),
                    eq(false));
        });
    }

    @Test
    public void longAndDouble() {
        Arrays.stream(CompareSign.values()).forEach(cmpSign -> {
            String code = "var x = 0x2cL\nvar y = 44.0\nvar x1 = x " + cmpSign.getSign() + " y\nprint x1";

            List<Statement> statements;
            try {
                statements = TestUtils.getStatementsFromCode(code);
            } catch (MainMethodNotFoundInPublicClass e) {
                e.printStackTrace();
                return;
            }
            Scope scope = new Scope(new MetaData(null));
            scope.addLocalVariables(
                    new LocalVariable("x", BuiltInType.LONG),
                    new LocalVariable("y", BuiltInType.DOUBLE),
                    new LocalVariable("x1", BuiltInType.BOOLEAN));
            MethodVisitor mv = TestUtils.mockGenerateBytecode(statements, scope);
            InOrder inOrder = inOrder(mv);

            inOrder.verify(mv).visitLdcInsn(eq(44L));
            inOrder.verify(mv).visitVarInsn(eq(LSTORE), eq(0));
            inOrder.verify(mv).visitLdcInsn(eq(44.0));
            inOrder.verify(mv).visitVarInsn(eq(DSTORE), eq(2));

            inOrder.verify(mv).visitVarInsn(eq(LLOAD), eq(0));
            inOrder.verify(mv).visitInsn(eq(L2D));
            inOrder.verify(mv).visitVarInsn(eq(DLOAD), eq(2));
            inOrder.verify(mv).visitInsn(eq(NOP));
            int cmpOpCode = cmpSign == CompareSign.LESS || cmpSign == CompareSign.LESS_OR_EQUAL ? DCMPG : DCMPL;
            inOrder.verify(mv).visitInsn(eq(cmpOpCode));
            inOrder.verify(mv).visitJumpInsn(eq(cmpSign.getOppositeCompareSign().getOpcode()), isA(Label.class));
            inOrder.verify(mv).visitInsn(eq(ICONST_1));
            inOrder.verify(mv).visitJumpInsn(eq(GOTO), isA(Label.class));
            inOrder.verify(mv).visitInsn(eq(ICONST_0));
            inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(4));

            inOrder.verify(mv).visitFieldInsn(
                    eq(GETSTATIC),
                    eq("java/lang/System"),
                    eq("out"),
                    eq("Ljava/io/PrintStream;"));
            inOrder.verify(mv).visitVarInsn(eq(ILOAD), eq(4));
            inOrder.verify(mv).visitMethodInsn(
                    eq(INVOKEVIRTUAL),
                    eq("java/io/PrintStream"),
                    eq("println"),
                    eq("(Z)V"),
                    eq(false));
        });
    }
}
