package com.example.hans_antlr4.parsing.biz_visitor;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.tree.TerminalNode;

import com.example.hans_antlr4.domain.expression.Addition;
import com.example.hans_antlr4.domain.expression.Additive;
import com.example.hans_antlr4.domain.expression.And;
import com.example.hans_antlr4.domain.expression.ArrayAccess;
import com.example.hans_antlr4.domain.expression.ArrayDeclaration;
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
import com.example.hans_antlr4.domain.type.ArrayType;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.ClassType;
import com.example.hans_antlr4.domain.type.Type;
import com.example.hans_antlr4.domain.type.TypeChecker;
import com.example.hans_antlr4.exception.ArithmeticExprLhsAndRhsTypeIncompatibleException;
import com.example.hans_antlr4.exception.ConditionalExprLhsAndRhsTypeIncompatibleException;
import com.example.hans_antlr4.exception.IllegalShiftTypeException;
import com.example.hans_antlr4.exception.assignment.IllegalAssignmentLhsType;
import com.example.hans_antlr4.parsing.HansAntlrParserBaseVisitor;
import com.example.hans_antlr4.parsing.HansAntlrParser;
import com.example.hans_antlr4.parsing.HansAntlrParser.ExpressionContext;
import com.example.hans_antlr4.utils.HantNumber;
import com.example.hans_antlr4.utils.TypeResolver;

public class ExpressionVisitor extends HansAntlrParserBaseVisitor<Expression> {
    private Scope scope;
    private CallExpressionVisitor callExpressionVisitor;

    public ExpressionVisitor(Scope scope) {
        this.scope = scope;
        this.callExpressionVisitor = new CallExpressionVisitor(scope, this);
    }

    @Override
    public ArrayDeclaration visitArrayDeclaration(HansAntlrParser.ArrayDeclarationContext ctx) {
        Type elementType = null;
        if (ctx.primitiveTypeName() != null) {
            Optional<BuiltInType> foundType = BuiltInType.getBuiltInType(ctx.primitiveTypeName().getText());
            if (foundType.isPresent()) {
                elementType = foundType.get();
            }
        } else if (ctx.qualifiedName() != null) {
            elementType = ClassType.getTypeByQualifiedName(ctx.qualifiedName().getText());
        }
        if (elementType == null) {
            int sourceLine = ctx.getStart().getLine();
            throw new RuntimeException("Can not get Array element type at line " + sourceLine);
        }
        List<Expression> dimensions = ctx.expression().stream().map(exp -> {
            return exp.accept(this);
        }).collect(Collectors.toList());
        return new ArrayDeclaration(elementType, dimensions);
    }

    @Override
    public ArrayAccess visitArrayAccess(HansAntlrParser.ArrayAccessContext ctx) {
        Expression array = ctx.array.accept(this);
        List<Expression> dimensions = new ArrayList<>();
        for (int i = 1; i < ctx.expression().size(); i++) {
            Expression dimension = ctx.expression(i).accept(this);
            dimensions.add(dimension);
        }
        return new ArrayAccess(array, dimensions);
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
        return findFieldStartIndex;
    }

    private String getClassQualifiedName(String[] identifiers, int classNameEndIndex) {
        String classQualifiedName = identifiers[0];
        for (int i = 1; i < classNameEndIndex; i++) {
            classQualifiedName += "." + identifiers[i];
        }
        return classQualifiedName;
    }

    private Class<?> getInitialOwnerClass(String[] identifiers, int findFieldStartIndex) {
        if (findFieldStartIndex == -1) {
            return scope.getLocalVariable(identifiers[0]).getType().getTypeClass();
        }
        String classQualifiedName = getClassQualifiedName(identifiers, findFieldStartIndex);
        try {
            Class<?> currentOwnerClass = Class.forName(classQualifiedName);
            return currentOwnerClass;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
            return null;
        }
    }

    @Override
    public ClassFieldReference visitClazzFieldReference(HansAntlrParser.ClazzFieldReferenceContext ctx) {
        // TODO: 为了处理类似 java.lang.Integer.valueOf 的情况，目前的写法会导致 data.split("\n").length 不支持
        String classFieldString = ctx.getText();
        String[] identifiers = classFieldString.split("\\.");

        int findFieldStartIndex = getFindFieldStartIndex(identifiers, classFieldString);
        Class<?> currentOwnerClass = getInitialOwnerClass(identifiers, findFieldStartIndex);

        List<FieldReferenceRecord> fieldReferenceRecords = new ArrayList<>();

        for (int i = findFieldStartIndex == -1 ? 1 : findFieldStartIndex; i < identifiers.length; i++) {
            final String identifier = identifiers[i];
            final Type currentOwnerType = TypeResolver.getFromJavaLangClass(currentOwnerClass);
            if (currentOwnerType instanceof ArrayType && identifier.equals("length")) {
                fieldReferenceRecords.add(new FieldReferenceRecord(
                        false, currentOwnerType, identifier, BuiltInType.INT));
                continue;
            }

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

        if (findFieldStartIndex == -1) {
            LocalVariable localVariable = scope.getLocalVariable(identifiers[0]);
            return new ClassFieldReference(localVariable, fieldReferenceRecords);
        }
        String classQualifiedName = getClassQualifiedName(identifiers, findFieldStartIndex);
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
        Expression leftHandSide = ctx.leftHandSide.accept(this);
        final String op = ctx.AssignmentOperator.getText();
        AssignmentSign assignmentSign = AssignmentSign.fromString(op);
        Expression expression = ctx.rightHandSide.accept(this);
        int sourceLine = ctx.AssignmentOperator.getLine();
        if (leftHandSide instanceof VarReference) {
            String varName = ((VarReference) leftHandSide).getVarName();
            LocalVariable localVariable = scope.getLocalVariable(varName);
            return new AssignmentExpression(localVariable, assignmentSign, expression, sourceLine);
        }
        if (leftHandSide instanceof ClassFieldReference) {
            ClassFieldReference classFieldReference = (ClassFieldReference) leftHandSide;
            return new AssignmentExpression(classFieldReference, assignmentSign, expression, sourceLine);
        }
        if (leftHandSide instanceof ArrayAccess) {
            ArrayAccess arrayAccess = (ArrayAccess) leftHandSide;
            return new AssignmentExpression(arrayAccess, assignmentSign, expression, sourceLine);
        }
        throw new IllegalAssignmentLhsType(leftHandSide, sourceLine);
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
