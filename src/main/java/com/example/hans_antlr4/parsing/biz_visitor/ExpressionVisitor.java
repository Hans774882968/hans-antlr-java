package com.example.hans_antlr4.parsing.biz_visitor;

import org.antlr.v4.runtime.tree.TerminalNode;

import com.example.hans_antlr4.domain.expression.Addition;
import com.example.hans_antlr4.domain.expression.Additive;
import com.example.hans_antlr4.domain.expression.And;
import com.example.hans_antlr4.domain.expression.ConditionalExpression;
import com.example.hans_antlr4.domain.expression.Division;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.expression.Mod;
import com.example.hans_antlr4.domain.expression.Multiplication;
import com.example.hans_antlr4.domain.expression.Multiplicative;
import com.example.hans_antlr4.domain.expression.Or;
import com.example.hans_antlr4.domain.expression.Pow;
import com.example.hans_antlr4.domain.expression.Shift;
import com.example.hans_antlr4.domain.expression.Shl;
import com.example.hans_antlr4.domain.expression.Shr;
import com.example.hans_antlr4.domain.expression.Subtraction;
import com.example.hans_antlr4.domain.expression.UnsignedShr;
import com.example.hans_antlr4.domain.expression.Value;
import com.example.hans_antlr4.domain.expression.VarReference;
import com.example.hans_antlr4.domain.expression.Xor;
import com.example.hans_antlr4.domain.expression.unary.Unary;
import com.example.hans_antlr4.domain.expression.unary.UnaryNegative;
import com.example.hans_antlr4.domain.expression.unary.UnaryPositive;
import com.example.hans_antlr4.domain.expression.unary.UnaryTilde;
import com.example.hans_antlr4.domain.global.CompareSign;
import com.example.hans_antlr4.domain.scope.LocalVariable;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.Type;
import com.example.hans_antlr4.parsing.HansAntlrBaseVisitor;
import com.example.hans_antlr4.parsing.HansAntlrParser;
import com.example.hans_antlr4.parsing.HansAntlrParser.ExpressionContext;
import com.example.hans_antlr4.utils.TypeResolver;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ExpressionVisitor extends HansAntlrBaseVisitor<Expression> {
    private Scope scope;

    @Override
    public Expression visitVarReference(HansAntlrParser.VarReferenceContext ctx) {
        String varName = ctx.getText();
        LocalVariable localVariable = scope.getLocalVariable(varName);
        return new VarReference(varName, localVariable.getType());
    }

    @Override
    public Expression visitValue(HansAntlrParser.ValueContext ctx) {
        String value = ctx.getText();
        Type type = TypeResolver.getFromValue(value);
        return new Value(type, value);
    }

    @Override
    public Expression visitBRACKET(HansAntlrParser.BRACKETContext ctx) {
        Expression expression = ctx.expression().accept(this);
        return expression;
    }

    @Override
    public Unary visitUNARY(HansAntlrParser.UNARYContext ctx) {
        Expression expression = ctx.expression().accept(this);
        String op = ctx.UNARY.getText();
        if (op.equals("+")) {
            return new UnaryPositive(expression);
        }
        if (op.equals("-")) {
            return new UnaryNegative(expression);
        }
        return new UnaryTilde(expression);
    }

    @Override
    public Pow visitPOW(HansAntlrParser.POWContext ctx) {
        ExpressionContext leftExpressionContext = ctx.expression(0);
        ExpressionContext rightExpressionContext = ctx.expression(1);
        Expression leftExpression = leftExpressionContext.accept(this);
        Expression rightExpression = rightExpressionContext.accept(this);
        return new Pow(leftExpression, rightExpression);
    }

    @Override
    public Additive visitADDITIVE(HansAntlrParser.ADDITIVEContext ctx) {
        ExpressionContext leftExpressionContext = ctx.expression(0);
        ExpressionContext rightExpressionContext = ctx.expression(1);
        Expression leftExpression = leftExpressionContext.accept(this);
        Expression rightExpression = rightExpressionContext.accept(this);
        String op = ctx.ADDITIVE.getText();
        if (op.equals("+")) {
            return new Addition(leftExpression, rightExpression);
        }
        return new Subtraction(leftExpression, rightExpression);
    }

    @Override
    public Multiplicative visitMULTIPLICATIVE(HansAntlrParser.MULTIPLICATIVEContext ctx) {
        ExpressionContext leftExpressionContext = ctx.expression(0);
        ExpressionContext rightExpressionContext = ctx.expression(1);
        Expression leftExpression = leftExpressionContext.accept(this);
        Expression rightExpression = rightExpressionContext.accept(this);
        String op = ctx.MULTIPLICATIVE().getText();
        if (op.equals("*")) {
            return new Multiplication(leftExpression, rightExpression);
        }
        if (op.equals("/")) {
            return new Division(leftExpression, rightExpression);
        }
        return new Mod(leftExpression, rightExpression);
    }

    @Override
    public Shift visitSHIFT(HansAntlrParser.SHIFTContext ctx) {
        ExpressionContext leftExpressionContext = ctx.expression(0);
        ExpressionContext rightExpressionContext = ctx.expression(1);
        Expression leftExpression = leftExpressionContext.accept(this);
        Expression rightExpression = rightExpressionContext.accept(this);
        String op = ctx.SHIFT().getText();
        if (op.equals("<<")) {
            return new Shl(leftExpression, rightExpression);
        }
        if (op.equals(">>")) {
            return new Shr(leftExpression, rightExpression);
        }
        return new UnsignedShr(leftExpression, rightExpression);
    }

    public ConditionalExpression getConditionalExpression(
            ExpressionContext leftExpressionContext,
            ExpressionContext rightExpressionContext,
            TerminalNode terminalNode) {
        Expression leftExpression = leftExpressionContext.accept(this);
        Expression rightExpression = rightExpressionContext != null
                ? rightExpressionContext.accept(this)
                : new Value(BuiltInType.INT, "0");
        CompareSign cmpSign = terminalNode != null
                ? CompareSign.fromString(terminalNode.getText())
                : CompareSign.NOT_EQUAL;
        return new ConditionalExpression(leftExpression, rightExpression, cmpSign);
    }

    @Override
    public ConditionalExpression visitRELATIONAL(HansAntlrParser.RELATIONALContext ctx) {
        ExpressionContext leftExpressionContext = ctx.expression(0);
        ExpressionContext rightExpressionContext = ctx.expression(1);
        return getConditionalExpression(leftExpressionContext, rightExpressionContext, ctx.RELATIONAL());
    }

    @Override
    public ConditionalExpression visitEQUALITY(HansAntlrParser.EQUALITYContext ctx) {
        ExpressionContext leftExpressionContext = ctx.expression(0);
        ExpressionContext rightExpressionContext = ctx.expression(1);
        return getConditionalExpression(leftExpressionContext, rightExpressionContext, ctx.EQUALITY());
    }

    @Override
    public And visitAND(HansAntlrParser.ANDContext ctx) {
        ExpressionContext leftExpressionContext = ctx.expression(0);
        ExpressionContext rightExpressionContext = ctx.expression(1);
        Expression leftExpression = leftExpressionContext.accept(this);
        Expression rightExpression = rightExpressionContext.accept(this);
        return new And(leftExpression, rightExpression);
    }

    @Override
    public Xor visitXOR(HansAntlrParser.XORContext ctx) {
        ExpressionContext leftExpressionContext = ctx.expression(0);
        ExpressionContext rightExpressionContext = ctx.expression(1);
        Expression leftExpression = leftExpressionContext.accept(this);
        Expression rightExpression = rightExpressionContext.accept(this);
        return new Xor(leftExpression, rightExpression);
    }

    @Override
    public Or visitOR(HansAntlrParser.ORContext ctx) {
        ExpressionContext leftExpressionContext = ctx.expression(0);
        ExpressionContext rightExpressionContext = ctx.expression(1);
        Expression leftExpression = leftExpressionContext.accept(this);
        Expression rightExpression = rightExpressionContext.accept(this);
        return new Or(leftExpression, rightExpression);
    }
}
