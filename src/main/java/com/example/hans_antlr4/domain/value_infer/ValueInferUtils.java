package com.example.hans_antlr4.domain.value_infer;

import java.util.List;

import com.example.hans_antlr4.domain.expression.Addition;
import com.example.hans_antlr4.domain.expression.ArithmeticExpression;
import com.example.hans_antlr4.domain.expression.ConditionalExpression;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.expression.TemplateString;
import com.example.hans_antlr4.domain.expression.Value;
import com.example.hans_antlr4.domain.expression.unary.Unary;
import com.example.hans_antlr4.domain.expression.unary.UnaryNegative;
import com.example.hans_antlr4.domain.expression.unary.UnaryTilde;
import com.example.hans_antlr4.domain.global.ArithmeticSign;
import com.example.hans_antlr4.domain.global.ValueInferResult;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.Type;
import com.example.hans_antlr4.exception.ArithmeticExprLhsAndRhsTypeIncompatibleException;
import com.example.hans_antlr4.exception.ConditionalExprLhsAndRhsTypeIncompatibleException;
import com.example.hans_antlr4.exception.type.IllegalUnaryNegPosTypeException;
import com.example.hans_antlr4.exception.type.IllegalUnaryTildeTypeException;
import com.example.hans_antlr4.utils.TypeResolver;

public class ValueInferUtils {
    public static ValueInferResult calcValueInferResultForAddition(Addition addition) {
        ValueInferResult leftValueInferResult = addition.getLeftExpression().getValueInferResult();
        ValueInferResult rightValueInferResult = addition.getRightExpression().getValueInferResult();
        if (!(leftValueInferResult.isConst() && rightValueInferResult.isConst())) {
            return ValueInferResult.nonConst;
        }

        int sourceLine = addition.getSourceLine();
        Value inferredValue = null;
        if (leftValueInferResult.getValue().getType() == BuiltInType.STRING
                || rightValueInferResult.getValue().getType() == BuiltInType.STRING) {
            String leftVal = TypeResolver.getValueFromString(
                    leftValueInferResult.getValue().getValue(), addition.getType()).toString();
            String rightVal = TypeResolver.getValueFromString(
                    rightValueInferResult.getValue().getValue(), addition.getType()).toString();
            inferredValue = new Value(BuiltInType.STRING, leftVal + rightVal, sourceLine);
        } else if (leftValueInferResult.getValue().getType() == BuiltInType.DOUBLE
                || rightValueInferResult.getValue().getType() == BuiltInType.DOUBLE) {
            double leftVal = (double) TypeResolver.getValueFromString(
                    leftValueInferResult.getValue().getValue(), addition.getType());
            double rightVal = (double) TypeResolver.getValueFromString(
                    rightValueInferResult.getValue().getValue(), addition.getType());
            inferredValue = new Value(BuiltInType.DOUBLE, Double.toString(leftVal + rightVal), sourceLine);
        } else if (leftValueInferResult.getValue().getType() == BuiltInType.FLOAT
                || rightValueInferResult.getValue().getType() == BuiltInType.FLOAT) {
            float leftVal = (float) TypeResolver.getValueFromString(
                    leftValueInferResult.getValue().getValue(), addition.getType());
            float rightVal = (float) TypeResolver.getValueFromString(
                    rightValueInferResult.getValue().getValue(), addition.getType());
            inferredValue = new Value(BuiltInType.FLOAT, Float.toString(leftVal + rightVal), sourceLine);
        } else if (leftValueInferResult.getValue().getType() == BuiltInType.LONG
                || rightValueInferResult.getValue().getType() == BuiltInType.LONG) {
            long leftVal = (long) TypeResolver.getValueFromString(
                    leftValueInferResult.getValue().getValue(), addition.getType());
            long rightVal = (long) TypeResolver.getValueFromString(
                    rightValueInferResult.getValue().getValue(), addition.getType());
            inferredValue = new Value(BuiltInType.LONG, Long.toString(leftVal + rightVal), sourceLine);
        } else if (leftValueInferResult.getValue().getType() == BuiltInType.INT
                || rightValueInferResult.getValue().getType() == BuiltInType.INT) {
            int leftVal = (int) TypeResolver.getValueFromString(
                    leftValueInferResult.getValue().getValue(), addition.getType());
            int rightVal = (int) TypeResolver.getValueFromString(
                    rightValueInferResult.getValue().getValue(), addition.getType());
            inferredValue = new Value(BuiltInType.INT, Integer.toString(leftVal + rightVal), sourceLine);
        } else if (leftValueInferResult.getValue().getType() == BuiltInType.BYTE
                || rightValueInferResult.getValue().getType() == BuiltInType.BYTE) {
            byte leftVal = (byte) TypeResolver.getValueFromString(
                    leftValueInferResult.getValue().getValue(), addition.getLeftType());
            byte rightVal = (byte) TypeResolver.getValueFromString(
                    rightValueInferResult.getValue().getValue(), addition.getRightType());
            inferredValue = new Value(BuiltInType.INT, Integer.toString(leftVal + rightVal), sourceLine);
        } else {
            throw new ArithmeticExprLhsAndRhsTypeIncompatibleException(addition, sourceLine);
        }
        ValueInferResult valueInferResult = new ValueInferResult(true, inferredValue);
        return valueInferResult;
    }

