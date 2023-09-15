package com.example.hans_antlr4.domain.type;

import java.util.ArrayList;
import java.util.List;

import com.example.hans_antlr4.domain.expression.EmptyExpression;
import com.example.hans_antlr4.domain.expression.Expression;

import lombok.Getter;

import java.util.Objects;

import org.objectweb.asm.Opcodes;

@Getter
public class ArrayType implements Type {
    private Type elementType;
    private List<Expression> dimensions;
    private String descriptor;

    public ArrayType(Type elementType, int dimension) {
        this.elementType = elementType;
        List<Expression> tmpDimensions = new ArrayList<>();
        for (int i = 0; i < dimension; i++) {
            tmpDimensions.add(new EmptyExpression(BuiltInType.INT));
        }
        this.dimensions = tmpDimensions;
        if (elementType instanceof ArrayType) {
            throw new RuntimeException("Invalid array type");
        }
        setDescriptor(dimensions.size(), elementType.getDescriptor());
    }

    public ArrayType(Type elementType, List<Expression> dimensions) {
        this.elementType = elementType;
        this.dimensions = dimensions;
        if (elementType instanceof ArrayType || dimensions == null || dimensions.isEmpty()) {
            throw new RuntimeException("Invalid array type");
        }
        setDescriptor(dimensions.size(), elementType.getDescriptor());
    }

    private void setDescriptor(int dimension, String elementDescriptor) {
        this.descriptor = "[".repeat(dimension) + elementDescriptor;
    }

    public static Type getDimensionReducedType(ArrayType array, int dimension) {
        if (dimension > array.getDimensions().size()) {
            throw new RuntimeException("dimension " + dimension + " exceed the dimension of array " + array.getName());
        }
        List<Expression> resultDimension = array.getDimensions().subList(dimension, array.getDimensions().size());
        if (resultDimension.isEmpty()) {
            return array.elementType;
        }
        return new ArrayType(array.elementType, resultDimension);
    }

    @Override
    public Class<?> getTypeClass() {
        try {
            return Class.forName(descriptor);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public String getName() {
        return descriptor;
    }

    @Override
    public String getInternalName() {
        return descriptor;
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

    // NOTICE: 和其他类型不一样，dimensions的表达式不需要相等，只需要维度相等
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ArrayType)) {
            return false;
        }
        ArrayType arrayType = (ArrayType) o;
        return Objects.equals(elementType, arrayType.elementType)
                && Objects.equals(dimensions.size(), arrayType.dimensions.size())
                && Objects.equals(descriptor, arrayType.descriptor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elementType, dimensions.size(), descriptor);
    }
}
