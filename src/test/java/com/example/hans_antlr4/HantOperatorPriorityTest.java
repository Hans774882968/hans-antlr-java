package com.example.hans_antlr4;

import org.junit.Assert;
import org.junit.Test;

import com.example.hans_antlr4.domain.expression.Addition;
import com.example.hans_antlr4.domain.expression.AssignmentExpression;
import com.example.hans_antlr4.domain.expression.Division;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.expression.Mod;
import com.example.hans_antlr4.domain.expression.Multiplication;
import com.example.hans_antlr4.domain.expression.Pow;
import com.example.hans_antlr4.domain.expression.Shl;
import com.example.hans_antlr4.domain.expression.Shr;
import com.example.hans_antlr4.domain.expression.Subtraction;
import com.example.hans_antlr4.domain.expression.UnsignedShr;
import com.example.hans_antlr4.domain.expression.Value;
import com.example.hans_antlr4.domain.expression.VarReference;
import com.example.hans_antlr4.domain.expression.unary.UnaryNegative;
import com.example.hans_antlr4.domain.expression.unary.UnaryPositive;
import com.example.hans_antlr4.domain.expression.unary.UnaryTilde;
import com.example.hans_antlr4.domain.global.AssignmentSign;
import com.example.hans_antlr4.domain.scope.LocalVariable;
import com.example.hans_antlr4.domain.statement.ExpressionStatement;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.statement.VariableDeclaration;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.exception.assignment.IllegalAssignmentLhsType;
import com.example.hans_antlr4.exception.func.MainMethodNotFoundInPublicClass;

