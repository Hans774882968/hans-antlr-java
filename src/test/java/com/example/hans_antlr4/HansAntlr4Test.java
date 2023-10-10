package com.example.hans_antlr4;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.bytecode_gen.statement.StatementGenerator;
import com.example.hans_antlr4.domain.expression.Addition;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.expression.Multiplication;
import com.example.hans_antlr4.domain.expression.Pow;
import com.example.hans_antlr4.domain.expression.Value;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.PrintStatement;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.statement.var.VariableDeclaration;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.exception.func.MainMethodNotFoundInPublicClass;

public class HansAntlr4Test {
    @Test
    public void unicodeVarNameAndComments() throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getFirstStatementFromCode("var 変数名2です /* 这是一个注释 */ = \"// 这不是注释\"");

        VariableDeclaration variableDeclaration = new VariableDeclaration("変数名2です",
                new Value(BuiltInType.STRING, "\"// 这不是注释\""));
        Assert.assertEquals(variableDeclaration, statement);

        MethodVisitor mv = mock(MethodVisitor.class);
        Scope scope = mock(Scope.class);
        StatementGenerator statementGenerator = new StatementGenerator(mv, scope);
        statement.accept(statementGenerator);
        verify(mv, times(1)).visitVarInsn(eq(Opcodes.ASTORE), eq(0));
    }

    @Test
    public void expressionBuildTreeTest() throws MainMethodNotFoundInPublicClass {
        Statement firstStatement = TestUtils.getFirstStatementFromCode(
                "var x = 2 ** 3 * 3 ** 2 + 2 ** 3\r\n" + "print x\r\n");
        Expression expression = new Addition(
                new Multiplication(
                        new Pow(new Value(BuiltInType.INT, "2"),
                                new Value(BuiltInType.INT, "3")),
                        new Pow(new Value(BuiltInType.INT, "3"),
                                new Value(BuiltInType.INT, "2"))),
                new Pow(new Value(BuiltInType.INT, "2"), new Value(BuiltInType.INT, "3")));
        VariableDeclaration variableDeclaration = new VariableDeclaration("x", expression);
        Assert.assertEquals(variableDeclaration, firstStatement);
    }

    @Test
    public void powerExpressionBuildTreeTest1() throws MainMethodNotFoundInPublicClass {
        // 验证乘方运算符的左结合
        Expression expression = new Pow(
                new Pow(new Value(BuiltInType.INT, "2"), new Value(BuiltInType.INT, "2")),
                new Value(BuiltInType.INT, "3"));
        VariableDeclaration variableDeclaration = new VariableDeclaration("x11", expression);

        Statement firstStatement = TestUtils.getFirstStatementFromCode("var x11 = 2 ** 2 ** 3");
        Assert.assertEquals(variableDeclaration, firstStatement);
    }

    @Test
    public void powerExpressionBuildTreeTest2() throws MainMethodNotFoundInPublicClass {
        // powerExpressionBuildTreeTest1 的对照组
        Expression expression = new Pow(
                new Value(BuiltInType.INT, "2"),
                new Pow(new Value(BuiltInType.INT, "2"), new Value(BuiltInType.INT, "3")));
        VariableDeclaration variableDeclaration = new VariableDeclaration("x12", expression);

        Statement firstStatement = TestUtils.getFirstStatementFromCode("var x12 = 2 ** (2 ** 3)");
        Assert.assertEquals(variableDeclaration, firstStatement);
    }

    @Test
    public void variableDeclarationStatementGeneratorTest1() {
        MethodVisitor mv = mock(MethodVisitor.class);
        Scope scope = mock(Scope.class);
        StatementGenerator statementGenerator = new StatementGenerator(mv, scope);
        statementGenerator.generate(new VariableDeclaration("v0", new Value(BuiltInType.INT, "114514")));
        verify(mv, times(1)).visitVarInsn(eq(Opcodes.ISTORE), anyInt());
        verify(mv, times(0)).visitVarInsn(eq(Opcodes.ASTORE), anyInt());
        verify(mv, times(1)).visitLdcInsn(eq(114514));
        verify(mv, times(0)).visitLdcInsn(anyString());
    }

    @Test
    public void variableDeclarationStatementGeneratorTest2() {
        MethodVisitor mv = mock(MethodVisitor.class);
        Scope scope = mock(Scope.class);
        StatementGenerator statementGenerator = new StatementGenerator(mv, scope);
        statementGenerator.generate(new VariableDeclaration("v0", new Value(BuiltInType.STRING, "\"114514\"")));
        verify(mv, times(0)).visitVarInsn(eq(Opcodes.ISTORE), anyInt());
        verify(mv, times(1)).visitVarInsn(eq(Opcodes.ASTORE), anyInt());
        verify(mv, times(0)).visitIntInsn(eq(Opcodes.SIPUSH), anyInt());
        verify(mv, times(1)).visitLdcInsn(anyString());
    }

    @Test
    public void printStatementGeneratorTest() {
        MethodVisitor mv = mock(MethodVisitor.class);
        Scope scope = mock(Scope.class);
        StatementGenerator statementGenerator = new StatementGenerator(mv, scope);
        statementGenerator.generate(new PrintStatement(new Value(BuiltInType.INT, "114514")));
        verify(mv, times(1))
                .visitFieldInsn(anyInt(), anyString(), anyString(), anyString());
        verify(mv, times(1)).visitMethodInsn(
                anyInt(), anyString(), eq("println"), anyString(), eq(false));
        verify(mv, times(1)).visitLdcInsn(eq(114514));
        verify(mv, times(0)).visitLdcInsn(anyString());
    }
}