    // NormalArithmeticExpression: ** * / % -
    public static ValueInferResult calcValueInferResultForNormalArithmeticExpression(
            ArithmeticExpression arithmeticExpression) {
        ValueInferResult leftValueInferResult = arithmeticExpression.getLeftExpression().getValueInferResult();
        ValueInferResult rightValueInferResult = arithmeticExpression.getRightExpression()
                .getValueInferResult();
        if (!(leftValueInferResult.isConst() && rightValueInferResult.isConst())) {
            return ValueInferResult.nonConst;
        }

        int sourceLine = arithmeticExpression.getSourceLine();
        ArithmeticSign sign = arithmeticExpression.getSign();
        Value inferredValue = null;
        if (leftValueInferResult.getValue().getType() == BuiltInType.DOUBLE
                || rightValueInferResult.getValue().getType() == BuiltInType.DOUBLE) {
            double leftVal = (double) TypeResolver.getValueFromString(
                    leftValueInferResult.getValue().getValue(), arithmeticExpression.getType());
            double rightVal = (double) TypeResolver.getValueFromString(
                    rightValueInferResult.getValue().getValue(), arithmeticExpression.getType());
            inferredValue = new Value(
                    BuiltInType.DOUBLE,
                    sign.evaluateForNumericExpression(leftVal, rightVal, sourceLine),
                    sourceLine);
        } else if (leftValueInferResult.getValue().getType() == BuiltInType.FLOAT
                || rightValueInferResult.getValue().getType() == BuiltInType.FLOAT) {
            float leftVal = (float) TypeResolver.getValueFromString(
                    leftValueInferResult.getValue().getValue(), arithmeticExpression.getType());
            float rightVal = (float) TypeResolver.getValueFromString(
                    rightValueInferResult.getValue().getValue(), arithmeticExpression.getType());
            inferredValue = new Value(
                    BuiltInType.FLOAT,
                    sign.evaluateForNumericExpression(leftVal, rightVal, sourceLine),
                    sourceLine);
        } else if (leftValueInferResult.getValue().getType() == BuiltInType.LONG
                || rightValueInferResult.getValue().getType() == BuiltInType.LONG) {
            long leftVal = (long) TypeResolver.getValueFromString(
                    leftValueInferResult.getValue().getValue(), arithmeticExpression.getType());
            long rightVal = (long) TypeResolver.getValueFromString(
                    rightValueInferResult.getValue().getValue(), arithmeticExpression.getType());
            inferredValue = new Value(
                    BuiltInType.LONG,
                    sign.evaluateForNumericExpression(leftVal, rightVal, sourceLine),
                    sourceLine);
        } else if (leftValueInferResult.getValue().getType() == BuiltInType.INT
                || rightValueInferResult.getValue().getType() == BuiltInType.INT) {
            int leftVal = (int) TypeResolver.getValueFromString(
                    leftValueInferResult.getValue().getValue(), arithmeticExpression.getType());
            int rightVal = (int) TypeResolver.getValueFromString(
                    rightValueInferResult.getValue().getValue(), arithmeticExpression.getType());
            inferredValue = new Value(
                    BuiltInType.INT,
                    sign.evaluateForNumericExpression(leftVal, rightVal, sourceLine),
                    sourceLine);
        } else if (leftValueInferResult.getValue().getType() == BuiltInType.BYTE
                || rightValueInferResult.getValue().getType() == BuiltInType.BYTE) {
            byte leftVal = (byte) TypeResolver.getValueFromString(
                    leftValueInferResult.getValue().getValue(), arithmeticExpression.getLeftType());
            byte rightVal = (byte) TypeResolver.getValueFromString(
                    rightValueInferResult.getValue().getValue(), arithmeticExpression.getRightType());
            inferredValue = new Value(
                    BuiltInType.INT,
                    sign.evaluateForNumericExpression(leftVal, rightVal, sourceLine),
                    sourceLine);
        } else {
            throw new ArithmeticExprLhsAndRhsTypeIncompatibleException(
                    arithmeticExpression, sourceLine);
        }
        ValueInferResult valueInferResult = new ValueInferResult(true, inferredValue);
        return valueInferResult;
    }

