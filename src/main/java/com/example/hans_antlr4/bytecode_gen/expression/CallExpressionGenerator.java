package com.example.hans_antlr4.bytecode_gen.expression;

import java.util.List;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.expression.call.FunctionCall;
import com.example.hans_antlr4.utils.DescriptorFactory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CallExpressionGenerator implements Opcodes {
    private ExpressionGenerator parent;
    private MethodVisitor mv;

    public void generate(FunctionCall functionCall) {
        List<Expression> parameters = functionCall.getArguments();
        parameters.forEach(param -> param.accept(parent));
        String ownerDescriptor = functionCall.getOwner() == null || functionCall.getOwner().getName() == null
                ? ""
                : functionCall.getOwner().getInternalName();
        String functionName = functionCall.getSignature().getName();
        String methodDescriptor = DescriptorFactory.getMethodDescriptor(functionCall.getSignature());
        mv.visitMethodInsn(INVOKESTATIC, ownerDescriptor, functionName, methodDescriptor, false);
    }
}
