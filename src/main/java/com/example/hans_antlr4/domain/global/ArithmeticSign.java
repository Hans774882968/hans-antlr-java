package com.example.hans_antlr4.domain.global;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ArithmeticSign {
    POW("**"), MUL("*"), DIV("/"), MOD("%"), ADD("+"), MINUS("-"), SHL("<<"), SHR(">>"), UNSIGNED_SHR(">>>"), AND(
            "&"), XOR("^"), OR("|");

    private final String sign;

    public static ArithmeticSign fromString(String sign) {
        return Arrays.stream(values())
                .filter(arithmetic -> arithmetic.sign.equals(sign))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Arithmetic Sign " + sign + " not implemented"));
    }

    public static boolean isShiftSign(ArithmeticSign arithmeticSign) {
        return arithmeticSign == SHL || arithmeticSign == SHR || arithmeticSign == UNSIGNED_SHR;
    }

    public boolean isShiftSign() {
        return isShiftSign(this);
    }

    public static boolean isNonShiftBitwiseSign(ArithmeticSign arithmeticSign) {
        return arithmeticSign == AND || arithmeticSign == XOR || arithmeticSign == OR;
    }

    public boolean isNonShiftBitwiseSign() {
        return isNonShiftBitwiseSign(this);
    }

    public static boolean isBitwiseSign(ArithmeticSign arithmeticSign) {
        return isShiftSign(arithmeticSign) || isNonShiftBitwiseSign(arithmeticSign);
    }

    public boolean isBitwiseSign() {
        return isBitwiseSign(this);
    }
}
