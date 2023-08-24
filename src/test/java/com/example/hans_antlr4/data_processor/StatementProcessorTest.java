package com.example.hans_antlr4.data_processor;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.example.hans_antlr4.domain.expression.Addition;
import com.example.hans_antlr4.domain.expression.Value;
import com.example.hans_antlr4.domain.expression.VarReference;
import com.example.hans_antlr4.domain.expression.unary.UnaryTilde;
import com.example.hans_antlr4.domain.statement.Block;
import com.example.hans_antlr4.domain.statement.RangedForStatement;
import com.example.hans_antlr4.domain.statement.VariableDeclaration;
import com.example.hans_antlr4.domain.type.BuiltInType;

public class StatementProcessorTest {
    @Test
    public void statementCase1() {
        Value value1 = new Value(BuiltInType.INT, "1");
        VariableDeclaration variableDeclaration = new VariableDeclaration("x", value1);
        VarReference addL = new VarReference("y", BuiltInType.INT);
        VarReference addR = new VarReference("z", BuiltInType.INT);
        Addition startExpr = new Addition(addL, addR);
        Value value2 = new Value(BuiltInType.INT, "2");
        UnaryTilde endExpr = new UnaryTilde(value2);
        RangedForStatement rangedForStatement = new RangedForStatement(variableDeclaration, "x", startExpr, endExpr,
                null, null);
        Block block = new Block(new ArrayList<>(Arrays.asList(rangedForStatement)), null);

        block.processSubStatementTree(new StatementTreeProcessor(), null);
        Assert.assertTrue(block.getParent() == null);
        Assert.assertTrue(rangedForStatement.getParent() == block);
        Assert.assertTrue(variableDeclaration.getParent() == rangedForStatement);
        Assert.assertTrue(startExpr.getParent() == null);
        Assert.assertTrue(endExpr.getParent() == null);
        Assert.assertTrue(value1.getParent() == null);
        Assert.assertTrue(addL.getParent() == startExpr);
        Assert.assertTrue(addR.getParent() == startExpr);
        Assert.assertTrue(value2.getParent() == endExpr);
    }
}
