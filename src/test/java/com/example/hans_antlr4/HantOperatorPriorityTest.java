package com.example.hans_antlr4;

import org.junit.Assert;
import org.junit.Test;

import com.example.hans_antlr4.domain.expression.Addition;
import com.example.hans_antlr4.domain.expression.Division;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.expression.Mod;
import com.example.hans_antlr4.domain.expression.Multiplication;
import com.example.hans_antlr4.domain.expression.Shl;
import com.example.hans_antlr4.domain.expression.Shr;
import com.example.hans_antlr4.domain.expression.Subtraction;
import com.example.hans_antlr4.domain.expression.UnsignedShr;
import com.example.hans_antlr4.domain.expression.Value;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.statement.VariableDeclaration;
import com.example.hans_antlr4.domain.type.BuiltInType;

public class HantOperatorPriorityTest {
    @Test
    public void addSubtract1() {
        Statement statement = TestUtils.getFirstStatementFromCode("var x = 3 + 4 - 5");
        Expression expression = new Subtraction(
                new Addition(new Value(BuiltInType.INT, "3"), new Value(BuiltInType.INT, "4")),
                new Value(BuiltInType.INT, "5"));
        VariableDeclaration variableDeclaration = new VariableDeclaration("x", expression);
        Assert.assertEquals(variableDeclaration, statement);
    }

    @Test
    public void addSubtract2() {
        Statement statement = TestUtils.getFirstStatementFromCode("var x = 3 - 4 + 5");
        Expression expression = new Addition(
                new Subtraction(new Value(BuiltInType.INT, "3"), new Value(BuiltInType.INT, "4")),
                new Value(BuiltInType.INT, "5"));
        VariableDeclaration variableDeclaration = new VariableDeclaration("x", expression);
        Assert.assertEquals(variableDeclaration, statement);
    }

    @Test
    public void additiveAndMultiplicative() {
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
    public void additiveAndShift() {
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
}
