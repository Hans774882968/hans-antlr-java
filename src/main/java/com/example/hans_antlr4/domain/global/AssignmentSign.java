package com.example.hans_antlr4.domain.global;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AssignmentSign {
    ASSIGN("="), POW("**="), MUL("*="), DIV("/="), MOD("%="), ADD("+="), MINUS("-="), SHL("<<="), SHR(
            ">>="), UNSIGNED_SHR(">>>="), AND("&="), XOR("^="), OR("|=");

    private final String sign;

    public static AssignmentSign fromString(String sign) {
        return Arrays.stream(values())
                .filter(assignmentSign -> assignmentSign.sign.equals(sign))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Assignment Sign " + sign + " not implemented"));
    }

    public static boolean isShiftSign(AssignmentSign assignmentSign) {
        return assignmentSign == SHL || assignmentSign == SHR || assignmentSign == UNSIGNED_SHR;
    }

    public boolean isShiftSign() {
        return isShiftSign(this);
    }
}
