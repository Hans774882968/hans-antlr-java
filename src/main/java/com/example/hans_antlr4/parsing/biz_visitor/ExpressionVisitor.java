package com.example.hans_antlr4.parsing.biz_visitor;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

import com.example.hans_antlr4.domain.expression.Addition;
import com.example.hans_antlr4.domain.expression.Additive;
import com.example.hans_antlr4.domain.expression.And;
import com.example.hans_antlr4.domain.expression.AssignmentExpression;
import com.example.hans_antlr4.domain.expression.ClassFieldReference;
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
import com.example.hans_antlr4.domain.expression.call.ConstructorCall;
import com.example.hans_antlr4.domain.expression.call.FunctionCall;
import com.example.hans_antlr4.domain.expression.unary.Unary;
import com.example.hans_antlr4.domain.expression.unary.UnaryNegative;
import com.example.hans_antlr4.domain.expression.unary.UnaryPositive;
import com.example.hans_antlr4.domain.expression.unary.UnaryTilde;
import com.example.hans_antlr4.domain.global.ArithmeticSign;
import com.example.hans_antlr4.domain.global.AssignmentSign;
import com.example.hans_antlr4.domain.global.CompareSign;
import com.example.hans_antlr4.domain.scope.FieldReferenceRecord;
import com.example.hans_antlr4.domain.scope.LocalVariable;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.Type;
import com.example.hans_antlr4.domain.type.TypeChecker;
import com.example.hans_antlr4.exception.ArithmeticExprLhsAndRhsTypeIncompatibleException;
import com.example.hans_antlr4.exception.AssignmentLhsAndRhsTypeIncompatibleException;
import com.example.hans_antlr4.exception.ConditionalExprLhsAndRhsTypeIncompatibleException;
import com.example.hans_antlr4.exception.IllegalShiftTypeException;
import com.example.hans_antlr4.parsing.HansAntlrBaseVisitor;
import com.example.hans_antlr4.parsing.HansAntlrParser;
import com.example.hans_antlr4.parsing.HansAntlrParser.ExpressionContext;
import com.example.hans_antlr4.utils.HantNumber;
import com.example.hans_antlr4.utils.TypeResolver;

public class ExpressionVisitor extends HansAntlrBaseVisitor<Expression> {
    private Scope scope;
    private CallExpressionVisitor callExpressionVisitor;

    public ExpressionVisitor(Scope scope) {
        this.scope = scope;
        this.callExpressionVisitor = new CallExpressionVisitor(scope, this);
    }

    private int getFindFieldStartIndex(String[] identifiers, String classFieldString) {
        String curClassQualifiedName = "";
        int findFieldStartIndex = -1;
        for (int i = 0; i < identifiers.length; i++) {
            String identifier = identifiers[i];
            curClassQualifiedName += identifier;
            try {
                Class.forName(curClassQualifiedName);
                findFieldStartIndex = i + 1;
                break;
            } catch (ClassNotFoundException e) {
                curClassQualifiedName += ".";
            }
        }
        if (findFieldStartIndex == -1) {
            throw new RuntimeException("Definition of class " + classFieldString + " not found");
        }
        return findFieldStartIndex;
    }

    private String getClassQualifiedName(String[] identifiers, int classNameEndIndex) {
        String classQualifiedName = identifiers[0];
        for (int i = 1; i < classNameEndIndex; i++) {
            classQualifiedName += "." + identifiers[i];
        }
        return classQualifiedName;
    }