    public static ValueInferResult calcValueInferResultForAndXorOr(
            ArithmeticExpression arithmeticExpression) {
        ValueInferResult leftValueInferResult = arithmeticExpression.getLeftExpression().getValueInferResult();
        ValueInferResult rightValueInferResult = arithmeticExpression.getRightExpression()
                .getValueInferResult();
        if (!(leftValueInferResult.isConst() && rightValueInferResult.isConst())) {
            return ValueInferResult.nonConst;
        }

        int sourceLine = arithmeticExpression.getSourceLine();
        ArithmeticSign sign = arithmeticExpression.getSign();
        Value inferredValue = null;
        if (leftValueInferResult.getValue().getType() == BuiltInType.LONG
                || rightValueInferResult.getValue().getType() == BuiltInType.LONG) {
            long leftVal = (long) TypeResolver.getValueFromString(
                    leftValueInferResult.getValue().getValue(), arithmeticExpression.getType());
            long rightVal = (long) TypeResolver.getValueFromString(
                    rightValueInferResult.getValue().getValue(), arithmeticExpression.getType());
            inferredValue = new Value(
                    BuiltInType.LONG,
                    sign.evaluateForAndXorOr(leftVal, rightVal, sourceLine),
                    sourceLine);
        } else if (leftValueInferResult.getValue().getType() == BuiltInType.INT
                || rightValueInferResult.getValue().getType() == BuiltInType.INT) {
            int leftVal = (int) TypeResolver.getValueFromString(
                    leftValueInferResult.getValue().getValue(), arithmeticExpression.getType());
            int rightVal = (int) TypeResolver.getValueFromString(
                    rightValueInferResult.getValue().getValue(), arithmeticExpression.getType());
            inferredValue = new Value(
                    BuiltInType.INT,
                    sign.evaluateForAndXorOr(leftVal, rightVal, sourceLine),
                    sourceLine);
        } else if (leftValueInferResult.getValue().getType() == BuiltInType.BYTE
                || rightValueInferResult.getValue().getType() == BuiltInType.BYTE) {
            byte leftVal = (byte) TypeResolver.getValueFromString(
                    leftValueInferResult.getValue().getValue(), arithmeticExpression.getLeftType());
            byte rightVal = (byte) TypeResolver.getValueFromString(
                    rightValueInferResult.getValue().getValue(), arithmeticExpression.getRightType());
            inferredValue = new Value(
                    BuiltInType.INT,
                    sign.evaluateForAndXorOr(leftVal, rightVal, sourceLine),
                    sourceLine);
        } else {
            throw new ArithmeticExprLhsAndRhsTypeIncompatibleException(
                    arithmeticExpression, sourceLine);
        }
        ValueInferResult valueInferResult = new ValueInferResult(true, inferredValue);
        return valueInferResult;
    }

