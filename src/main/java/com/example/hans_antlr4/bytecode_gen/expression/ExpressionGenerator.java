package com.example.hans_antlr4.bytecode_gen.expression;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.bytecode_gen.InsnUtil;
import com.example.hans_antlr4.domain.expression.Addition;
import com.example.hans_antlr4.domain.expression.And;
import com.example.hans_antlr4.domain.expression.ArithmeticExpression;
import com.example.hans_antlr4.domain.expression.ArrayAccess;
import com.example.hans_antlr4.domain.expression.ArrayDeclaration;
import com.example.hans_antlr4.domain.expression.AssignmentExpression;
import com.example.hans_antlr4.domain.expression.ClassFieldReference;
import com.example.hans_antlr4.domain.expression.ConditionalExpression;
import com.example.hans_antlr4.domain.expression.Division;
import com.example.hans_antlr4.domain.expression.EmptyExpression;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.expression.Mod;
import com.example.hans_antlr4.domain.expression.Multiplication;
import com.example.hans_antlr4.domain.expression.Or;
import com.example.hans_antlr4.domain.expression.Pow;
import com.example.hans_antlr4.domain.expression.Shift;
import com.example.hans_antlr4.domain.expression.Shl;
import com.example.hans_antlr4.domain.expression.Shr;
import com.example.hans_antlr4.domain.expression.Subtraction;
import com.example.hans_antlr4.domain.expression.UnsignedShr;
import com.example.hans_antlr4.domain.expression.Value;
import com.example.hans_antlr4.domain.expression.VarReference;
import com.example.hans_antlr4.domain.expression.Xor;
import com.example.hans_antlr4.domain.expression.call.ConstructorCall;
import com.example.hans_antlr4.domain.expression.call.FunctionCall;
import com.example.hans_antlr4.domain.expression.unary.UnaryNegative;
import com.example.hans_antlr4.domain.expression.unary.UnaryPositive;
import com.example.hans_antlr4.domain.expression.unary.UnaryTilde;
import com.example.hans_antlr4.domain.scope.LocalVariable;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.ClassType;
import com.example.hans_antlr4.domain.type.Type;
import com.example.hans_antlr4.exception.UnsupportedTypeForTildeExpressionException;
import com.example.hans_antlr4.utils.TypeResolver;

import lombok.Data;

@Data
public class ExpressionGenerator implements Opcodes {
    private MethodVisitor mv;
    private Scope scope;
    private ConditionalExpressionGenerator conditionalExpressionGenerator;
    private AssignmentExpressionGenerator assignmentExpressionGenerator;
    private StringAppendGenerator stringAppendGenerator;
    private ShiftExpressionGenerator shiftExpressionGenerator;
    private CallExpressionGenerator callExpressionGenerator;
    private ArrayGenerator arrayGenerator;

    public ExpressionGenerator(MethodVisitor mv, Scope scope) {
        this.mv = mv;
        this.scope = scope;
        this.conditionalExpressionGenerator = new ConditionalExpressionGenerator(this, mv);
        this.assignmentExpressionGenerator = new AssignmentExpressionGenerator(this, mv);
        this.stringAppendGenerator = new StringAppendGenerator(this, mv);
        this.shiftExpressionGenerator = new ShiftExpressionGenerator(this, mv);
        this.callExpressionGenerator = new CallExpressionGenerator(this, mv);
        this.arrayGenerator = new ArrayGenerator(this, mv);
    }

    // 给 Expression 添加 accept 抽象方法来调用 ExpressionGenerator 下的某个 generate 方法，于是 public void generate(Expression expression, Scope scope) 可以删除
    public void generate(VarReference varReference) {
        String varName = varReference.getVarName();
        int index = scope.getLocalVariableIndex(varName);
        LocalVariable localVariable = scope.getLocalVariable(varName);
        Type type = localVariable.getType();
        mv.visitVarInsn(type.getLoadVariableOpcode(), index);
    }

    public void generate(ClassFieldReference classFieldReference) {
        classFieldReference.getFieldReferenceRecords().forEach(fieldReferenceRecord -> {
            Type owner = fieldReferenceRecord.getOwner();
            String ownerDescriptor = owner == null || owner.getName() == null
                    ? ""
                    : owner.getInternalName();
            String name = fieldReferenceRecord.getFieldName();
            String descriptor = fieldReferenceRecord.getFieldType().getDescriptor();
            if (fieldReferenceRecord.isStatic()) {
                mv.visitFieldInsn(GETSTATIC, ownerDescriptor, name, descriptor);
            } else {
                mv.visitFieldInsn(GETFIELD, ownerDescriptor, name, descriptor);
            }
        });
    }

    public void generate(ArrayDeclaration arrayDeclaration) {
        arrayGenerator.generate(arrayDeclaration);
    }

    public void generate(ArrayAccess arrayAccess) {
        arrayGenerator.generate(arrayAccess);
    }

