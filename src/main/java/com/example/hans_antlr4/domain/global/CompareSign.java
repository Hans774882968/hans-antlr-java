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
}
