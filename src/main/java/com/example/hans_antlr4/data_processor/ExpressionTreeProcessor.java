package com.example.hans_antlr4.data_processor;

import com.example.hans_antlr4.domain.expression.ArithmeticExpression;
import com.example.hans_antlr4.domain.expression.ArrayAccess;
import com.example.hans_antlr4.domain.expression.ArrayDeclaration;
import com.example.hans_antlr4.domain.expression.AssignmentExpression;
import com.example.hans_antlr4.domain.expression.ClassFieldReference;
import com.example.hans_antlr4.domain.expression.ConditionalExpression;
import com.example.hans_antlr4.domain.expression.EmptyExpression;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.expression.Value;
import com.example.hans_antlr4.domain.expression.VarReference;
import com.example.hans_antlr4.domain.expression.call.ConstructorCall;
import com.example.hans_antlr4.domain.expression.call.FunctionCall;
import com.example.hans_antlr4.domain.expression.unary.Unary;
import com.example.hans_antlr4.domain.statement.Statement;

/*
 * 1. setParent
 * 2. setBelongStatement
 * 3. processSubExpressionTree
 */
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

    public void processExpressionTree(
            ClassFieldReference classFieldReference,
            Expression parent,
            Statement belongStatement) {
        if (classFieldReference == null) {
            return;
        }
        classFieldReference.setParent(parent);
        classFieldReference.setBelongStatement(belongStatement);
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

    public void processExpressionTree(EmptyExpression emptyExpression, Expression parent, Statement belongStatement) {
        if (emptyExpression == null) {
            return;
        }
        emptyExpression.setParent(parent);
        emptyExpression.setBelongStatement(belongStatement);
    }

    public void processExpressionTree(ConstructorCall constructorCall, Expression parent, Statement belongStatement) {
        if (constructorCall == null) {
            return;
        }
        constructorCall.setParent(parent);
        constructorCall.setBelongStatement(belongStatement);
        constructorCall.getArguments().forEach(arg -> {
            arg.processSubExpressionTree(this, constructorCall, belongStatement);
        });
    }

    public void processExpressionTree(ArrayDeclaration arrayDeclaration, Expression parent, Statement belongStatement) {
        if (arrayDeclaration == null) {
            return;
        }
        arrayDeclaration.setParent(parent);
        arrayDeclaration.setBelongStatement(belongStatement);
        arrayDeclaration.getDimensions().forEach(dimension -> {
            dimension.processSubExpressionTree(this, arrayDeclaration, belongStatement);
        });
    }

    public void processExpressionTree(ArrayAccess arrayAccess, Expression parent, Statement belongStatement) {
        if (arrayAccess == null) {
            return;
        }
        arrayAccess.setParent(parent);
        arrayAccess.setBelongStatement(belongStatement);
        arrayAccess.getArray().processSubExpressionTree(this, arrayAccess, belongStatement);
        arrayAccess.getDimensions().forEach(dimension -> {
            dimension.processSubExpressionTree(this, arrayAccess, belongStatement);
        });
    }
}
