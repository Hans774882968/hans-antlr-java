package com.example.hans_antlr4;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.inOrder;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InOrder;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.domain.expression.AssignmentExpression;
import com.example.hans_antlr4.domain.expression.Value;
import com.example.hans_antlr4.domain.global.AssignmentSign;
import com.example.hans_antlr4.domain.global.MetaData;
import com.example.hans_antlr4.domain.scope.LocalVariable;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.ExpressionStatement;
import com.example.hans_antlr4.domain.statement.RangedForStatement;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.statement.var.VariableDeclaration;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.exception.BreakStatementOutsideLoopException;
import com.example.hans_antlr4.exception.ContinueStatementOutsideLoopException;
import com.example.hans_antlr4.exception.func.MainMethodNotFoundInPublicClass;

public class HantLoopTest implements Opcodes {
    @Test
    public void newVarAsIteratorVariable() throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getFirstStatementFromCode(
                "for i: 114512 to 114514 print i");
        Assert.assertTrue(statement instanceof RangedForStatement);
        RangedForStatement rangedForStatement = (RangedForStatement) statement;
        Statement iteratorVariableStatement = rangedForStatement.getIteratorVariableStatement();
        VariableDeclaration variableDeclaration = new VariableDeclaration(
                "i", new Value(BuiltInType.INT, "114512"));
        Assert.assertEquals(variableDeclaration, iteratorVariableStatement);
    }

    @Test
    public void definedVarAsIteratorVariable() throws MainMethodNotFoundInPublicClass {
        List<Statement> statements = TestUtils.getStatementsFromCode(
                "var i = 114510\nfor i: 114512 to 114514 print i");
        statements.forEach(stmt -> {
            if (!(stmt instanceof RangedForStatement))
                return;
            RangedForStatement rangedForStatement = (RangedForStatement) stmt;
            Statement iteratorVariableStatement = rangedForStatement.getIteratorVariableStatement();
            ExpressionStatement expressionStatement = new ExpressionStatement(
                    new AssignmentExpression(
                            new LocalVariable("i", BuiltInType.INT),
                            AssignmentSign.ASSIGN,
                            new Value(BuiltInType.INT, "114512"),
                            0));
            Assert.assertEquals(expressionStatement, iteratorVariableStatement);
        });
    }

    @Test
    public void outsideForLoopBreakTest() {
        Assert.assertThrows(BreakStatementOutsideLoopException.class, () -> {
            TestUtils.getStatementsFromCode("{ if 1 { break } }");
        });
    }

    @Test
    public void outsideForLoopContinueTest() {
        Assert.assertThrows(ContinueStatementOutsideLoopException.class, () -> {
            TestUtils.getStatementsFromCode("{ if 1 { print 1 } continue }");
        });
    }

    @Test
    public void standardForLoopTest1() throws MainMethodNotFoundInPublicClass {
        List<Statement> statements = TestUtils.getStatementsFromCode("for var i = 1L; i <= 5; i += 1 print i");
        Scope scope = new Scope(new MetaData(null));
        scope.addLocalVariable(new LocalVariable("i", BuiltInType.LONG));
        MethodVisitor mv = TestUtils.mockGenerateBytecode(statements, scope);
        InOrder inOrder = inOrder(mv);

        inOrder.verify(mv).visitLdcInsn(eq(1L));
        inOrder.verify(mv).visitVarInsn(eq(LSTORE), eq(0));
        inOrder.verify(mv).visitJumpInsn(eq(GOTO), isA(Label.class));

        inOrder.verify(mv).visitFieldInsn(
                eq(GETSTATIC),
                eq("java/lang/System"),
                eq("out"),
                eq("Ljava/io/PrintStream;"));
        inOrder.verify(mv).visitVarInsn(eq(LLOAD), eq(0));
        inOrder.verify(mv).visitMethodInsn(
                eq(INVOKEVIRTUAL),
                eq("java/io/PrintStream"),
                eq("println"),
                eq("(J)V"),
                eq(false));

        inOrder.verify(mv).visitVarInsn(eq(LLOAD), eq(0));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitInsn(eq(ICONST_1));
        inOrder.verify(mv).visitInsn(eq(I2L));
        inOrder.verify(mv).visitInsn(eq(LADD));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitVarInsn(eq(LSTORE), eq(0));

        inOrder.verify(mv).visitVarInsn(eq(LLOAD), eq(0));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitInsn(eq(ICONST_5));
        inOrder.verify(mv).visitInsn(eq(I2L));
        inOrder.verify(mv).visitInsn(eq(LCMP));
        inOrder.verify(mv).visitJumpInsn(eq(IFGT), isA(Label.class));
        inOrder.verify(mv).visitInsn(eq(ICONST_1));
        inOrder.verify(mv).visitJumpInsn(eq(GOTO), isA(Label.class));
        inOrder.verify(mv).visitInsn(eq(ICONST_0));

        inOrder.verify(mv).visitJumpInsn(eq(IFEQ), isA(Label.class));
        inOrder.verify(mv).visitJumpInsn(eq(GOTO), isA(Label.class));
    }

    @Test
    public void standardForLoopWithoutForInitTest() throws MainMethodNotFoundInPublicClass {
        List<Statement> statements = TestUtils.getStatementsFromCode(
                "var i = 0\nfor ; i < 5; i += 1 { if i % 2 == 0 continue print i }");
        Scope scope = new Scope(new MetaData(null));
        scope.addLocalVariable(new LocalVariable("i", BuiltInType.INT));
        MethodVisitor mv = TestUtils.mockGenerateBytecode(statements, scope);
        InOrder inOrder = inOrder(mv);

        inOrder.verify(mv).visitInsn(eq(ICONST_0));
        inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(0));
        inOrder.verify(mv).visitJumpInsn(eq(GOTO), isA(Label.class));

        inOrder.verify(mv).visitVarInsn(eq(ILOAD), eq(0));
        inOrder.verify(mv).visitInsn(eq(ICONST_2));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitInsn(eq(IREM));
        inOrder.verify(mv).visitInsn(eq(NOP));

        inOrder.verify(mv).visitInsn(eq(ICONST_0));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitInsn(eq(ISUB));

        inOrder.verify(mv).visitJumpInsn(eq(IFNE), isA(Label.class));
        inOrder.verify(mv).visitInsn(eq(ICONST_1));
        inOrder.verify(mv).visitJumpInsn(eq(GOTO), isA(Label.class));
        inOrder.verify(mv).visitInsn(eq(ICONST_0));
        inOrder.verify(mv).visitJumpInsn(eq(IFNE), isA(Label.class));
        inOrder.verify(mv).visitJumpInsn(eq(GOTO), isA(Label.class));
        inOrder.verify(mv).visitJumpInsn(eq(GOTO), isA(Label.class));

        inOrder.verify(mv).visitFieldInsn(
                eq(GETSTATIC),
                eq("java/lang/System"),
                eq("out"),
                eq("Ljava/io/PrintStream;"));
        inOrder.verify(mv).visitVarInsn(eq(ILOAD), eq(0));
        inOrder.verify(mv).visitMethodInsn(
                eq(INVOKEVIRTUAL),
                eq("java/io/PrintStream"),
                eq("println"),
                eq("(I)V"),
                eq(false));

        inOrder.verify(mv).visitVarInsn(eq(ILOAD), eq(0));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitInsn(eq(ICONST_1));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitInsn(eq(IADD));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(0));

        inOrder.verify(mv).visitVarInsn(eq(ILOAD), eq(0));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitInsn(eq(ICONST_5));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitInsn(eq(ISUB));
        inOrder.verify(mv).visitJumpInsn(eq(IFGE), isA(Label.class));
        inOrder.verify(mv).visitInsn(eq(ICONST_1));
        inOrder.verify(mv).visitJumpInsn(eq(GOTO), isA(Label.class));
        inOrder.verify(mv).visitInsn(eq(ICONST_0));

        inOrder.verify(mv).visitJumpInsn(eq(IFEQ), isA(Label.class));
        inOrder.verify(mv).visitJumpInsn(eq(GOTO), isA(Label.class));
    }
}
