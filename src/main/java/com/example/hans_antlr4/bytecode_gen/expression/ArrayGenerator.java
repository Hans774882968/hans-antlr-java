package com.example.hans_antlr4.bytecode_gen.expression;

import java.util.List;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.domain.expression.ArrayAccess;
import com.example.hans_antlr4.domain.expression.ArrayDeclaration;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.Type;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ArrayGenerator implements Opcodes {
    private ExpressionGenerator parent;
    private MethodVisitor mv;

    public void generate(ArrayDeclaration arrayDeclaration) {
        List<Expression> dimensions = arrayDeclaration.getDimensions();
        dimensions.forEach(dimension -> {
            dimension.accept(parent);
        });
        String descriptor = arrayDeclaration.getType().getDescriptor();
        mv.visitMultiANewArrayInsn(descriptor, dimensions.size());
    }

    public void generate(ArrayAccess arrayAccess) {
        arrayAccess.getArray().accept(parent);
        Type resultType = arrayAccess.getType();
        int sz = arrayAccess.getDimensions().size();
        for (int i = 0; i < sz; i++) {
            Expression currentDimension = arrayAccess.getDimensions().get(i);
            currentDimension.accept(parent);
            // 数组下标支持 long 和 int
            if (currentDimension.getType() == BuiltInType.LONG) {
                mv.visitInsn(L2I);
            }
            // TODO: 枚举所有可能情况
            if (i == sz - 1) {
                if (resultType == BuiltInType.BOOLEAN) {
                    mv.visitInsn(BALOAD);
                } else if (resultType == BuiltInType.CHAR) {
                    mv.visitInsn(CALOAD);
                } else if (resultType == BuiltInType.SHORT) {
                    mv.visitInsn(SALOAD);
                } else if (resultType == BuiltInType.INT) {
                    mv.visitInsn(IALOAD);
                } else if (resultType == BuiltInType.LONG) {
                    mv.visitInsn(LALOAD);
                } else if (resultType == BuiltInType.FLOAT) {
                    mv.visitInsn(FALOAD);
                } else if (resultType == BuiltInType.DOUBLE) {
                    mv.visitInsn(DALOAD);
                } else if (resultType == BuiltInType.STRING) {
                    mv.visitInsn(AALOAD);
                } else {
                    mv.visitInsn(AALOAD);
                }
            } else {
                mv.visitInsn(AALOAD);
            }
        }
    }
}
