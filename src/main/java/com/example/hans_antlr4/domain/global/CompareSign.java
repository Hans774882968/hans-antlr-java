package com.example.hans_antlr4.domain.global;

import org.objectweb.asm.Opcodes;
import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CompareSign implements Opcodes {
    EQUAL("==", IFEQ), NOT_EQUAL("!=", IFNE), LESS("<", IFLT), GREATER(">", IFGT), LESS_OR_EQUAL("<=",
            IFLE), GREATER_OR_EQUAL(">=", IFGE);

    private final String sign;
    private final int opcode;

    public static CompareSign fromString(String sign) {
        return Arrays.stream(values())
                .filter(cmpSign -> cmpSign.sign.equals(sign))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Sign not implemented"));
    }

    public CompareSign getOppositeCompareSign() {
        return CompareSign.getOppositeCompareSign(this);
    }

    public static CompareSign getOppositeCompareSign(CompareSign compareSign) {
        if (compareSign == CompareSign.EQUAL)
            return CompareSign.NOT_EQUAL;
        if (compareSign == CompareSign.NOT_EQUAL)
            return CompareSign.EQUAL;
        if (compareSign == CompareSign.LESS)
            return CompareSign.GREATER_OR_EQUAL;
        if (compareSign == CompareSign.GREATER)
            return CompareSign.LESS_OR_EQUAL;
        if (compareSign == CompareSign.LESS_OR_EQUAL)
            return CompareSign.GREATER;
        if (compareSign == CompareSign.GREATER_OR_EQUAL)
            return CompareSign.LESS;
        throw new RuntimeException("Sign has no opposite compare sign");
    }
}
