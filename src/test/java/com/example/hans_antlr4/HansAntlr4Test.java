package com.example.hans_antlr4;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.bytecode_gen.CompilationUnit;
import com.example.hans_antlr4.bytecode_gen.StatementGenerator;
import com.example.hans_antlr4.domain.expression.Addition;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.expression.Multiplication;
import com.example.hans_antlr4.domain.expression.Pow;
import com.example.hans_antlr4.domain.expression.Value;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.PrintStatement;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.statement.VariableDeclaration;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.parsing.HansAntlrErrorListener;
import com.example.hans_antlr4.parsing.HansAntlrLexer;
import com.example.hans_antlr4.parsing.HansAntlrParser;
import com.example.hans_antlr4.parsing.biz_visitor.CompilationUnitVisitor;

public class HansAntlr4Test {
    @Test
    public void varAndPrintTest() {
        HansAntlrLexer lexer = new HansAntlrLexer(CharStreams.fromString("var x = 114514\r\n" +
                "print x\r\n" +
                "var str = \"hello world\"\r\n" +
                "print str\n" +
                "var str2 = \"支持输入中文\"\n" +
                "print str2"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        HansAntlrParser parser = new HansAntlrParser(tokens);

        CompilationUnitVisitor compilationUnitVisitor = new CompilationUnitVisitor();
        HansAntlrErrorListener errorListener = new HansAntlrErrorListener();
        parser.addErrorListener(errorListener);

        ParseTree tree = parser.compilationUnit();
        CompilationUnit compilationUnit = tree.accept(compilationUnitVisitor);
        String treeString = tree.toStringTree(parser);
        System.out.println(treeString);
        Assert.assertEquals(
                "(compilationUnit (statements (variable var x = (expression (value 114514))) (print print (expression (variableReference x))) (variable var str = (expression (value \"hello world\"))) (print print (expression (variableReference str))) (variable var str2 = (expression (value \"支持输入中文\"))) (print print (expression (variableReference str2)))) <EOF>)",
                treeString);

        Assert.assertEquals(6, compilationUnit.getInstructionsQueue().size());
    }

    @Test
    public void unicodeVarNameAndComments() {
        Statement statement = TestUtils.getFirstStatementFromCode("var 変数名2です /* 这是一个注释 */ = \"// 这不是注释\"");

        VariableDeclaration variableDeclaration = new VariableDeclaration("変数名2です",
                new Value(BuiltInType.STRING, "\"// 这不是注释\""));
        Assert.assertEquals(variableDeclaration, statement);

        MethodVisitor mv = mock(MethodVisitor.class);
        Scope scope = mock(Scope.class);
        StatementGenerator statementGenerator = new StatementGenerator(mv, scope);
        statementGenerator.generate(statement);
        verify(mv, times(1)).visitVarInsn(eq(Opcodes.ASTORE), eq(0));
    }

    @Test
    public void expressionBuildTreeTest() {
        HansAntlrLexer lexer = new HansAntlrLexer(
                CharStreams.fromString("var x = 2 ** 3 * 3 ** 2 + 2 ** 3\r\n" + "print x\r\n"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        HansAntlrParser parser = new HansAntlrParser(tokens);

        CompilationUnitVisitor compilationUnitVisitor = new CompilationUnitVisitor();
        HansAntlrErrorListener errorListener = new HansAntlrErrorListener();
        parser.addErrorListener(errorListener);

        ParseTree tree = parser.compilationUnit();
        CompilationUnit compilationUnit = tree.accept(compilationUnitVisitor);
        String treeString = tree.toStringTree(parser);
        Assert.assertEquals(
                "(compilationUnit (statements (variable var x = (expression (expression (expression (expression (value 2)) ** (expression (value 3))) * (expression (expression (value 3)) ** (expression (value 2)))) + (expression (expression (value 2)) ** (expression (value 3))))) (print print (expression (variableReference x)))) <EOF>)",
                treeString);

        Statement firstStatement = compilationUnit.getInstructionsQueue().peek();
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
    public void powerExpressionBuildTreeTest1() {
        // 验证乘方运算符的左结合
        Expression expression = new Pow(
                new Pow(new Value(BuiltInType.INT, "2"), new Value(BuiltInType.INT, "2")),
                new Value(BuiltInType.INT, "3"));
        VariableDeclaration variableDeclaration = new VariableDeclaration("x11", expression);

        Statement firstStatement = TestUtils.getFirstStatementFromCode("var x11 = 2 ** 2 ** 3");
        Assert.assertEquals(variableDeclaration, firstStatement);
    }

    @Test
    public void powerExpressionBuildTreeTest2() {
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