    public static ValueInferResult calcValueInferResultForShift(
            ArithmeticExpression arithmeticExpression) {
        ValueInferResult leftValueInferResult = arithmeticExpression.getLeftExpression().getValueInferResult();
        ValueInferResult rightValueInferResult = arithmeticExpression.getRightExpression()
                .getValueInferResult();
        if (!(leftValueInferResult.isConst() && rightValueInferResult.isConst())) {
            return ValueInferResult.nonConst;
        }

        int sourceLine = arithmeticExpression.getSourceLine();
        ArithmeticSign sign = arithmeticExpression.getSign();
        Value inferredValue = null;
        if (leftValueInferResult.getValue().getType() == BuiltInType.LONG) {
            long leftVal = (long) TypeResolver.getValueFromString(
                    leftValueInferResult.getValue().getValue(), arithmeticExpression.getType());
            long rightVal = (long) TypeResolver.getValueFromString(
                    rightValueInferResult.getValue().getValue(), BuiltInType.LONG);
            inferredValue = new Value(
                    BuiltInType.LONG,
                    sign.evaluateForShift(leftVal, rightVal, sourceLine),
                    sourceLine);
        } else if (leftValueInferResult.getValue().getType() == BuiltInType.INT) {
            int leftVal = (int) TypeResolver.getValueFromString(
                    leftValueInferResult.getValue().getValue(), arithmeticExpression.getType());
            long rightVal = (long) TypeResolver.getValueFromString(
                    rightValueInferResult.getValue().getValue(), BuiltInType.LONG);
            inferredValue = new Value(
                    BuiltInType.INT,
                    sign.evaluateForShift(leftVal, rightVal, sourceLine),
                    sourceLine);
        } else if (leftValueInferResult.getValue().getType() == BuiltInType.BYTE) {
            byte leftVal = (byte) TypeResolver.getValueFromString(
                    leftValueInferResult.getValue().getValue(), arithmeticExpression.getLeftType());
            long rightVal = (long) TypeResolver.getValueFromString(
                    rightValueInferResult.getValue().getValue(), BuiltInType.LONG);
            inferredValue = new Value(
                    BuiltInType.INT,
                    sign.evaluateForShift(leftVal, rightVal, sourceLine),
                    sourceLine);
        } else {
            throw new ArithmeticExprLhsAndRhsTypeIncompatibleException(
                    arithmeticExpression, sourceLine);
        }
        ValueInferResult valueInferResult = new ValueInferResult(true, inferredValue);
        return valueInferResult;
    }

