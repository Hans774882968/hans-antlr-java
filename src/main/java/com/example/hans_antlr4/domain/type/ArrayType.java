package com.example.hans_antlr4.domain.type;

import lombok.Getter;

import java.util.Objects;

import org.objectweb.asm.Opcodes;

@Getter
public class ArrayType implements Type {
    private Type elementType;
    private int dimension;
    private String descriptor;
    public static ArrayType OBJECT_ARR = new ArrayType(BuiltInType.OBJECT, 1);

    public ArrayType(Type elementType, int dimension) {
        this.elementType = elementType;
        this.dimension = dimension;
        if (elementType instanceof ArrayType || dimension <= 0) {
            throw new RuntimeException("Invalid array type");
        }
        setDescriptor(dimension, elementType.getDescriptor());
    }

    private void setDescriptor(int dimension, String elementDescriptor) {
        this.descriptor = "[".repeat(dimension) + elementDescriptor;
    }

    public static Type getDimensionReducedType(ArrayType array, int dimension) {
        if (dimension > array.getDimension()) {
            throw new RuntimeException("dimension " + dimension + " exceed the dimension of array " + array.getName());
        }
        if (dimension == array.getDimension()) {
            return array.elementType;
        }
        return new ArrayType(array.elementType, array.getDimension() - dimension);
    }

    @Override
    public Class<?> getTypeClass() {
        try {
            return Class.forName(getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public String getName() {
        return descriptor.replaceAll("/", ".");
    }

    @Override
    public String getInternalName() {
        return descriptor.replaceAll("/", ".");
    }

    @Override
    public Double getPriority() {
        return Double.NaN;
    }

    @Override
    public boolean isNumericTypes() {
        return false;
    }

    @Override
    public Type getWrapperClassOrThis() {
        return this;
    }

    @Override
    public int getToHigherPriorityNumericTypeOpcode(Type targetType) {
        throw new RuntimeException("To higher priority numeric type instruction not supported for array");
    }

    @Override
    public int getToHigherPriorityNumericTypeOpcode(Type targetType, boolean silent) {
        if (silent) {
            return Opcodes.NOP;
        }
        throw new RuntimeException("To higher priority numeric type instruction not supported for array");
    }

    @Override
    public int getToOtherNumericTypeOpcode(Type targetType) {
        throw new RuntimeException("To other numeric type instruction not supported for array");
    }

    @Override
    public int slotUsage() {
        return 1;
    }

    @Override
    public int getLoadVariableOpcode() {
        return Opcodes.ALOAD;
    }

    @Override
    public int getStoreVariableOpcode() {
        return Opcodes.ASTORE;
    }

    @Override
    public int getReturnOpcode() {
        return Opcodes.ARETURN;
    }

    @Override
    public int getDupOpcode() {
        return Opcodes.DUP;
    }

    @Override
    public int getToDoubleOpcode() {
        throw new RuntimeException("To double instruction not supported for array");
    }

    @Override
    public int getDoubleToThisTypeOpcode() {
        throw new RuntimeException("Double to this type instruction not supported for array");
    }

    @Override
    public int getToIntOpcode() {
        throw new RuntimeException("To int instruction not supported for array");
    }

    @Override
    public int getUnaryNegativeOpcode() {
        throw new RuntimeException("Unary negative operation not supported for array");
    }

    @Override
    public int getMultiplyOpcode() {
        throw new RuntimeException("Multiplication operation not supported for array");
    }

    @Override
    public int getDivideOpcode() {
        throw new RuntimeException("Division operation not supported for array");
    }

    @Override
    public int getModOpcode() {
        throw new RuntimeException("Mod operation not supported for array");
    }

    @Override
    public int getAddOpcode() {
        throw new RuntimeException("Addition operation not supported for array");
    }

    @Override
    public int getSubtractOpcode() {
        throw new RuntimeException("Subtraction operation not supported for array");
    }

    @Override
    public int getShlOpcode() {
        throw new RuntimeException("Shl operation not supported for array");
    }

    @Override
    public int getShrOpcode() {
        throw new RuntimeException("Shr operation not supported for array");
    }

    @Override
    public int getUnsignedShrOpcode() {
        throw new RuntimeException("Unsigned shr operation not supported for array");
    }

    @Override
    public int getAndOpcode() {
        throw new RuntimeException("And operation not supported for array");
    }

    @Override
    public int getXorOpcode() {
        throw new RuntimeException("Xor operation not supported for array");
    }

    @Override
    public int getOrOpcode() {
        throw new RuntimeException("Or operation not supported for array");
    }

    @Override
    public int getLoadArrayItemOpcode() {
        return Opcodes.AALOAD;
    }

    @Override
    public int getStoreArrayItemOpcode() {
        return Opcodes.AASTORE;
    }

    @Override
    public int getDupX2Opcode() {
        return Opcodes.DUP_X2;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ArrayType)) {
            return false;
        }
        ArrayType arrayType = (ArrayType) o;
        return Objects.equals(elementType, arrayType.elementType)
                && dimension == arrayType.dimension
                && Objects.equals(descriptor, arrayType.descriptor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elementType, dimension, descriptor);
    }
}
