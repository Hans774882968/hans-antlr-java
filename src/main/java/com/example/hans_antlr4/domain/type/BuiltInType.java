package com.example.hans_antlr4.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BuiltInType implements Type {
    BOOLEAN("bool", boolean.class, "Z", TypeSpecificOpcodes.INT), INT("int", int.class, "I",
            TypeSpecificOpcodes.INT), CHAR("char", char.class, "C", TypeSpecificOpcodes.INT), BYTE("byte",
                    byte.class, "B",
                    TypeSpecificOpcodes.INT), SHORT("short", short.class, "S", TypeSpecificOpcodes.INT), LONG("long",
                            long.class, "J", TypeSpecificOpcodes.LONG), FLOAT("float",
                                    float.class, "F", TypeSpecificOpcodes.FLOAT), DOUBLE("double", double.class, "D",
                                            TypeSpecificOpcodes.DOUBLE), STRING("string", String.class,
                                                    "Ljava/lang/String;",
                                                    TypeSpecificOpcodes.OBJECT), BOOLEAN_ARR("bool[]", boolean[].class,
                                                            "[B", TypeSpecificOpcodes.OBJECT), INT_ARR("int[]",
                                                                    int[].class, "[I",
                                                                    TypeSpecificOpcodes.OBJECT), CHAR_ARR("char[]",
                                                                            char[].class, "[C",
                                                                            TypeSpecificOpcodes.OBJECT), BYTE_ARR(
                                                                                    "byte[]",
                                                                                    byte[].class, "[B",
                                                                                    TypeSpecificOpcodes.OBJECT), SHORT_ARR(
                                                                                            "short[]", short[].class,
                                                                                            "[S",
                                                                                            TypeSpecificOpcodes.OBJECT), LONG_ARR(
                                                                                                    "long[]",
                                                                                                    long[].class, "[J",
                                                                                                    TypeSpecificOpcodes.OBJECT), FLOAT_ARR(
                                                                                                            "float[]",
                                                                                                            float[].class,
                                                                                                            "[F",
                                                                                                            TypeSpecificOpcodes.OBJECT), DOUBLE_ARR(
                                                                                                                    "double[]",
                                                                                                                    double[].class,
                                                                                                                    "[D",
                                                                                                                    TypeSpecificOpcodes.OBJECT), STRING_ARR(
                                                                                                                            "string[]",
                                                                                                                            String[].class,
                                                                                                                            "[Ljava/lang/String;",
                                                                                                                            TypeSpecificOpcodes.OBJECT), NONE(
                                                                                                                                    "",
                                                                                                                                    null,
                                                                                                                                    "",
                                                                                                                                    TypeSpecificOpcodes.OBJECT), VOID(
                                                                                                                                            "void",
                                                                                                                                            void.class,
                                                                                                                                            "V",
                                                                                                                                            TypeSpecificOpcodes.OBJECT);

    private String name;
    private Class<?> typeClass;
    private String descriptor;
    private final TypeSpecificOpcodes opcodes;

    @Override
    public String getInternalName() {
        return getDescriptor();
    }

    @Override
    public int getLoadVariableOpcode() {
        return opcodes.getLoad();
    }

    @Override
    public int getStoreVariableOpcode() {
        return opcodes.getStore();
    }

    @Override
    public int getReturnOpcode() {
        return opcodes.getRet();
    }

    @Override
    public int getToDoubleOpcode() {
        return opcodes.getToDouble();
    }

    @Override
    public int getDoubleToThisTypeOpcode() {
        return opcodes.getDoubleToThisType();
    }

    @Override
    public int getUnaryNegativeOpcode() {
        return opcodes.getUnaryNegative();
    }

    @Override
    public int getMultiplyOpcode() {
        return opcodes.getMul();
    }

    @Override
    public int getDivideOpcode() {
        return opcodes.getDiv();
    }

    @Override
    public int getModOpcode() {
        return opcodes.getRem();
    }

    @Override
    public int getAddOpcode() {
        return opcodes.getAdd();
    }

    @Override
    public int getSubtractOpcode() {
        return opcodes.getSub();
    }

    @Override
    public int getShlOpcode() {
        return opcodes.getShl();
    }

    @Override
    public int getShrOpcode() {
        return opcodes.getShr();
    }

    @Override
    public int getUnsignedShrOpcode() {
        return opcodes.getUnsignedShr();
    }

    @Override
    public int getAndOpcode() {
        return opcodes.getAnd();
    }

    @Override
    public int getXorOpcode() {
        return opcodes.getXor();
    }

    @Override
    public int getOrOpcode() {
        return opcodes.getOr();
    }
}
