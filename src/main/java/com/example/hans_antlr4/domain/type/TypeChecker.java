package com.example.hans_antlr4.domain.type;

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

    public static boolean assignmentLhsTypeAndRhsAreCompatible(Type lhsType, Type rhsType) {
        if (isNumericTypes(lhsType) && isNumericTypes(rhsType)) {
            return true;
        }
        return lhsType == rhsType;
    }

    public static boolean conditionalLhsTypeAndRhsAreCompatible(Type lhsType, Type rhsType) {
        if (isNumericTypes(lhsType) && isNumericTypes(rhsType)) {
            return true;
        }
        return lhsType == rhsType;
    }
}