    public static ValueInferResult calcValueInferResultForConditionalExpression(
            ConditionalExpression conditionalExpression) {
        ValueInferResult leftValueInferResult = conditionalExpression.getLeftExpression().getValueInferResult();
        ValueInferResult rightValueInferResult = conditionalExpression.getRightExpression().getValueInferResult();
        if (!(leftValueInferResult.isConst() && rightValueInferResult.isConst())) {
            return ValueInferResult.nonConst;
        }

        int sourceLine = conditionalExpression.getSourceLine();
        Value inferredValue = null;
        if (leftValueInferResult.getValue().getType() == BuiltInType.STRING
                || rightValueInferResult.getValue().getType() == BuiltInType.STRING) {
            String leftVal = TypeResolver.getValueFromString(
                    leftValueInferResult.getValue().getValue(), BuiltInType.STRING).toString();
            String rightVal = TypeResolver.getValueFromString(
                    rightValueInferResult.getValue().getValue(), BuiltInType.STRING).toString();
            inferredValue = new Value(
                    BuiltInType.BOOLEAN,
                    Boolean.toString(conditionalExpression.getCompareSign().evaluateValue(leftVal, rightVal)),
                    sourceLine);
        } else if (leftValueInferResult.getValue().getType() == BuiltInType.DOUBLE
                || rightValueInferResult.getValue().getType() == BuiltInType.DOUBLE) {
            double leftVal = (double) TypeResolver.getValueFromString(
                    leftValueInferResult.getValue().getValue(), BuiltInType.DOUBLE);
            double rightVal = (double) TypeResolver.getValueFromString(
                    rightValueInferResult.getValue().getValue(), BuiltInType.DOUBLE);
            inferredValue = new Value(
                    BuiltInType.BOOLEAN,
                    Boolean.toString(conditionalExpression.getCompareSign().evaluateValue(leftVal, rightVal)),
                    sourceLine);
        } else if (leftValueInferResult.getValue().getType() == BuiltInType.FLOAT
                || rightValueInferResult.getValue().getType() == BuiltInType.FLOAT) {
            float leftVal = (float) TypeResolver.getValueFromString(
                    leftValueInferResult.getValue().getValue(), BuiltInType.FLOAT);
            float rightVal = (float) TypeResolver.getValueFromString(
                    rightValueInferResult.getValue().getValue(), BuiltInType.FLOAT);
            inferredValue = new Value(
                    BuiltInType.BOOLEAN,
                    Boolean.toString(conditionalExpression.getCompareSign().evaluateValue(leftVal, rightVal)),
                    sourceLine);
        } else if (leftValueInferResult.getValue().getType() == BuiltInType.LONG
                || rightValueInferResult.getValue().getType() == BuiltInType.LONG) {
            long leftVal = (long) TypeResolver.getValueFromString(
                    leftValueInferResult.getValue().getValue(), BuiltInType.LONG);
            long rightVal = (long) TypeResolver.getValueFromString(
                    rightValueInferResult.getValue().getValue(), BuiltInType.LONG);
            inferredValue = new Value(
                    BuiltInType.BOOLEAN,
                    Boolean.toString(conditionalExpression.getCompareSign().evaluateValue(leftVal, rightVal)),
                    sourceLine);
        } else if (leftValueInferResult.getValue().getType() == BuiltInType.INT
                || rightValueInferResult.getValue().getType() == BuiltInType.INT) {
            int leftVal = (int) TypeResolver.getValueFromString(
                    leftValueInferResult.getValue().getValue(), BuiltInType.INT);
            int rightVal = (int) TypeResolver.getValueFromString(
                    rightValueInferResult.getValue().getValue(), BuiltInType.INT);
            inferredValue = new Value(
                    BuiltInType.BOOLEAN,
                    Boolean.toString(conditionalExpression.getCompareSign().evaluateValue(leftVal, rightVal)),
                    sourceLine);
        } else if (leftValueInferResult.getValue().getType() == BuiltInType.BYTE
                || rightValueInferResult.getValue().getType() == BuiltInType.BYTE) {
            byte leftVal = (byte) TypeResolver.getValueFromString(
                    leftValueInferResult.getValue().getValue(), BuiltInType.BYTE);
            byte rightVal = (byte) TypeResolver.getValueFromString(
                    rightValueInferResult.getValue().getValue(), BuiltInType.BYTE);
            inferredValue = new Value(
                    BuiltInType.BOOLEAN,
                    Boolean.toString(conditionalExpression.getCompareSign().evaluateValue(leftVal, rightVal)),
                    sourceLine);
        } else if (leftValueInferResult.getValue().getType() == BuiltInType.BOOLEAN
                || rightValueInferResult.getValue().getType() == BuiltInType.BOOLEAN) {
            boolean leftVal = (boolean) TypeResolver.getValueFromString(
                    leftValueInferResult.getValue().getValue(), BuiltInType.BOOLEAN);
            boolean rightVal = (boolean) TypeResolver.getValueFromString(
                    rightValueInferResult.getValue().getValue(), BuiltInType.BOOLEAN);
            inferredValue = new Value(
                    BuiltInType.BOOLEAN,
                    Boolean.toString(conditionalExpression.getCompareSign().evaluateValue(leftVal, rightVal)),
                    sourceLine);
        } else {
            Type leftType = leftValueInferResult.getValue().getType();
            Type rightType = rightValueInferResult.getValue().getType();
            throw new ConditionalExprLhsAndRhsTypeIncompatibleException(leftType, rightType, sourceLine);
        }
        ValueInferResult valueInferResult = new ValueInferResult(true, inferredValue);
        return valueInferResult;
    }

    public static ValueInferResult calcValueInferResultForTemplateString(
            TemplateString templateString) {
        List<Expression> expressions = templateString.getExpressions();
        for (Expression expression : expressions) {
            if (!expression.getValueInferResult().isConst()) {
                return ValueInferResult.nonConst;
            }
        }

        List<String> strs = templateString.getStrs();
        int sz = strs.size();
        int sourceLine = templateString.getSourceLine();
        String inferResult = "";
        for (int i = 0; i < sz; i++) {
            inferResult += strs.get(i);
            if (i == sz - 1) {
                break;
            }
            inferResult += TypeResolver.getValueFromString(
                    expressions.get(i).getValueInferResult().getValue().getValue(),
                    expressions.get(i).getType()).toString();
        }
        Value inferredValue = new Value(BuiltInType.STRING, inferResult, sourceLine);
        ValueInferResult valueInferResult = new ValueInferResult(true, inferredValue);
        return valueInferResult;
    }

