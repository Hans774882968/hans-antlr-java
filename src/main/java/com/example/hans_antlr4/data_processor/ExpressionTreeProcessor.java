package com.example.hans_antlr4.data_processor;

import com.example.hans_antlr4.domain.expression.ArithmeticExpression;
import com.example.hans_antlr4.domain.expression.AssignmentExpression;
import com.example.hans_antlr4.domain.expression.ConditionalExpression;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.expression.Value;
import com.example.hans_antlr4.domain.expression.VarReference;
import com.example.hans_antlr4.domain.expression.unary.Unary;

public class ExpressionTreeProcessor {
    public void processExpressionTree(Unary unary, Expression parent) {
        if (unary == null) {
            return;
        }
        unary.setParent(parent);
        unary.getExpression().processSubExpressionTree(this, unary);
    }

    public void processExpressionTree(ArithmeticExpression arithmeticExpression, Expression parent) {
        if (arithmeticExpression == null) {
            return;
        }
        arithmeticExpression.setParent(parent);
        arithmeticExpression.getLeftExpression().processSubExpressionTree(this, arithmeticExpression);
        arithmeticExpression.getRightExpression().processSubExpressionTree(this, arithmeticExpression);
    }

    public void processExpressionTree(AssignmentExpression assignmentExpression, Expression parent) {
        if (assignmentExpression == null) {
            return;
        }
        assignmentExpression.setParent(parent);
        assignmentExpression.getExpression().processSubExpressionTree(this, assignmentExpression);
    }

    public void processExpressionTree(ConditionalExpression conditionalExpression, Expression parent) {
        if (conditionalExpression == null) {
            return;
        }
        conditionalExpression.setParent(parent);
        conditionalExpression.getLeftExpression().processSubExpressionTree(this, conditionalExpression);
        conditionalExpression.getRightExpression().processSubExpressionTree(this, conditionalExpression);
    }

    public void processExpressionTree(Value value, Expression parent) {
        if (value == null) {
            return;
        }
        value.setParent(parent);
    }

    public void processExpressionTree(VarReference varReference, Expression parent) {
        if (varReference == null) {
            return;
        }
        varReference.setParent(parent);
    }
}
