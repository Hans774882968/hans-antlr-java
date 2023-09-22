package com.example.hans_antlr4.domain.type;

public interface Type {
    String getName();

    Class<?> getTypeClass();

    String getDescriptor();

    String getInternalName();

    Double getPriority();

    Type getWrapperClassOrThis();

    boolean isNumericTypes();

    int getToHigherPriorityNumericTypeOpcode(Type targetType);

    int getToHigherPriorityNumericTypeOpcode(Type targetType, boolean silent);

    int getToOtherNumericTypeOpcode(Type targetType);

    int slotUsage();

    int getLoadVariableOpcode();

    int getStoreVariableOpcode();

    int getReturnOpcode();

    int getDupOpcode();

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

    int getLoadArrayItemOpcode();

    int getStoreArrayItemOpcode();

    int getDupX2Opcode();

    int getPrimitiveTypeOperand();
}