public class HantOperatorPriorityTest {
    @Test
    public void addSubtract1() throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getFirstStatementFromCode("var x = 3 + 4 - 5");
        Expression expression = new Subtraction(
                new Addition(new Value(BuiltInType.INT, "3"), new Value(BuiltInType.INT, "4")),
                new Value(BuiltInType.INT, "5"));
        VariableDeclaration variableDeclaration = new VariableDeclaration("x", expression);
        Assert.assertEquals(variableDeclaration, statement);
    }

    @Test
    public void addSubtract2() throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getFirstStatementFromCode("var x = 3 - 4 + 5");
        Expression expression = new Addition(
                new Subtraction(new Value(BuiltInType.INT, "3"), new Value(BuiltInType.INT, "4")),
                new Value(BuiltInType.INT, "5"));
        VariableDeclaration variableDeclaration = new VariableDeclaration("x", expression);
        Assert.assertEquals(variableDeclaration, statement);
    }

    @Test
    public void additiveAndMultiplicative() throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getFirstStatementFromCode("var x = 3 * 4 % 5 + 6 % 7 / 8 - 9 % 10");
        Expression expression = new Subtraction(
                new Addition(
                        new Mod(
                                new Multiplication(new Value(BuiltInType.INT, "3"),
                                        new Value(BuiltInType.INT, "4")),
                                new Value(BuiltInType.INT, "5")),
                        new Division(
                                new Mod(new Value(BuiltInType.INT, "6"),
                                        new Value(BuiltInType.INT, "7")),
                                new Value(BuiltInType.INT, "8"))),
                new Mod(
                        new Value(BuiltInType.INT, "9"),
                        new Value(BuiltInType.INT, "10")));
        VariableDeclaration variableDeclaration = new VariableDeclaration("x", expression);
        Assert.assertEquals(variableDeclaration, statement);
    }

    @Test
    public void additiveAndShift() throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getFirstStatementFromCode("var x = 3 << 4 >>> 5 - 6 + 7 >> 9 - 8");
        Expression expression = new Shr(
                new UnsignedShr(
                        new Shl(
                                new Value(BuiltInType.INT, "3"),
                                new Value(BuiltInType.INT, "4")),
                        new Addition(
                                new Subtraction(
                                        new Value(BuiltInType.INT, "5"),
                                        new Value(BuiltInType.INT, "6")),
                                new Value(BuiltInType.INT, "7"))),
                new Subtraction(
                        new Value(BuiltInType.INT, "9"),
                        new Value(BuiltInType.INT, "8")));
        VariableDeclaration variableDeclaration = new VariableDeclaration("x", expression);
        Assert.assertEquals(variableDeclaration, statement);
    }

    @Test
    public void bracketTest1() throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getFirstStatementFromCode("var x = (3 * 10 + 70)");
        Expression expression = new Addition(
                new Multiplication(new Value(BuiltInType.INT, "3"), new Value(BuiltInType.INT, "10")),
                new Value(BuiltInType.INT, "70"));
        VariableDeclaration variableDeclaration = new VariableDeclaration("x", expression);
        Assert.assertEquals(variableDeclaration, statement);
    }

    @Test
    public void bracketTest2() throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getFirstStatementFromCode("var x = (3 * (10 + 70))");
        Expression expression = new Multiplication(
                new Value(BuiltInType.INT, "3"),
                new Addition(new Value(BuiltInType.INT, "10"), new Value(BuiltInType.INT, "70")));
        VariableDeclaration variableDeclaration = new VariableDeclaration("x", expression);
        Assert.assertEquals(variableDeclaration, statement);
    }

    @Test
    public void unaryTest1() throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getFirstStatementFromCode("var x = ~-~~-+~-+114514");
        Expression expression = new UnaryTilde(
                new UnaryNegative(
                        new UnaryTilde(
                                new UnaryTilde(
                                        new UnaryNegative(
                                                new UnaryPositive(
                                                        new UnaryTilde(
                                                                new UnaryNegative(
                                                                        new UnaryPositive(
                                                                                new Value(BuiltInType.INT,
                                                                                        "114514"))))))))));
        VariableDeclaration variableDeclaration = new VariableDeclaration("x", expression);
        Assert.assertEquals(variableDeclaration, statement);
    }

    @Test
    public void unaryTest2() throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getFirstStatementFromCode("var x = -10 - +- 20");
        Expression expression = new Subtraction(
                new UnaryNegative(new Value(BuiltInType.INT, "10")),
                new UnaryPositive(new UnaryNegative(new Value(BuiltInType.INT, "20"))));
        VariableDeclaration variableDeclaration = new VariableDeclaration("x", expression);
        Assert.assertEquals(variableDeclaration, statement);
    }

    @Test
    public void unaryAndBracketTest1() throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getFirstStatementFromCode("var x = ~(40 + 30) ** ~-3");
        Expression expression = new Pow(
                new UnaryTilde(
                        new Addition(
                                new Value(BuiltInType.INT, "40"),
                                new Value(BuiltInType.INT, "30"))),
                new UnaryTilde(new UnaryNegative(new Value(BuiltInType.INT, "3"))));
        VariableDeclaration variableDeclaration = new VariableDeclaration("x", expression);
        Assert.assertEquals(variableDeclaration, statement);
    }

    @Test
    public void assignmentTest1() throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getLastStatementFromCode("var x = 1 x += x = 4 + (x += 3L)");
        LocalVariable x = new LocalVariable("x", BuiltInType.INT);
        Expression expression = new AssignmentExpression(
                x, AssignmentSign.ADD, new AssignmentExpression(
                        x, AssignmentSign.ASSIGN, new Addition(
                                new Value(BuiltInType.INT, "4"),
                                new AssignmentExpression(x, AssignmentSign.ADD,
                                        new Value(BuiltInType.LONG, "3"), 0)),
                        0),
                0);
        ExpressionStatement expressionStatement = new ExpressionStatement(expression);
        Assert.assertEquals(expressionStatement, statement);
    }

    @Test
    public void assignmentTest2() throws MainMethodNotFoundInPublicClass {
        String code1 = "var tmpL = 0xfcL\nvar tmpF = 2.34f\ntmpF *= tmpF + (tmpL |= tmpL ^= tmpL &= 0x3f1)";
        String code2 = "var tmpL = 0xfcL\nvar tmpF = 2.34f\ntmpF *= tmpF + tmpL |= tmpL ^= tmpL &= 0x3f1";
        Statement statement1 = TestUtils.getLastStatementFromCode(code1);
        Assert.assertThrows(IllegalAssignmentLhsType.class, () -> {
            TestUtils.getLastStatementFromCode(code2);
        });
        // Statement statement2 = TestUtils.getLastStatementFromCode(code2);
        LocalVariable tmpF = new LocalVariable("tmpF", BuiltInType.FLOAT);
        LocalVariable tmpL = new LocalVariable("tmpL", BuiltInType.LONG);
        Expression expression = new AssignmentExpression(
                tmpF, AssignmentSign.MUL, new Addition(
                        new VarReference("tmpF", BuiltInType.FLOAT),
                        new AssignmentExpression(tmpL, AssignmentSign.OR,
                                new AssignmentExpression(
                                        tmpL, AssignmentSign.XOR,
                                        new AssignmentExpression(
                                                tmpL,
                                                AssignmentSign.AND,
                                                new Value(BuiltInType.INT,
                                                        "0x3f1"),
                                                0),
                                        0),
                                0)),
                0);
        ExpressionStatement expressionStatement = new ExpressionStatement(expression);
        Assert.assertEquals(expressionStatement, statement1);
        // Assert.assertEquals(expressionStatement, statement2);
        // Assert.assertEquals(statement1, statement2);
    }
}