    @Override
    public ClassFieldReference visitClazzFieldReference(HansAntlrParser.ClazzFieldReferenceContext ctx) {
        String classFieldString = ctx.getText();
        String[] identifiers = classFieldString.split("\\.");

        int findFieldStartIndex = getFindFieldStartIndex(identifiers, classFieldString);
        String classQualifiedName = getClassQualifiedName(identifiers, findFieldStartIndex);

        Class<?> currentOwnerClass = null;
        try {
            currentOwnerClass = Class.forName(classQualifiedName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        List<FieldReferenceRecord> fieldReferenceRecords = new ArrayList<>();

        for (int i = findFieldStartIndex; i < identifiers.length; i++) {
            final String identifier = identifiers[i];
            Field field = null;
            try {
                if (currentOwnerClass == null) {
                    int sourceLine = ctx.getStart().getLine();
                    throw new ClassNotFoundException(
                            "There is a ClassNotFoundException while trying to parse "
                                    + classFieldString + " at line" + sourceLine);
                }
                field = currentOwnerClass.getField(identifier);
            } catch (NoSuchFieldException | SecurityException | ClassNotFoundException e) {
                e.printStackTrace();
                System.exit(-1);
            }

            try {
                if (field == null) {
                    int sourceLine = ctx.getStart().getLine();
                    throw new NoSuchFieldException(
                            "Field " + identifier + " was not found in \""
                                    + (currentOwnerClass == null ? "" : currentOwnerClass.getCanonicalName())
                                    + "\" at line " + sourceLine);
                }
                boolean isStatic = Modifier.isStatic(field.getModifiers());
                final Type currentOwnerType = TypeResolver.getFromJavaLangClass(currentOwnerClass);
                Class<?> fieldClass = field.getType();
                Type fieldType = TypeResolver.getFromJavaLangClass(fieldClass);
                fieldReferenceRecords.add(new FieldReferenceRecord(
                        isStatic, currentOwnerType, identifier, fieldType));

                currentOwnerClass = fieldClass;
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }

        return new ClassFieldReference(classQualifiedName, fieldReferenceRecords);
    }

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
        // 约定：getValueFromString 调用时已经没有 typeSuffix
        String pureNumber = HantNumber.getStringWithoutTypeSuffix(value);
        return new Value(type, pureNumber);
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
        Pow res = new Pow(leftExpression, rightExpression);
        if (!TypeChecker.arithmeticLhsTypeAndRhsAreCompatible(res)) {
            int sourceLine = ctx.getStart().getLine();
            throw new ArithmeticExprLhsAndRhsTypeIncompatibleException(res, sourceLine);
        }
        return res;
    }

    @Override
    public Additive visitADDITIVE(HansAntlrParser.ADDITIVEContext ctx) {
        ExpressionContext leftExpressionContext = ctx.expression(0);
        ExpressionContext rightExpressionContext = ctx.expression(1);
        Expression leftExpression = leftExpressionContext.accept(this);
        Expression rightExpression = rightExpressionContext.accept(this);
        String op = ctx.ADDITIVE.getText();
        Additive res = null;
        if (op.equals(ArithmeticSign.ADD.getSign())) {
            res = new Addition(leftExpression, rightExpression);
        } else {
            res = new Subtraction(leftExpression, rightExpression);
        }
        if (!TypeChecker.arithmeticLhsTypeAndRhsAreCompatible(res)) {
            int sourceLine = ctx.getStart().getLine();
            throw new ArithmeticExprLhsAndRhsTypeIncompatibleException(res, sourceLine);
        }
        return res;
    }

    @Override
    public Multiplicative visitMULTIPLICATIVE(HansAntlrParser.MULTIPLICATIVEContext ctx) {
        ExpressionContext leftExpressionContext = ctx.expression(0);
        ExpressionContext rightExpressionContext = ctx.expression(1);
        Expression leftExpression = leftExpressionContext.accept(this);
        Expression rightExpression = rightExpressionContext.accept(this);
        String op = ctx.MULTIPLICATIVE().getText();
        Multiplicative res = null;
        if (op.equals(ArithmeticSign.MUL.getSign())) {
            res = new Multiplication(leftExpression, rightExpression);
        } else if (op.equals(ArithmeticSign.DIV.getSign())) {
            res = new Division(leftExpression, rightExpression);
        } else {
            res = new Mod(leftExpression, rightExpression);
        }
        if (!TypeChecker.arithmeticLhsTypeAndRhsAreCompatible(res)) {
            int sourceLine = ctx.getStart().getLine();
            throw new ArithmeticExprLhsAndRhsTypeIncompatibleException(res, sourceLine);
        }
        return res;
    }

    @Override
    public Shift visitSHIFT(HansAntlrParser.SHIFTContext ctx) {
        ExpressionContext leftExpressionContext = ctx.expression(0);
        ExpressionContext rightExpressionContext = ctx.expression(1);
        Expression leftExpression = leftExpressionContext.accept(this);
        Expression rightExpression = rightExpressionContext.accept(this);
        String op = ctx.SHIFT().getText();
        Type leftType = leftExpression.getType();
        Type rightType = rightExpression.getType();
        if (!TypeChecker.isLegalShiftType(leftType, rightType)) {
            int sourceLine = ctx.getStart().getLine();
            throw new IllegalShiftTypeException(leftType, rightType, sourceLine);
        }
        Shift res = null;
        if (op.equals(ArithmeticSign.SHL.getSign())) {
            res = new Shl(leftExpression, rightExpression);
        } else if (op.equals(ArithmeticSign.SHR.getSign())) {
            res = new Shr(leftExpression, rightExpression);
        } else {
            res = new UnsignedShr(leftExpression, rightExpression);
        }
        if (!TypeChecker.arithmeticLhsTypeAndRhsAreCompatible(res)) {
            int sourceLine = ctx.getStart().getLine();
            throw new ArithmeticExprLhsAndRhsTypeIncompatibleException(res, sourceLine);
        }
        return res;
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
        Type lhsType = leftExpression.getType();
        Type rhsType = rightExpression.getType();
        if (!TypeChecker.conditionalLhsTypeAndRhsAreCompatible(lhsType, rhsType)) {
            int sourceLine = leftExpressionContext.getStart().getLine();
            throw new ConditionalExprLhsAndRhsTypeIncompatibleException(lhsType, rhsType, sourceLine);
        }
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
        And res = new And(leftExpression, rightExpression);
        if (!TypeChecker.arithmeticLhsTypeAndRhsAreCompatible(res)) {
            int sourceLine = ctx.getStart().getLine();
            throw new ArithmeticExprLhsAndRhsTypeIncompatibleException(res, sourceLine);
        }
        return res;
    }

    @Override
    public Xor visitXOR(HansAntlrParser.XORContext ctx) {
        ExpressionContext leftExpressionContext = ctx.expression(0);
        ExpressionContext rightExpressionContext = ctx.expression(1);
        Expression leftExpression = leftExpressionContext.accept(this);
        Expression rightExpression = rightExpressionContext.accept(this);
        Xor res = new Xor(leftExpression, rightExpression);
        if (!TypeChecker.arithmeticLhsTypeAndRhsAreCompatible(res)) {
            int sourceLine = ctx.getStart().getLine();
            throw new ArithmeticExprLhsAndRhsTypeIncompatibleException(res, sourceLine);
        }
        return res;
    }

    @Override
    public Or visitOR(HansAntlrParser.ORContext ctx) {
        ExpressionContext leftExpressionContext = ctx.expression(0);
        ExpressionContext rightExpressionContext = ctx.expression(1);
        Expression leftExpression = leftExpressionContext.accept(this);
        Expression rightExpression = rightExpressionContext.accept(this);
        Or res = new Or(leftExpression, rightExpression);
        if (!TypeChecker.arithmeticLhsTypeAndRhsAreCompatible(res)) {
            int sourceLine = ctx.getStart().getLine();
            throw new ArithmeticExprLhsAndRhsTypeIncompatibleException(res, sourceLine);
        }
        return res;
    }

    @Override
    public AssignmentExpression visitASSIGNMENT(HansAntlrParser.ASSIGNMENTContext ctx) {
        final String varName = ctx.variableReference().getText();
        final String op = ctx.AssignmentOperator.getText();
        AssignmentSign assignmentSign = AssignmentSign.fromString(op);
        Expression expression = ctx.expression().accept(this);
        LocalVariable localVariable = scope.getLocalVariable(varName);
        Type lhsType = localVariable.getType();
        Type rhsType = expression.getType();
        if (!TypeChecker.assignmentLhsTypeAndRhsAreCompatible(assignmentSign, lhsType, rhsType)) {
            int sourceLine = ctx.AssignmentOperator.getLine();
            throw new AssignmentLhsAndRhsTypeIncompatibleException(lhsType, rhsType, assignmentSign, sourceLine);
        }
        return new AssignmentExpression(localVariable, assignmentSign, expression);
    }

    @Override
    public FunctionCall visitFunctionCall(HansAntlrParser.FunctionCallContext ctx) {
        return (FunctionCall) ctx.accept(callExpressionVisitor);
    }

    @Override
    public ConstructorCall visitConstructorCall(HansAntlrParser.ConstructorCallContext ctx) {
        return (ConstructorCall) ctx.accept(callExpressionVisitor);
    }
}
