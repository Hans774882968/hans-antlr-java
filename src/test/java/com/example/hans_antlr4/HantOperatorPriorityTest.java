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
import com.example.hans_antlr4.domain.expression.reference.VarReference;
import com.example.hans_antlr4.domain.expression.unary.UnaryNegative;
import com.example.hans_antlr4.domain.expression.unary.UnaryPositive;
import com.example.hans_antlr4.domain.expression.unary.UnaryTilde;
import com.example.hans_antlr4.domain.global.AssignmentSign;
import com.example.hans_antlr4.domain.scope.LocalVariable;
import com.example.hans_antlr4.domain.statement.ExpressionStatement;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.statement.var.VariableDeclaration;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.exception.assignment.IllegalAssignmentLhsType;
import com.example.hans_antlr4.exception.func.MainMethodNotFoundInPublicClass;
import com.example.hans_antlr4.utils.Const;

public class HantOperatorPriorityTest {
    @Test
    public void addSubtract1() throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getFirstStatementFromCode("var x = 3 + 4 - 5");
        Expression expression = Subtraction.subtractionWithoutSourceLine(
                Addition.additionWithoutSourceLine(
                        Value.valueWithoutSourceLine(BuiltInType.INT, "3"),
                        Value.valueWithoutSourceLine(BuiltInType.INT, "4")),
                Value.valueWithoutSourceLine(BuiltInType.INT, "5"));
        VariableDeclaration variableDeclaration = new VariableDeclaration("x", expression);
        Assert.assertEquals(variableDeclaration, statement);
    }

    @Test
    public void addSubtract2() throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getFirstStatementFromCode("var x = 3 - 4 + 5");
        Expression expression = Addition.additionWithoutSourceLine(
                Subtraction.subtractionWithoutSourceLine(
                        Value.valueWithoutSourceLine(BuiltInType.INT, "3"),
                        Value.valueWithoutSourceLine(BuiltInType.INT, "4")),
                Value.valueWithoutSourceLine(BuiltInType.INT, "5"));
        VariableDeclaration variableDeclaration = new VariableDeclaration("x", expression);
        Assert.assertEquals(variableDeclaration, statement);
    }

    @Test
    public void additiveAndMultiplicative() throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getFirstStatementFromCode("var x = 3 * 4 % 5 + 6 % 7 / 8 - 9 % 10");
        Expression expression = Subtraction.subtractionWithoutSourceLine(
                Addition.additionWithoutSourceLine(
                        Mod.modWithoutSourceLine(
                                Multiplication.multiplicationWithoutSourceLine(
                                        Value.valueWithoutSourceLine(BuiltInType.INT, "3"),
                                        Value.valueWithoutSourceLine(BuiltInType.INT, "4")),
                                Value.valueWithoutSourceLine(BuiltInType.INT, "5")),
                        Division.divisionWithoutSourceLine(
                                Mod.modWithoutSourceLine(Value.valueWithoutSourceLine(BuiltInType.INT, "6"),
                                        Value.valueWithoutSourceLine(BuiltInType.INT, "7")),
                                Value.valueWithoutSourceLine(BuiltInType.INT, "8"))),
                Mod.modWithoutSourceLine(
                        Value.valueWithoutSourceLine(BuiltInType.INT, "9"),
                        Value.valueWithoutSourceLine(BuiltInType.INT, "10")));
        VariableDeclaration variableDeclaration = new VariableDeclaration("x", expression);
        Assert.assertEquals(variableDeclaration, statement);
    }

    @Test
    public void additiveAndShift() throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getFirstStatementFromCode("var x = 3 << 4 >>> 5 - 6 + 7 >> 9 - 8");
        Expression expression = Shr.shrWithoutSourceLine(
                UnsignedShr.unsignedShrWithoutSourceLine(
                        Shl.shlWithoutSourceLine(
                                Value.valueWithoutSourceLine(BuiltInType.INT, "3"),
                                Value.valueWithoutSourceLine(BuiltInType.INT, "4")),
                        Addition.additionWithoutSourceLine(
                                Subtraction.subtractionWithoutSourceLine(
                                        Value.valueWithoutSourceLine(BuiltInType.INT, "5"),
                                        Value.valueWithoutSourceLine(BuiltInType.INT, "6")),
                                Value.valueWithoutSourceLine(BuiltInType.INT, "7"))),
                Subtraction.subtractionWithoutSourceLine(
                        Value.valueWithoutSourceLine(BuiltInType.INT, "9"),
                        Value.valueWithoutSourceLine(BuiltInType.INT, "8")));
        VariableDeclaration variableDeclaration = new VariableDeclaration("x", expression);
        Assert.assertEquals(variableDeclaration, statement);
    }

    @Test
    public void bracketTest1() throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getFirstStatementFromCode("var x = (3 * 10 + 70)");
        Expression expression = Addition.additionWithoutSourceLine(
                Multiplication.multiplicationWithoutSourceLine(Value.valueWithoutSourceLine(BuiltInType.INT, "3"),
                        Value.valueWithoutSourceLine(BuiltInType.INT, "10")),
                Value.valueWithoutSourceLine(BuiltInType.INT, "70"));
        VariableDeclaration variableDeclaration = new VariableDeclaration("x", expression);
        Assert.assertEquals(variableDeclaration, statement);
    }

    @Test
    public void bracketTest2() throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getFirstStatementFromCode("var x = (3 * (10 + 70))");
        Expression expression = Multiplication.multiplicationWithoutSourceLine(
                Value.valueWithoutSourceLine(BuiltInType.INT, "3"),
                Addition.additionWithoutSourceLine(Value.valueWithoutSourceLine(BuiltInType.INT, "10"),
                        Value.valueWithoutSourceLine(BuiltInType.INT, "70")));
        VariableDeclaration variableDeclaration = new VariableDeclaration("x", expression);
        Assert.assertEquals(variableDeclaration, statement);
    }

    @Test
    public void unaryTest1() throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getFirstStatementFromCode("var x = ~-~~-+~-+114514");
        Expression expression = UnaryTilde.unaryTildeWithoutSourceLine(
                UnaryNegative.unaryNegativeWithoutSourceLine(
                        UnaryTilde.unaryTildeWithoutSourceLine(
                                UnaryTilde.unaryTildeWithoutSourceLine(
                                        UnaryNegative.unaryNegativeWithoutSourceLine(
                                                UnaryPositive.unaryPositiveWithoutSourceLine(
                                                        UnaryTilde.unaryTildeWithoutSourceLine(
                                                                UnaryNegative.unaryNegativeWithoutSourceLine(
                                                                        UnaryPositive.unaryPositiveWithoutSourceLine(
                                                                                Value.valueWithoutSourceLine(
                                                                                        BuiltInType.INT,
                                                                                        "114514"))))))))));
        VariableDeclaration variableDeclaration = new VariableDeclaration("x", expression);
        Assert.assertEquals(variableDeclaration, statement);
    }

    @Test
    public void unaryTest2() throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getFirstStatementFromCode("var x = -10 - +- 20");
        Expression expression = Subtraction.subtractionWithoutSourceLine(
                UnaryNegative.unaryNegativeWithoutSourceLine(Value.valueWithoutSourceLine(BuiltInType.INT, "10")),
                UnaryPositive.unaryPositiveWithoutSourceLine(
                        UnaryNegative.unaryNegativeWithoutSourceLine(
                                Value.valueWithoutSourceLine(BuiltInType.INT, "20"))));
        VariableDeclaration variableDeclaration = new VariableDeclaration("x", expression);
        Assert.assertEquals(variableDeclaration, statement);
    }

    @Test
    public void unaryAndBracketTest1() throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getFirstStatementFromCode("var x = ~(40 + 30) ** ~-3");
        Expression expression = Pow.powWithoutSourceLine(
                UnaryTilde.unaryTildeWithoutSourceLine(
                        Addition.additionWithoutSourceLine(
                                Value.valueWithoutSourceLine(BuiltInType.INT, "40"),
                                Value.valueWithoutSourceLine(BuiltInType.INT, "30"))),
                UnaryTilde.unaryTildeWithoutSourceLine(
                        UnaryNegative.unaryNegativeWithoutSourceLine(
                                Value.valueWithoutSourceLine(BuiltInType.INT, "3"))));
        VariableDeclaration variableDeclaration = new VariableDeclaration("x", expression);
        Assert.assertEquals(variableDeclaration, statement);
    }

    @Test
    public void assignmentTest1() throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getLastStatementFromCode("var x = 1 x += x = 4 + (x += 3L)");
        LocalVariable x = new LocalVariable("x", BuiltInType.INT);
        Expression expression = new AssignmentExpression(
                x, AssignmentSign.ADD, new AssignmentExpression(
                        x, AssignmentSign.ASSIGN, Addition.additionWithoutSourceLine(
                                Value.valueWithoutSourceLine(BuiltInType.INT, "4"),
                                new AssignmentExpression(x, AssignmentSign.ADD,
                                        Value.valueWithoutSourceLine(BuiltInType.LONG, "3"), 0)),
                        Const.MOCK_SOURCE_LINE),
                Const.MOCK_SOURCE_LINE);
        ExpressionStatement expressionStatement = new ExpressionStatement(expression);
        Assert.assertEquals(expressionStatement, statement);
    }

    @Test
    public void assignmentTest2() throws MainMethodNotFoundInPublicClass {
        String code1 = "var tmpL = 0xfcL\nvar tmpF = 2.34f\ntmpF *= tmpF + (tmpL |= tmpL ^= tmpL &= 0x3f1)";
        String code2 = "var tmpL = 0xfcL\nvar tmpF = 2.34f\ntmpF *= tmpF + tmpL |= tmpL ^= tmpL &= 0x3f1";
        Statement statement1 = TestUtils.getLastStatementFromCode(code1);
        // TODO: 赋值语句的文法规则修改导致下面的语句不合语法
        Assert.assertThrows(IllegalAssignmentLhsType.class, () -> {
            TestUtils.getLastStatementFromCode(code2);
        });
        // Statement statement2 = TestUtils.getLastStatementFromCode(code2);
        LocalVariable tmpF = new LocalVariable("tmpF", BuiltInType.FLOAT);
        LocalVariable tmpL = new LocalVariable("tmpL", BuiltInType.LONG);
        Expression expression = new AssignmentExpression(
                tmpF, AssignmentSign.MUL, Addition.additionWithoutSourceLine(
                        VarReference.varReferenceWithoutSourceLine("tmpF", BuiltInType.FLOAT),
                        new AssignmentExpression(tmpL, AssignmentSign.OR,
                                new AssignmentExpression(
                                        tmpL, AssignmentSign.XOR,
                                        new AssignmentExpression(
                                                tmpL,
                                                AssignmentSign.AND,
                                                Value.valueWithoutSourceLine(BuiltInType.INT,
                                                        "0x3f1"),
                                                Const.MOCK_SOURCE_LINE),
                                        Const.MOCK_SOURCE_LINE),
                                Const.MOCK_SOURCE_LINE)),
                Const.MOCK_SOURCE_LINE);
        ExpressionStatement expressionStatement = new ExpressionStatement(expression);
        Assert.assertEquals(expressionStatement, statement1);
        // Assert.assertEquals(expressionStatement, statement2);
        // Assert.assertEquals(statement1, statement2);
    }
}
