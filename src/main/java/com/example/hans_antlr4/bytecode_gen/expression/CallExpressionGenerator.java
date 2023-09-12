package com.example.hans_antlr4.bytecode_gen.expression;

import java.util.List;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.expression.Parameter;
import com.example.hans_antlr4.domain.expression.call.ConstructorCall;
import com.example.hans_antlr4.domain.expression.call.FunctionCall;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.utils.DescriptorFactory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CallExpressionGenerator implements Opcodes {
    private ExpressionGenerator parent;
    private MethodVisitor mv;

    public boolean generateObjectArrayInsnForVarArg(List<Parameter> parameters, List<Expression> arguments) {
        if (parameters.isEmpty() || parameters.get(parameters.size() - 1).getType() != BuiltInType.OBJECT_ARR) {
            return false;
        }
        for (int i = 0; i < parameters.size() - 1; i++) {
            Expression arg = arguments.get(i);
            arg.accept(parent);
        }
        int objArrSize = arguments.size() - parameters.size() + 1;
        mv.visitLdcInsn(objArrSize);
        mv.visitTypeInsn(ANEWARRAY, "java/lang/Object");
        for (int i = 0; i < objArrSize; i++) {
            Expression arg = arguments.get(parameters.size() - 1 + i);
            mv.visitInsn(DUP);
            mv.visitLdcInsn(i);
            arg.accept(parent);
            mv.visitInsn(AASTORE);
        }
        return true;
    }

    public void generate(FunctionCall functionCall) {
        Expression owner = functionCall.getOwner();
        owner.accept(parent);
        List<Expression> arguments = functionCall.getArguments();
        List<Parameter> parameters = functionCall.getSignature().getParameters();
        boolean generated = generateObjectArrayInsnForVarArg(parameters, arguments);
        if (!generated) {
            arguments.forEach(arg -> arg.accept(parent));
        }
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
    }

    // TODO: 支持 new
    public void generate(ConstructorCall constructorCall) {

    }
}
