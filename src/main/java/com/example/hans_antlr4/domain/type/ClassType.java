package com.example.hans_antlr4.domain.type;

import java.util.Objects;

import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.utils.Const;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClassType implements Type {
    private String name;

    @Override
    public Class<?> getTypeClass() {
        try {
            return Class.forName(name);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public String getDescriptor() {
        return "L" + getInternalName() + ";";
    }

    @Override
    public String getInternalName() {
        return name.replace(".", "/");
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
        return Const.INVALID_OPCODE;
    }

    @Override
    public int getToHigherPriorityNumericTypeOpcode(Type targetType, boolean silent) {
        return silent ? Opcodes.NOP : Const.INVALID_OPCODE;
    }

    @Override
    public int getToOtherNumericTypeOpcode(Type targetType) {
        return Const.INVALID_OPCODE;
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
        throw new RuntimeException("To double instruction not supported for custom objects");
    }

    @Override
    public int getDoubleToThisTypeOpcode() {
        throw new RuntimeException("Double to this type instruction not supported for custom objects");
    }

    @Override
    public int getToIntOpcode() {
        throw new RuntimeException("To int instruction not supported for custom objects");
    }

    @Override
    public int getUnaryNegativeOpcode() {
        throw new RuntimeException("Unary negative operation not (yet ;) ) supported for custom objects");
    }

    @Override
    public int getMultiplyOpcode() {
        throw new RuntimeException("Multiplication operation not (yet ;) ) supported for custom objects");
    }

    @Override
    public int getDivideOpcode() {
        throw new RuntimeException("Division operation not (yet ;) ) supported for custom objects");
    }

    @Override
    public int getModOpcode() {
        throw new RuntimeException("Mod operation not (yet ;) ) supported for custom objects");
    }

    @Override
    public int getAddOpcode() {
        throw new RuntimeException("Addition operation not (yet ;) ) supported for custom objects");
    }

    @Override
    public int getSubtractOpcode() {
        throw new RuntimeException("Subtraction operation not (yet ;) ) supported for custom objects");
    }

    @Override
    public int getShlOpcode() {
        throw new RuntimeException("Shl operation not (yet ;) ) supported for custom objects");
    }

    @Override
    public int getShrOpcode() {
        throw new RuntimeException("Shr operation not (yet ;) ) supported for custom objects");
    }

    @Override
    public int getUnsignedShrOpcode() {
        throw new RuntimeException("Unsigned shr operation not (yet ;) ) supported for custom objects");
    }

    @Override
    public int getAndOpcode() {
        throw new RuntimeException("And operation not (yet ;) ) supported for custom objects");
    }

    @Override
    public int getXorOpcode() {
        throw new RuntimeException("Xor operation not (yet ;) ) supported for custom objects");
    }

    @Override
    public int getOrOpcode() {
        throw new RuntimeException("Or operation not (yet ;) ) supported for custom objects");
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ClassType)) {
            return false;
        }
        ClassType classType = (ClassType) o;
        return Objects.equals(name, classType.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
