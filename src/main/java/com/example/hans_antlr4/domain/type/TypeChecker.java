package com.example.hans_antlr4.domain.type;

import java.util.List;

import com.example.hans_antlr4.domain.expression.ArithmeticExpression;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.global.ArithmeticSign;
import com.example.hans_antlr4.domain.global.AssignmentSign;
import com.example.hans_antlr4.exception.type.IllegalArrayIndexTypeException;

public class TypeChecker {
    public static boolean isDecimalTypes(Type type) {
        return type == BuiltInType.FLOAT || type == BuiltInType.DOUBLE;
    }

    public static boolean isIntegerTypes(Type type) {
        return type == BuiltInType.BYTE
                || type == BuiltInType.SHORT
                || type == BuiltInType.INT
                || type == BuiltInType.LONG;
    }

    public static boolean isNumericTypes(Type type) {
        return isDecimalTypes(type) || isIntegerTypes(type);
    }

    public static boolean arithmeticLhsTypeAndRhsAreCompatible(
            ArithmeticExpression arithmeticExpression) {
        ArithmeticSign arithmeticSign = arithmeticExpression.getSign();
        Type lhsType = arithmeticExpression.getLeftExpression().getType();
        Type rhsType = arithmeticExpression.getRightExpression().getType();
        if (arithmeticSign == ArithmeticSign.ADD) {
            if (lhsType == BuiltInType.STRING || rhsType == BuiltInType.STRING) {
                return true;
            }
            if (isNumericTypes(lhsType)) {
                return isNumericTypes(rhsType);
            }
            if (isNumericTypes(rhsType)) {
                return isNumericTypes(lhsType);
            }
            return lhsType.equals(rhsType);
        }
        if (arithmeticSign.isBitwiseSign()) {
            return isIntegerTypes(lhsType) && isIntegerTypes(rhsType);
        }
        return isNumericTypes(lhsType) && isNumericTypes(rhsType);
    }

    public static boolean assignmentLhsTypeAndRhsAreCompatible(
            AssignmentSign assignmentSign,
            Type lhsType,
            Type rhsType) {
        if (assignmentSign == AssignmentSign.ADD) {
            if (isNumericTypes(lhsType)) {
                return isNumericTypes(rhsType);
            }
            if (lhsType == BuiltInType.STRING) {
                return true;
            }
            return lhsType.equals(rhsType);
        }
        if (assignmentSign == AssignmentSign.ASSIGN) {
            if (isNumericTypes(lhsType)) {
                return isNumericTypes(rhsType) && lhsType.getPriority().compareTo(rhsType.getPriority()) >= 0;
            }
            return lhsType.equals(rhsType);
        }
        if (assignmentSign.isBitwiseSign()) {
            return isIntegerTypes(lhsType) && isIntegerTypes(rhsType);
        }
        return isNumericTypes(lhsType) && isNumericTypes(rhsType);
    }

    public static boolean conditionalLhsTypeAndRhsAreCompatible(Type lhsType, Type rhsType) {
        if (isNumericTypes(lhsType) && isNumericTypes(rhsType)) {
            return true;
        }
        return lhsType.equals(rhsType);
    }

    public static boolean isLegalShiftType(Type leftType, Type rightType) {
        return isIntegerTypes(leftType) && isIntegerTypes(rightType);
    }

    public static void arrayDimensionTypeCheck(List<Expression> dimensions, int sourceLine) {
        for (Expression dimension : dimensions) {
            if (!isIntegerTypes(dimension.getType())) {
                throw new IllegalArrayIndexTypeException(dimension, sourceLine);
            }
        }
    }
}
