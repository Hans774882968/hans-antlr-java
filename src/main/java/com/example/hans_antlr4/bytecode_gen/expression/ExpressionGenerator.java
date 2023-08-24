package com.example.hans_antlr4.bytecode_gen.expression;

import org.apache.commons.lang3.StringUtils;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.domain.expression.Addition;
import com.example.hans_antlr4.domain.expression.And;
import com.example.hans_antlr4.domain.expression.ArithmeticExpression;
import com.example.hans_antlr4.domain.expression.AssignmentExpression;
import com.example.hans_antlr4.domain.expression.ConditionalExpression;
import com.example.hans_antlr4.domain.expression.Division;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.expression.Mod;
import com.example.hans_antlr4.domain.expression.Multiplication;
import com.example.hans_antlr4.domain.expression.Or;
import com.example.hans_antlr4.domain.expression.Pow;
import com.example.hans_antlr4.domain.expression.Shl;
import com.example.hans_antlr4.domain.expression.Shr;
import com.example.hans_antlr4.domain.expression.Subtraction;
import com.example.hans_antlr4.domain.expression.UnsignedShr;
import com.example.hans_antlr4.domain.expression.Value;
import com.example.hans_antlr4.domain.expression.VarReference;
import com.example.hans_antlr4.domain.expression.Xor;
import com.example.hans_antlr4.domain.expression.unary.UnaryNegative;
import com.example.hans_antlr4.domain.expression.unary.UnaryPositive;
import com.example.hans_antlr4.domain.expression.unary.UnaryTilde;
import com.example.hans_antlr4.domain.scope.LocalVariable;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.ClassType;
import com.example.hans_antlr4.domain.type.Type;

import lombok.Data;

@Data
public class ExpressionGenerator implements Opcodes {
    private MethodVisitor mv;
    private Scope scope;
    private ConditionalExpressionGenerator conditionalExpressionGenerator;
    private AssignmentExpressionGenerator assignmentExpressionGenerator;

    public ExpressionGenerator(MethodVisitor mv, Scope scope) {
        this.mv = mv;
        this.scope = scope;
        this.conditionalExpressionGenerator = new ConditionalExpressionGenerator(this, mv);
        this.assignmentExpressionGenerator = new AssignmentExpressionGenerator(this, mv);
    }

    // 给 Expression 添加 accept 抽象方法来调用 ExpressionGenerator 下的某个 generate 方法，于是 public void generate(Expression expression, Scope scope) 可以删除
    public void generate(VarReference varReference) {
        String varName = varReference.getVarName();
        int index = scope.getLocalVariableIndex(varName);
        LocalVariable localVariable = scope.getLocalVariable(varName);
        Type type = localVariable.getType();
        if (type == BuiltInType.INT) {
            mv.visitVarInsn(ILOAD, index);
        }
        if (type == BuiltInType.STRING) {
            mv.visitVarInsn(ALOAD, index);
        }
    }

    public void generate(Value value) {
        Type type = value.getType();
        String stringValue = value.getValue();
        if (type == BuiltInType.INT) {
            int intValue = Integer.parseInt(stringValue);
            if (Byte.MIN_VALUE <= intValue && intValue <= Byte.MAX_VALUE) {
                mv.visitIntInsn(BIPUSH, intValue);
            } else if (Short.MIN_VALUE <= intValue && intValue <= Short.MAX_VALUE) {
                mv.visitIntInsn(SIPUSH, intValue);
            } else {
                mv.visitLdcInsn(intValue);
            }
        }
        if (type == BuiltInType.STRING) {
            stringValue = StringUtils.removeStart(stringValue, "\"");
            stringValue = StringUtils.removeEnd(stringValue, "\"");
            mv.visitLdcInsn(stringValue);
        }
    }

    public void generate(UnaryPositive expression) {
        expression.getExpression().accept(this);
    }

    public void generate(UnaryNegative expression) {
        expression.getExpression().accept(this);
        mv.visitInsn(INEG);
    }

    public void generate(UnaryTilde expression) {
        expression.getExpression().accept(this);
        mv.visitInsn(ICONST_M1);
        mv.visitInsn(IXOR);
    }

    public void generate(Addition expression) {
        evaluateArithmeticComponents(expression);
        mv.visitInsn(IADD);
    }

    public void generate(Subtraction expression) {
        evaluateArithmeticComponents(expression);
        mv.visitInsn(ISUB);
    }

    public void generate(Multiplication expression) {
        evaluateArithmeticComponents(expression);
        mv.visitInsn(IMUL);
    }

    public void generate(Division expression) {
        evaluateArithmeticComponents(expression);
        mv.visitInsn(IDIV);
    }

    public void generate(Pow expression) {
        Expression leftExpression = expression.getLeftExpression();
        Expression rightExpression = expression.getRightExpression();
        leftExpression.accept(this);
        mv.visitInsn(I2D);
        rightExpression.accept(this);
        mv.visitInsn(I2D);
        ClassType owner = new ClassType("java.lang.Math");
        String fieldDescriptor = owner.getInternalName(); // "java/lang/Math"
        String descriptor = "(DD)D";
        mv.visitMethodInsn(INVOKESTATIC, fieldDescriptor, "pow", descriptor, false);
        mv.visitInsn(D2I);
    }

    public void generate(Mod expression) {
        evaluateArithmeticComponents(expression);
        mv.visitInsn(IREM);
    }

    public void generate(Shl expression) {
        evaluateArithmeticComponents(expression);
        mv.visitInsn(ISHL);
    }

    public void generate(Shr expression) {
        evaluateArithmeticComponents(expression);
        mv.visitInsn(ISHR);
    }

    public void generate(UnsignedShr expression) {
        evaluateArithmeticComponents(expression);
        mv.visitInsn(IUSHR);
    }

    public void generate(And expression) {
        evaluateArithmeticComponents(expression);
        mv.visitInsn(IAND);
    }

    public void generate(Xor expression) {
        evaluateArithmeticComponents(expression);
        mv.visitInsn(IXOR);
    }

    public void generate(Or expression) {
        evaluateArithmeticComponents(expression);
        mv.visitInsn(IOR);
    }

    public void generate(ConditionalExpression conditionalExpression) {
        conditionalExpressionGenerator.generate(conditionalExpression);
    }

    public void generate(AssignmentExpression assignmentExpression) {
        assignmentExpressionGenerator.generate(assignmentExpression);
    }

    // 递归，直到走到 generate(VarReference varReference) or generate(Value value)
    private void evaluateArithmeticComponents(ArithmeticExpression expression) {
        Expression leftExpression = expression.getLeftExpression();
        Expression rightExpression = expression.getRightExpression();
        leftExpression.accept(this);
        rightExpression.accept(this);
    }
}
