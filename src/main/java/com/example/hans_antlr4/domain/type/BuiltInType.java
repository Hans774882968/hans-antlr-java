package com.example.hans_antlr4.domain.type;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.utils.Const;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BuiltInType implements Type {
    BOOLEAN("boolean", boolean.class, "Z", TypeSpecificOpcodes.INT, Double.NaN), INT("int", int.class, "I",
            TypeSpecificOpcodes.INT, 30d), CHAR("char", char.class, "C", TypeSpecificOpcodes.INT, Double.NaN), BYTE(
                    "byte", byte.class, "B", TypeSpecificOpcodes.INT,
                    10d), SHORT("short", short.class, "S", TypeSpecificOpcodes.INT, 20d), LONG("long", long.class, "J",
                            TypeSpecificOpcodes.LONG,
                            40d), FLOAT("float", float.class, "F", TypeSpecificOpcodes.FLOAT, 50d), DOUBLE("double",
                                    double.class, "D", TypeSpecificOpcodes.DOUBLE, 60d), STRING("string", String.class,
                                            "Ljava/lang/String;", TypeSpecificOpcodes.OBJECT, 70d), BOOLEAN_ARR(
                                                    "boolean[]", boolean[].class, "[B", TypeSpecificOpcodes.OBJECT,
                                                    Double.NaN), INT_ARR("int[]", int[].class, "[I",
                                                            TypeSpecificOpcodes.OBJECT, Double.NaN), CHAR_ARR("char[]",
                                                                    char[].class, "[C", TypeSpecificOpcodes.OBJECT,
                                                                    Double.NaN), BYTE_ARR("byte[]", byte[].class, "[B",
                                                                            TypeSpecificOpcodes.OBJECT,
                                                                            Double.NaN), SHORT_ARR("short[]",
                                                                                    short[].class, "[S",
                                                                                    TypeSpecificOpcodes.OBJECT,
                                                                                    Double.NaN), LONG_ARR("long[]",
                                                                                            long[].class, "[J",
                                                                                            TypeSpecificOpcodes.OBJECT,
                                                                                            Double.NaN), FLOAT_ARR(
                                                                                                    "float[]",
                                                                                                    float[].class, "[F",
                                                                                                    TypeSpecificOpcodes.OBJECT,
                                                                                                    Double.NaN), DOUBLE_ARR(
                                                                                                            "double[]",
                                                                                                            double[].class,
                                                                                                            "[D",
                                                                                                            TypeSpecificOpcodes.OBJECT,
                                                                                                            Double.NaN), STRING_ARR(
                                                                                                                    "string[]",
                                                                                                                    String[].class,
                                                                                                                    "[Ljava/lang/String;",
                                                                                                                    TypeSpecificOpcodes.OBJECT,
                                                                                                                    Double.NaN), NONE(
                                                                                                                            "",
                                                                                                                            null,
                                                                                                                            "",
                                                                                                                            TypeSpecificOpcodes.OBJECT,
                                                                                                                            Double.NaN), VOID(
                                                                                                                                    "void",
                                                                                                                                    void.class,
                                                                                                                                    "V",
                                                                                                                                    TypeSpecificOpcodes.VOID,
                                                                                                                                    Double.NaN), OBJECT_ARR(
                                                                                                                                            "java.lang.Object[]",
                                                                                                                                            Object[].class,
                                                                                                                                            "[Ljava/lang/Object;",
                                                                                                                                            TypeSpecificOpcodes.OBJECT,
                                                                                                                                            Double.NaN);

    private String name;
    private Class<?> typeClass;
    private String descriptor;
    private final TypeSpecificOpcodes opcodes;
    private Double priority;
    private static final HashMap<Type, HashMap<Type, Integer>> toHigherPriorityNumericTypeConvertMap = new HashMap<Type, HashMap<Type, Integer>>() {
        {
            put(INT, new HashMap<Type, Integer>() {
                {
                    put(INT, Opcodes.NOP);
                    put(LONG, Opcodes.I2L);
                    put(FLOAT, Opcodes.I2F);
                    put(DOUBLE, Opcodes.I2D);
                }
            });
            put(LONG, new HashMap<Type, Integer>() {
                {
                    put(INT, Opcodes.NOP);
                    put(LONG, Opcodes.NOP);
                    put(FLOAT, Opcodes.L2F);
                    put(DOUBLE, Opcodes.L2D);
                }
            });
            put(FLOAT, new HashMap<Type, Integer>() {
                {
                    put(INT, Opcodes.NOP);
                    put(LONG, Opcodes.NOP);
                    put(FLOAT, Opcodes.NOP);
                    put(DOUBLE, Opcodes.F2D);
                }
            });
            put(DOUBLE, new HashMap<Type, Integer>() {
                {
                    put(INT, Opcodes.NOP);
                    put(LONG, Opcodes.NOP);
                    put(FLOAT, Opcodes.NOP);
                    put(DOUBLE, Opcodes.NOP);
                }
            });
        }
    };

    private static final HashMap<Type, HashMap<Type, Integer>> toOtherNumericTypeConvertMap = new HashMap<Type, HashMap<Type, Integer>>() {
        {
            put(INT, new HashMap<Type, Integer>() {
                {
                    put(INT, Opcodes.NOP);
                    put(LONG, Opcodes.I2L);
                    put(FLOAT, Opcodes.I2F);
                    put(DOUBLE, Opcodes.I2D);
                }
            });
            put(LONG, new HashMap<Type, Integer>() {
                {
                    put(INT, Opcodes.L2I);
                    put(LONG, Opcodes.NOP);
                    put(FLOAT, Opcodes.L2F);
                    put(DOUBLE, Opcodes.L2D);
                }
            });
            put(FLOAT, new HashMap<Type, Integer>() {
                {
                    put(INT, Opcodes.F2I);
                    put(LONG, Opcodes.F2L);
                    put(FLOAT, Opcodes.NOP);
                    put(DOUBLE, Opcodes.F2D);
                }
            });
            put(DOUBLE, new HashMap<Type, Integer>() {
                {
                    put(INT, Opcodes.D2I);
                    put(LONG, Opcodes.D2L);
                    put(FLOAT, Opcodes.D2F);
                    put(DOUBLE, Opcodes.NOP);
                }
            });
        }
    };

    @Override
    public String getInternalName() {
        return opcodes == TypeSpecificOpcodes.OBJECT ? typeClass.getName().replace(".", "/") : getDescriptor();
    }

    @Override
    public boolean isNumericTypes() {
        return TypeChecker.isNumericTypes(this);
    }

    @Override
    public Type getWrapperClassOrThis() {
        if (this == BuiltInType.BYTE) {
            return new ClassType("java.lang.Byte");
        }
        if (this == BuiltInType.SHORT) {
            return new ClassType("java.lang.Short");
        }
        if (this == BuiltInType.INT) {
            return new ClassType("java.lang.Integer");
        }
        if (this == BuiltInType.LONG) {
            return new ClassType("java.lang.Long");
        }
        if (this == BuiltInType.FLOAT) {
            return new ClassType("java.lang.Float");
        }
        if (this == BuiltInType.DOUBLE) {
            return new ClassType("java.lang.Double");
        }
        if (this == BuiltInType.BOOLEAN) {
            return new ClassType("java.lang.Boolean");
        }
        if (this == BuiltInType.CHAR) {
            return new ClassType("java.lang.Character");
        }
        return this;
    }

    @Override
    public int getToHigherPriorityNumericTypeOpcode(Type targetType) {
        return getToHigherPriorityNumericTypeOpcode(targetType, false);
    }

    @Override
    public int getToHigherPriorityNumericTypeOpcode(Type targetType, boolean silent) {
        if (!isNumericTypes() || !TypeChecker.isNumericTypes(targetType)) {
            return silent ? Opcodes.NOP : Const.INVALID_OPCODE;
        }
        if (!toHigherPriorityNumericTypeConvertMap.containsKey(this)) {
            return silent ? Opcodes.NOP : Const.INVALID_OPCODE;
        }
        HashMap<Type, Integer> mp = toHigherPriorityNumericTypeConvertMap.get(this);
        return mp.getOrDefault(targetType, silent ? Opcodes.NOP : Const.INVALID_OPCODE);
    }

    @Override
    public int getToOtherNumericTypeOpcode(Type targetType) {
        if (!isNumericTypes() || !TypeChecker.isNumericTypes(targetType)) {
            return Const.INVALID_OPCODE;
        }
        if (!toOtherNumericTypeConvertMap.containsKey(this)) {
            return Const.INVALID_OPCODE;
        }
        HashMap<Type, Integer> mp = toOtherNumericTypeConvertMap.get(this);
        return mp.getOrDefault(targetType, Const.INVALID_OPCODE);
    }

    @Override
    public int slotUsage() {
        if (this == BuiltInType.LONG || this == BuiltInType.DOUBLE) {
            return 2;
        }
        return 1;
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
    public int getDupOpcode() {
        return opcodes.getDup();
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
    public int getToIntOpcode() {
        return opcodes.getToInt();
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

    public static Optional<BuiltInType> getBuiltInType(String typeName) {
        return Arrays.stream(BuiltInType.values())
                .filter(type -> type.getName().equals(typeName))
                .findFirst();
    }
}