    public static ValueInferResult calcValueInferResultForUnaryTilde(
            UnaryTilde unaryTilde) {
        ValueInferResult valueInferResult = unaryTilde.getExpression().getValueInferResult();
        if (!valueInferResult.isConst()) {
            return ValueInferResult.nonConst;
        }

        int sourceLine = unaryTilde.getSourceLine();
        Value inferredValue = null;
        if (valueInferResult.getValue().getType() == BuiltInType.LONG) {
            long val = (long) TypeResolver.getValueFromString(
                    valueInferResult.getValue().getValue(), unaryTilde.getType());
            inferredValue = new Value(
                    BuiltInType.LONG,
                    Long.toString(~val),
                    sourceLine);
        } else if (valueInferResult.getValue().getType() == BuiltInType.INT) {
            int val = (int) TypeResolver.getValueFromString(
                    valueInferResult.getValue().getValue(), unaryTilde.getType());
            inferredValue = new Value(
                    BuiltInType.INT,
                    Integer.toString(~val),
                    sourceLine);
        } else if (valueInferResult.getValue().getType() == BuiltInType.BYTE) {
            byte val = (byte) TypeResolver.getValueFromString(
                    valueInferResult.getValue().getValue(), BuiltInType.BYTE);
            inferredValue = new Value(
                    BuiltInType.INT,
                    Integer.toString(~val),
                    sourceLine);
        } else {
            throw new IllegalUnaryTildeTypeException(
                    unaryTilde, sourceLine);
        }
        ValueInferResult ret = new ValueInferResult(true, inferredValue);
        return ret;
    }

    public static ValueInferResult calcValueInferResultForUnaryNegPos(
            Unary unary) {
        ValueInferResult valueInferResult = unary.getExpression().getValueInferResult();
        if (!valueInferResult.isConst()) {
            return ValueInferResult.nonConst;
        }

        int sourceLine = unary.getSourceLine();
        Value inferredValue = null;
        if (valueInferResult.getValue().getType() == BuiltInType.DOUBLE) {
            double val = (double) TypeResolver.getValueFromString(
                    valueInferResult.getValue().getValue(), unary.getType());
            inferredValue = new Value(
                    BuiltInType.DOUBLE,
                    Double.toString(unary instanceof UnaryNegative ? -val : val),
                    sourceLine);
        } else if (valueInferResult.getValue().getType() == BuiltInType.FLOAT) {
            float val = (float) TypeResolver.getValueFromString(
                    valueInferResult.getValue().getValue(), unary.getType());
            inferredValue = new Value(
                    BuiltInType.FLOAT,
                    Float.toString(unary instanceof UnaryNegative ? -val : val),
                    sourceLine);
        } else if (valueInferResult.getValue().getType() == BuiltInType.LONG) {
            long val = (long) TypeResolver.getValueFromString(
                    valueInferResult.getValue().getValue(), unary.getType());
            inferredValue = new Value(
                    BuiltInType.LONG,
                    Long.toString(unary instanceof UnaryNegative ? -val : val),
                    sourceLine);
        } else if (valueInferResult.getValue().getType() == BuiltInType.INT) {
            int val = (int) TypeResolver.getValueFromString(
                    valueInferResult.getValue().getValue(), unary.getType());
            inferredValue = new Value(
                    BuiltInType.INT,
                    Integer.toString(unary instanceof UnaryNegative ? -val : val),
                    sourceLine);
        } else if (valueInferResult.getValue().getType() == BuiltInType.BYTE) {
            byte val = (byte) TypeResolver.getValueFromString(
                    valueInferResult.getValue().getValue(), BuiltInType.BYTE);
            inferredValue = new Value(
                    BuiltInType.INT,
                    Integer.toString(unary instanceof UnaryNegative ? -val : val),
                    sourceLine);
        } else {
            throw new IllegalUnaryNegPosTypeException(
                    unary, sourceLine);
        }
        ValueInferResult ret = new ValueInferResult(true, inferredValue);
        return ret;
    }
}