    public void generate(Value value) {
        Type type = value.getType();
        String stringValue = value.getValue();
        if (type == BuiltInType.INT) {
            int intValue = (int) TypeResolver.getValueFromString(stringValue, type);
            InsnUtil.generateIntInsn(mv, intValue);
        } else {
            mv.visitLdcInsn(TypeResolver.getValueFromString(stringValue, type));
        }
    }

    public void generate(EmptyExpression emptyExpression) {

    }

    public void generate(UnaryPositive expression) {
        expression.getExpression().accept(this);
    }

    public void generate(UnaryNegative expression) {
        expression.getExpression().accept(this);
        mv.visitInsn(expression.getType().getUnaryNegativeOpcode());
    }

    public void generate(UnaryTilde expression) {
        expression.getExpression().accept(this);
        Type type = expression.getType();
        if (type == BuiltInType.INT) {
            mv.visitInsn(ICONST_M1);
        } else if (type == BuiltInType.LONG) {
            mv.visitLdcInsn(-1L);
        } else {
            throw new UnsupportedTypeForTildeExpressionException(type);
        }
        mv.visitInsn(type.getXorOpcode());
    }

    public void generate(Addition expression) {
        if (expression.getType() == BuiltInType.STRING) {
            stringAppendGenerator.generate(expression);
            return;
        }
        evaluateArithmeticComponents(expression);
        mv.visitInsn(expression.getType().getAddOpcode());
    }

    public void generate(Subtraction expression) {
        evaluateArithmeticComponents(expression);
        mv.visitInsn(expression.getType().getSubtractOpcode());
    }

    public void generate(Multiplication expression) {
        evaluateArithmeticComponents(expression);
        mv.visitInsn(expression.getType().getMultiplyOpcode());
    }

    public void generate(Division expression) {
        evaluateArithmeticComponents(expression);
        mv.visitInsn(expression.getType().getDivideOpcode());
    }

    public void generate(Pow expression) {
        Expression leftExpression = expression.getLeftExpression();
        Expression rightExpression = expression.getRightExpression();
        leftExpression.accept(this);
        mv.visitInsn(leftExpression.getType().getToDoubleOpcode());
        rightExpression.accept(this);
        mv.visitInsn(rightExpression.getType().getToDoubleOpcode());
        ClassType owner = new ClassType("java.lang.Math");
        String fieldDescriptor = owner.getInternalName(); // "java/lang/Math"
        String descriptor = "(DD)D";
        mv.visitMethodInsn(INVOKESTATIC, fieldDescriptor, "pow", descriptor, false);
        // 把运算结果的 double 强转为左右侧的最高优先级类型
        mv.visitInsn(expression.getType().getDoubleToThisTypeOpcode());
    }

    public void generate(Mod expression) {
        evaluateArithmeticComponents(expression);
        mv.visitInsn(expression.getType().getModOpcode());
    }

    public void generate(Shl expression) {
        evaluateShiftComponents(expression);
        mv.visitInsn(expression.getType().getShlOpcode());
    }

    public void generate(Shr expression) {
        evaluateShiftComponents(expression);
        mv.visitInsn(expression.getType().getShrOpcode());
    }

    public void generate(UnsignedShr expression) {
        evaluateShiftComponents(expression);
        mv.visitInsn(expression.getType().getUnsignedShrOpcode());
    }

    public void generate(And expression) {
        evaluateArithmeticComponents(expression);
        mv.visitInsn(expression.getType().getAndOpcode());
    }

    public void generate(Xor expression) {
        evaluateArithmeticComponents(expression);
        mv.visitInsn(expression.getType().getXorOpcode());
    }

    public void generate(Or expression) {
        evaluateArithmeticComponents(expression);
        mv.visitInsn(expression.getType().getOrOpcode());
    }

    public void generate(ConditionalExpression conditionalExpression) {
        conditionalExpressionGenerator.generate(conditionalExpression);
    }

    public void generate(AssignmentExpression assignmentExpression) {
        assignmentExpressionGenerator.generate(assignmentExpression);
    }

    public void generate(FunctionCall functionCall) {
        callExpressionGenerator.generate(functionCall);
    }

    public void generate(ConstructorCall constructorCall) {
        callExpressionGenerator.generate(constructorCall);
    }

    // 递归，直到走到 generate(VarReference varReference) or generate(Value value)
    private void evaluateArithmeticComponents(ArithmeticExpression expression) {
        Expression leftExpression = expression.getLeftExpression();
        Expression rightExpression = expression.getRightExpression();
        Type leftType = leftExpression.getType();
        Type rightType = rightExpression.getType();
        leftExpression.accept(this);
        mv.visitInsn(leftType.getToHigherPriorityNumericTypeOpcode(rightType));
        rightExpression.accept(this);
        mv.visitInsn(rightType.getToHigherPriorityNumericTypeOpcode(leftType));
    }

    private void evaluateShiftComponents(Shift shift) {
        shiftExpressionGenerator.evaluateShiftComponents(shift);
    }
}
