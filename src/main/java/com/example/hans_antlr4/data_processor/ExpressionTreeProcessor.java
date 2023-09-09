package com.example.hans_antlr4.data_processor;

import com.example.hans_antlr4.domain.expression.ArithmeticExpression;
import com.example.hans_antlr4.domain.expression.AssignmentExpression;
import com.example.hans_antlr4.domain.expression.ConditionalExpression;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.expression.Value;
import com.example.hans_antlr4.domain.expression.VarReference;
import com.example.hans_antlr4.domain.expression.call.FunctionCall;
import com.example.hans_antlr4.domain.expression.unary.Unary;
import com.example.hans_antlr4.domain.statement.Statement;

public class ExpressionTreeProcessor {
    public void processExpressionTree(Unary unary, Expression parent, Statement belongStatement) {
        if (unary == null) {
            return;
        }
        unary.setParent(parent);
        unary.setBelongStatement(belongStatement);
        unary.getExpression().processSubExpressionTree(this, unary, belongStatement);
    }

    public void processExpressionTree(
            ArithmeticExpression arithmeticExpression,
            Expression parent,
            Statement belongStatement) {
        if (arithmeticExpression == null) {
            return;
        }
        arithmeticExpression.setParent(parent);
        arithmeticExpression.setBelongStatement(belongStatement);
        arithmeticExpression.getLeftExpression().processSubExpressionTree(this, arithmeticExpression, belongStatement);
        arithmeticExpression.getRightExpression().processSubExpressionTree(this, arithmeticExpression, belongStatement);
    }

    public void processExpressionTree(
            AssignmentExpression assignmentExpression,
            Expression parent,
            Statement belongStatement) {
        if (assignmentExpression == null) {
            return;
        }
        assignmentExpression.setParent(parent);
        assignmentExpression.setBelongStatement(belongStatement);
        assignmentExpression.getExpression().processSubExpressionTree(this, assignmentExpression, belongStatement);
    }

    public void processExpressionTree(
            ConditionalExpression conditionalExpression,
            Expression parent,
            Statement belongStatement) {
        if (conditionalExpression == null) {
            return;
        }
        conditionalExpression.setParent(parent);
        conditionalExpression.setBelongStatement(belongStatement);
        conditionalExpression.getLeftExpression().processSubExpressionTree(
                this, conditionalExpression, belongStatement);
        conditionalExpression.getRightExpression().processSubExpressionTree(
                this, conditionalExpression, belongStatement);
    }

    public void processExpressionTree(Value value, Expression parent, Statement belongStatement) {
        if (value == null) {
            return;
        }
        value.setParent(parent);
        value.setBelongStatement(belongStatement);
    }

    public void processExpressionTree(VarReference varReference, Expression parent, Statement belongStatement) {
        if (varReference == null) {
            return;
        }
        varReference.setParent(parent);
        varReference.setBelongStatement(belongStatement);
    }

    public void processExpressionTree(FunctionCall functionCall, Expression parent, Statement belongStatement) {
        if (functionCall == null) {
            return;
        }
        functionCall.setParent(parent);
        functionCall.setBelongStatement(belongStatement);
        functionCall.getArguments().forEach(arg -> {
            arg.processSubExpressionTree(this, functionCall, belongStatement);
        });
    }
}
