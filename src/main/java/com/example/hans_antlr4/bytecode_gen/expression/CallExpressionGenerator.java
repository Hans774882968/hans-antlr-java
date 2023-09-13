package com.example.hans_antlr4.bytecode_gen.expression;

import java.util.List;
import java.util.stream.Collectors;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.bytecode_gen.InsnUtil;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.expression.Parameter;
import com.example.hans_antlr4.domain.expression.call.ConstructorCall;
import com.example.hans_antlr4.domain.expression.call.FunctionCall;
import com.example.hans_antlr4.domain.scope.FunctionSignature;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.ClassType;
import com.example.hans_antlr4.domain.type.Type;
import com.example.hans_antlr4.utils.DescriptorFactory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CallExpressionGenerator implements Opcodes {
    private ExpressionGenerator parent;
    private MethodVisitor mv;

    public void generateAutoBoxingInsn(Expression arg) {
        Type type = arg.getType();
        if (type == BuiltInType.BOOLEAN) {
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;", false);
        }
        if (type == BuiltInType.CHAR) {
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;", false);
        }
        if (type == BuiltInType.BYTE) {
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;", false);
        }
        if (type == BuiltInType.SHORT) {
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;", false);
        }
        if (type == BuiltInType.INT) {
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;", false);
        }
        if (type == BuiltInType.LONG) {
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;", false);
        }
        if (type == BuiltInType.FLOAT) {
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;", false);
        }
        if (type == BuiltInType.DOUBLE) {
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;", false);
        }
    }

    public boolean generateObjectArrayInsnForVarArg(List<Parameter> parameters, List<Expression> arguments) {
        if (parameters.isEmpty() || parameters.get(parameters.size() - 1).getType() != BuiltInType.OBJECT_ARR) {
            return false;
        }
        for (int i = 0; i < parameters.size() - 1; i++) {
            Expression arg = arguments.get(i);
            arg.accept(parent);
        }
        int objArrSize = arguments.size() - parameters.size() + 1;
        InsnUtil.generateIntInsn(mv, objArrSize);
        mv.visitTypeInsn(ANEWARRAY, "java/lang/Object");
        for (int i = 0; i < objArrSize; i++) {
            Expression arg = arguments.get(parameters.size() - 1 + i);
            mv.visitInsn(DUP);
            InsnUtil.generateIntInsn(mv, i);
            arg.accept(parent);
            generateAutoBoxingInsn(arg);
            mv.visitInsn(AASTORE);
        }
        return true;
    }

    public void generateArguments(List<Parameter> parameters, List<Expression> arguments) {
        boolean generated = generateObjectArrayInsnForVarArg(parameters, arguments);
        if (!generated) {
            arguments.forEach(arg -> arg.accept(parent));
        }
    }

    public void generate(FunctionCall functionCall) {
        Expression owner = functionCall.getOwner();
        owner.accept(parent);

        List<Expression> arguments = functionCall.getArguments();
        List<Parameter> parameters = functionCall.getSignature().getParameters();
        generateArguments(parameters, arguments);

        String ownerDescriptor = owner == null || owner.getType().getName() == null
                ? ""
                : owner.getType().getInternalName();
        String functionName = functionCall.getSignature().getName();
        String methodDescriptor = DescriptorFactory.getMethodDescriptor(functionCall.getSignature());
        if (functionCall.getSignature().isStatic()) {
            mv.visitMethodInsn(INVOKESTATIC, ownerDescriptor, functionName, methodDescriptor, false);
        } else {
            mv.visitMethodInsn(INVOKEVIRTUAL, ownerDescriptor, functionName, methodDescriptor, false);
        }

        if (functionCall.getType() != BuiltInType.VOID && functionCall.returnValueIsNotUsed()) {
            mv.visitInsn(POP);
        }
    }

    public void generate(ConstructorCall constructorCall) {
        List<Expression> arguments = constructorCall.getArguments();
        List<Type> argTypes = arguments.stream().map(arg -> arg.getType()).collect(Collectors.toList());
        FunctionSignature signature = parent.getScope().getConstructorCallSignature(
                constructorCall.getIdentifier(),
                argTypes,
                constructorCall.getSourceLine());

        String ownerDescriptor = new ClassType(signature.getName()).getInternalName();
        mv.visitTypeInsn(NEW, ownerDescriptor);
        mv.visitInsn(DUP);

        List<Parameter> parameters = signature.getParameters();
        generateArguments(parameters, arguments);

        String methodDescriptor = DescriptorFactory.getMethodDescriptor(signature);
        mv.visitMethodInsn(INVOKESPECIAL, ownerDescriptor, "<init>", methodDescriptor, false);

        if (constructorCall.returnValueIsNotUsed()) {
            mv.visitInsn(POP);
        }
    }
}
