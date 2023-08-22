package com.example.hans_antlr4;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.domain.expression.Addition;
import com.example.hans_antlr4.domain.expression.ConditionalExpression;
import com.example.hans_antlr4.domain.expression.Mod;
import com.example.hans_antlr4.domain.expression.Value;
import com.example.hans_antlr4.domain.expression.unary.UnaryNegative;
import com.example.hans_antlr4.domain.global.CompareSign;
import com.example.hans_antlr4.domain.global.MetaData;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.Block;
import com.example.hans_antlr4.domain.statement.IfStatement;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.statement.StatementAfterIf;
import com.example.hans_antlr4.domain.type.BuiltInType;

public class HantIfTest {
    @Test
    public void relationalExpressionTest() {
        Statement statement = TestUtils.getFirstStatementFromCode("if 20 % 12 <= 8 {}");
        Scope scope = new Scope(new MetaData(null));
        Scope newScope = new Scope(scope);
        StatementAfterIf trueStatement = new StatementAfterIf(newScope, new Block(new ArrayList<>(), newScope));
        IfStatement ifStatement = new IfStatement(
                new ConditionalExpression(
                        new Mod(new Value(BuiltInType.INT, "20"), new Value(BuiltInType.INT, "12")),
                        new Value(BuiltInType.INT, "8"),
                        CompareSign.LESS_OR_EQUAL),
                trueStatement);
        Assert.assertEquals(ifStatement, statement);
    }

    @Test
    public void equalityExpressionTest() {
        Statement statement = TestUtils.getFirstStatementFromCode("if 21 % 12 == -1 + 10 {}");
        Scope scope = new Scope(new MetaData(null));
        Scope newScope = new Scope(scope);
        StatementAfterIf trueStatement = new StatementAfterIf(newScope, new Block(new ArrayList<>(), newScope));
        IfStatement ifStatement = new IfStatement(
                new ConditionalExpression(
                        new Mod(new Value(BuiltInType.INT, "21"), new Value(BuiltInType.INT, "12")),
                        new Addition(
                                new UnaryNegative(new Value(BuiltInType.INT, "1")),
                                new Value(BuiltInType.INT, "10")),
                        CompareSign.EQUAL),
                trueStatement);
        Assert.assertEquals(ifStatement, statement);
    }

    @Test
    public void confirmNewScopeCreatedTest() {
        Queue<Statement> statements = TestUtils
                .getStatementsFromCode("if 123 { var x = 10 if 456 var x = 12 else var x = 15 } var x = 20");
        MethodVisitor mv = TestUtils.mockGenerateBytecode(statements);

        verify(mv, times(1)).visitIntInsn(eq(Opcodes.BIPUSH), eq(10));
        verify(mv, times(1)).visitIntInsn(eq(Opcodes.BIPUSH), eq(12));
        verify(mv, times(1)).visitIntInsn(eq(Opcodes.BIPUSH), eq(15));
        verify(mv, times(1)).visitIntInsn(eq(Opcodes.BIPUSH), eq(20));
        verify(mv, times(2)).visitVarInsn(eq(Opcodes.ISTORE), eq(0));
        verify(mv, times(2)).visitVarInsn(eq(Opcodes.ISTORE), eq(1));
        verify(mv, times(0)).visitVarInsn(eq(Opcodes.ISTORE), eq(2));
    }
}
