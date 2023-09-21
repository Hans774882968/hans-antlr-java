package com.example.hans_antlr4.bytecode_gen.expression;

import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.List;

import org.objectweb.asm.Handle;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.domain.expression.Addition;
import com.example.hans_antlr4.domain.expression.AssignmentExpression;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.expression.TemplateString;
import com.example.hans_antlr4.domain.global.AssignmentSign;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.Type;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StringAppendGenerator implements Opcodes {
    private ExpressionGenerator parent;
    private MethodVisitor mv;

    public void generate(AssignmentExpression assignmentExpression) {
        if (assignmentExpression.getSign() != AssignmentSign.ADD) {
            throw new RuntimeException(
                    "String append operation not supported for operator " + assignmentExpression.getSign());
        }
        Handle handle = new Handle(
                H_INVOKESTATIC,
                org.objectweb.asm.Type.getInternalName(java.lang.invoke.StringConcatFactory.class),
                "makeConcatWithConstants",
                MethodType.methodType(
                        CallSite.class, MethodHandles.Lookup.class, String.class, MethodType.class,
                        String.class, Object[].class).toMethodDescriptorString(),
                false);
        Type lhsType = assignmentExpression.getLhsType();
        Type rhsType = assignmentExpression.getRhsType();
        String descriptor = "(" + lhsType.getDescriptor() + rhsType.getDescriptor() + ")Ljava/lang/String;";
        mv.visitInvokeDynamicInsn("makeConcatWithConstants", descriptor, handle, new Object[] { "\u0001\u0001" });
    }

    public void generate(Addition addition) {
        mv.visitTypeInsn(NEW, "java/lang/StringBuilder");
        mv.visitInsn(DUP);
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false);

        Expression leftExpression = addition.getLeftExpression();
        leftExpression.accept(parent);
        String leftExprDescriptor = leftExpression.getType().getDescriptor();
        String descriptor = "(" + leftExprDescriptor + ")Ljava/lang/StringBuilder;";
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", descriptor, false);

        Expression rightExpression = addition.getRightExpression();
        rightExpression.accept(parent);
        String rightExprDescriptor = rightExpression.getType().getDescriptor();
        descriptor = "(" + rightExprDescriptor + ")Ljava/lang/StringBuilder;";
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", descriptor, false);

        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false);
    }

    public void generate(TemplateString templateString) {
        List<String> strs = templateString.getStrs();
        List<Expression> expressions = templateString.getExpressions();
        int sz = strs.size();
        String descriptor = "(";
        for (int i = 0; i < sz; i++) {
            mv.visitLdcInsn(strs.get(i));
            descriptor += BuiltInType.STRING.getDescriptor();
            if (i == sz - 1) {
                break;
            }
            expressions.get(i).accept(parent);
            descriptor += expressions.get(i).getType().getDescriptor();
        }
        Handle handle = new Handle(
                H_INVOKESTATIC,
                org.objectweb.asm.Type.getInternalName(java.lang.invoke.StringConcatFactory.class),
                "makeConcatWithConstants",
                MethodType.methodType(
                        CallSite.class, MethodHandles.Lookup.class, String.class, MethodType.class,
                        String.class, Object[].class).toMethodDescriptorString(),
                false);
        descriptor += ")Ljava/lang/String;";
        mv.visitInvokeDynamicInsn(
                "makeConcatWithConstants", descriptor, handle,
                new Object[] { "\u0001".repeat((sz << 1) - 1) });
    }
}
