package com.example.hans_antlr4.data_processor;

import org.junit.Assert;
import org.junit.Test;

import com.example.hans_antlr4.domain.expression.Addition;
import com.example.hans_antlr4.domain.expression.AssignmentExpression;
import com.example.hans_antlr4.domain.expression.Pow;
import com.example.hans_antlr4.domain.expression.Subtraction;
import com.example.hans_antlr4.domain.expression.Value;
import com.example.hans_antlr4.domain.expression.VarReference;
import com.example.hans_antlr4.domain.expression.unary.UnaryTilde;
import com.example.hans_antlr4.domain.global.AssignmentSign;
import com.example.hans_antlr4.domain.statement.PrintStatement;
import com.example.hans_antlr4.domain.type.BuiltInType;

public class ExpressionProcessorTest {
    @Test
    public void expressionCase1() {
        VarReference powL = new VarReference("x", BuiltInType.INT);
        Value powR = new Value(BuiltInType.INT, "2");
        Pow pow = new Pow(powL, powR);
        VarReference subtractionL = new VarReference("x", BuiltInType.INT);
        Value subtractionR = new Value(BuiltInType.INT, "2");
        Subtraction subtraction = new Subtraction(subtractionL, subtractionR);
        UnaryTilde unaryTilde = new UnaryTilde(subtraction);
        Addition addition = new Addition(pow, unaryTilde);
        PrintStatement mockStatement = new PrintStatement(addition);
        addition.processSubExpressionTree(new ExpressionTreeProcessor(), null, mockStatement);

        Assert.assertTrue(addition.getParent() == null);
        Assert.assertTrue(pow.getParent() == addition);
        Assert.assertTrue(unaryTilde.getParent() == addition);
        Assert.assertTrue(powL.getParent() == pow);
        Assert.assertTrue(powR.getParent() == pow);
        Assert.assertTrue(subtraction.getParent() == unaryTilde);
        Assert.assertTrue(subtractionL.getParent() == subtraction);
        Assert.assertTrue(subtractionR.getParent() == subtraction);

        Assert.assertTrue(addition.getBelongStatement() == mockStatement);
        Assert.assertTrue(pow.getBelongStatement() == mockStatement);
        Assert.assertTrue(unaryTilde.getBelongStatement() == mockStatement);
        Assert.assertTrue(powL.getBelongStatement() == mockStatement);
        Assert.assertTrue(powR.getBelongStatement() == mockStatement);
        Assert.assertTrue(subtraction.getBelongStatement() == mockStatement);
        Assert.assertTrue(subtractionL.getBelongStatement() == mockStatement);
        Assert.assertTrue(subtractionR.getBelongStatement() == mockStatement);
    }

    @Test
    public void expressionCase2() {
        VarReference powL = new VarReference("x", BuiltInType.INT);
        Value powR = new Value(BuiltInType.INT, "2");
        Pow pow = new Pow(powL, powR);
        VarReference subtractionL = new VarReference("x", BuiltInType.INT);
        Value subtractionR = new Value(BuiltInType.INT, "2");
        Subtraction subtraction = new Subtraction(subtractionL, subtractionR);
        AssignmentExpression assignmentAdd = new AssignmentExpression("x", AssignmentSign.ADD, subtraction);
        UnaryTilde unaryTilde = new UnaryTilde(assignmentAdd);
        Addition addition = new Addition(pow, unaryTilde);
        PrintStatement mockStatement = new PrintStatement(addition);
        addition.processSubExpressionTree(new ExpressionTreeProcessor(), null, mockStatement);

        Assert.assertTrue(addition.getParent() == null);
        Assert.assertTrue(pow.getParent() == addition);
        Assert.assertTrue(unaryTilde.getParent() == addition);
        Assert.assertTrue(powL.getParent() == pow);
        Assert.assertTrue(powR.getParent() == pow);
        Assert.assertTrue(assignmentAdd.getParent() == unaryTilde);
        Assert.assertTrue(subtraction.getParent() == assignmentAdd);
        Assert.assertTrue(subtractionL.getParent() == subtraction);
        Assert.assertTrue(subtractionR.getParent() == subtraction);

        Assert.assertTrue(addition.getBelongStatement() == mockStatement);
        Assert.assertTrue(pow.getBelongStatement() == mockStatement);
        Assert.assertTrue(unaryTilde.getBelongStatement() == mockStatement);
        Assert.assertTrue(powL.getBelongStatement() == mockStatement);
        Assert.assertTrue(powR.getBelongStatement() == mockStatement);
        Assert.assertTrue(assignmentAdd.getBelongStatement() == mockStatement);
        Assert.assertTrue(subtraction.getBelongStatement() == mockStatement);
        Assert.assertTrue(subtractionL.getBelongStatement() == mockStatement);
        Assert.assertTrue(subtractionR.getBelongStatement() == mockStatement);
    }
}
