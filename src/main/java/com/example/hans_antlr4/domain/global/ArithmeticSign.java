package com.example.hans_antlr4.domain.global;

import java.util.Arrays;

import com.example.hans_antlr4.exception.value_infer.CanNotEvaluateValueForSignException;

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

    public String evaluateForNumericExpression(double leftVal, double rightVal, int sourceLine) {
        if (this == ArithmeticSign.POW) {
            return Double.toString(Math.pow(leftVal, rightVal));
        }
        if (this == ArithmeticSign.MUL) {
            return Double.toString(leftVal * rightVal);
        }
        if (this == ArithmeticSign.DIV) {
            return Double.toString(leftVal / rightVal);
        }
        if (this == ArithmeticSign.MOD) {
            return Double.toString(leftVal % rightVal);
        }
        if (this == ArithmeticSign.MINUS) {
            return Double.toString(leftVal - rightVal);
        }
        throw new CanNotEvaluateValueForSignException(this, sourceLine);
    }

    public String evaluateForNumericExpression(float leftVal, float rightVal, int sourceLine) {
        if (this == ArithmeticSign.POW) {
            return Float.toString((float) Math.pow(leftVal, rightVal));
        }
        if (this == ArithmeticSign.MUL) {
            return Float.toString(leftVal * rightVal);
        }
        if (this == ArithmeticSign.DIV) {
            return Float.toString(leftVal / rightVal);
        }
        if (this == ArithmeticSign.MOD) {
            return Float.toString(leftVal % rightVal);
        }
        if (this == ArithmeticSign.MINUS) {
            return Float.toString(leftVal - rightVal);
        }
        throw new CanNotEvaluateValueForSignException(this, sourceLine);
    }

    public String evaluateForNumericExpression(long leftVal, long rightVal, int sourceLine) {
        if (this == ArithmeticSign.POW) {
            return Long.toString((long) Math.pow(leftVal, rightVal));
        }
        if (this == ArithmeticSign.MUL) {
            return Long.toString(leftVal * rightVal);
        }
        if (this == ArithmeticSign.DIV) {
            return Long.toString(leftVal / rightVal);
        }
        if (this == ArithmeticSign.MOD) {
            return Long.toString(leftVal % rightVal);
        }
        if (this == ArithmeticSign.MINUS) {
            return Long.toString(leftVal - rightVal);
        }
        throw new CanNotEvaluateValueForSignException(this, sourceLine);
    }

    public String evaluateForNumericExpression(int leftVal, int rightVal, int sourceLine) {
        if (this == ArithmeticSign.POW) {
            return Integer.toString((int) Math.pow(leftVal, rightVal));
        }
        if (this == ArithmeticSign.MUL) {
            return Integer.toString(leftVal * rightVal);
        }
        if (this == ArithmeticSign.DIV) {
            return Integer.toString(leftVal / rightVal);
        }
        if (this == ArithmeticSign.MOD) {
            return Integer.toString(leftVal % rightVal);
        }
        if (this == ArithmeticSign.MINUS) {
            return Integer.toString(leftVal - rightVal);
        }
        throw new CanNotEvaluateValueForSignException(this, sourceLine);
    }

    public String evaluateForNumericExpression(byte leftVal, byte rightVal, int sourceLine) {
        if (this == ArithmeticSign.POW) {
            return Integer.toString((int) Math.pow(leftVal, rightVal));
        }
        if (this == ArithmeticSign.MUL) {
            return Integer.toString(leftVal * rightVal);
        }
        if (this == ArithmeticSign.DIV) {
            return Integer.toString(leftVal / rightVal);
        }
        if (this == ArithmeticSign.MOD) {
            return Integer.toString(leftVal % rightVal);
        }
        if (this == ArithmeticSign.MINUS) {
            return Integer.toString(leftVal - rightVal);
        }
        throw new CanNotEvaluateValueForSignException(this, sourceLine);
    }

    public String evaluateForAndXorOr(long leftVal, long rightVal, int sourceLine) {
        if (this == ArithmeticSign.AND) {
            return Long.toString(leftVal & rightVal);
        }
        if (this == ArithmeticSign.XOR) {
            return Long.toString(leftVal ^ rightVal);
        }
        if (this == ArithmeticSign.OR) {
            return Long.toString(leftVal | rightVal);
        }
        throw new CanNotEvaluateValueForSignException(this, sourceLine);
    }

    public String evaluateForAndXorOr(int leftVal, int rightVal, int sourceLine) {
        if (this == ArithmeticSign.AND) {
            return Integer.toString(leftVal & rightVal);
        }
        if (this == ArithmeticSign.XOR) {
            return Integer.toString(leftVal ^ rightVal);
        }
        if (this == ArithmeticSign.OR) {
            return Integer.toString(leftVal | rightVal);
        }
        throw new CanNotEvaluateValueForSignException(this, sourceLine);
    }

    public String evaluateForAndXorOr(byte leftVal, byte rightVal, int sourceLine) {
        if (this == ArithmeticSign.AND) {
            return Integer.toString(leftVal & rightVal);
        }
        if (this == ArithmeticSign.XOR) {
            return Integer.toString(leftVal ^ rightVal);
        }
        if (this == ArithmeticSign.OR) {
            return Integer.toString(leftVal | rightVal);
        }
        throw new CanNotEvaluateValueForSignException(this, sourceLine);
    }

    public String evaluateForShift(long leftVal, long rightVal, int sourceLine) {
        if (this == ArithmeticSign.SHL) {
            return Long.toString(leftVal << rightVal);
        }
        if (this == ArithmeticSign.SHR) {
            return Long.toString(leftVal >> rightVal);
        }
        if (this == ArithmeticSign.UNSIGNED_SHR) {
            return Long.toString(leftVal >>> rightVal);
        }
        throw new CanNotEvaluateValueForSignException(this, sourceLine);
    }

    public String evaluateForShift(int leftVal, long rightVal, int sourceLine) {
        if (this == ArithmeticSign.SHL) {
            return Integer.toString(leftVal << rightVal);
        }
        if (this == ArithmeticSign.SHR) {
            return Integer.toString(leftVal >> rightVal);
        }
        if (this == ArithmeticSign.UNSIGNED_SHR) {
            return Integer.toString(leftVal >>> rightVal);
        }
        throw new CanNotEvaluateValueForSignException(this, sourceLine);
    }

    public String evaluateForShift(byte leftVal, long rightVal, int sourceLine) {
        if (this == ArithmeticSign.SHL) {
            return Integer.toString(leftVal << rightVal);
        }
        if (this == ArithmeticSign.SHR) {
            return Integer.toString(leftVal >> rightVal);
        }
        if (this == ArithmeticSign.UNSIGNED_SHR) {
            return Integer.toString(leftVal >>> rightVal);
        }
        throw new CanNotEvaluateValueForSignException(this, sourceLine);
    }
}
