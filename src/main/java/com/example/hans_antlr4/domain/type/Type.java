package com.example.hans_antlr4.domain.type;

public interface Type {
    String getName();

    Class<?> getTypeClass();

    String getDescriptor();

    String getInternalName();

    Double getPriority();

    boolean isNumericTypes();

    int getToHigherPriorityNumericTypeOpcode(Type targetType);

    int getToOtherNumericTypeOpcode(Type targetType);

    int slotUsage();

    int getLoadVariableOpcode();

    int getStoreVariableOpcode();

    int getReturnOpcode();

    int getToDoubleOpcode();

    int getDoubleToThisTypeOpcode();

    int getToIntOpcode();

    int getUnaryNegativeOpcode();

    int getMultiplyOpcode();

    int getDivideOpcode();

    int getModOpcode();

    int getAddOpcode();

    int getSubtractOpcode();

    int getShlOpcode();

    int getShrOpcode();

    int getUnsignedShrOpcode();

    int getAndOpcode();

    int getXorOpcode();

    int getOrOpcode();
}
