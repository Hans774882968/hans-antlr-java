package com.example.hans_antlr4.domain.type;

import com.example.hans_antlr4.domain.global.AssignmentSign;

public class TypeChecker {
    public static boolean isDecimalTypes(Type type) {
        return type == BuiltInType.FLOAT || type == BuiltInType.DOUBLE;
    }

    public static boolean isIntegerTypes(Type type) {
        return type == BuiltInType.INT || type == BuiltInType.LONG;
    }

    public static boolean isNumericTypes(Type type) {
        return isDecimalTypes(type) || isIntegerTypes(type);
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
            return lhsType == rhsType;
        }
        if (assignmentSign == AssignmentSign.ASSIGN) {
            return (isNumericTypes(lhsType) || lhsType == BuiltInType.STRING) && lhsType == rhsType;
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
        return lhsType == rhsType;
    }

    public static boolean isLegalShiftType(Type leftType, Type rightType) {
        return isIntegerTypes(leftType) && isIntegerTypes(rightType);
    }
}
