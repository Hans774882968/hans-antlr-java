package com.example.hans_antlr4.bytecode_gen.expression;

import java.util.List;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.bytecode_gen.InsnUtil;
import com.example.hans_antlr4.domain.expression.ArrayAccess;
import com.example.hans_antlr4.domain.expression.ArrayDeclaration;
import com.example.hans_antlr4.domain.expression.ArrayLiteral;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.Type;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ArrayGenerator implements Opcodes {
    private ExpressionGenerator parent;
    private MethodVisitor mv;

    public void generate(ArrayLiteral arrayLiteral) {
        List<Expression> items = arrayLiteral.getItems();
        // ArrayLiteral 构造函数保证 items 一定有至少一个元素
        InsnUtil.generateIntInsn(mv, items.size());
        Type elementType = items.get(0).getType();
        if (elementType.getTypeClass().isPrimitive()) {
            mv.visitIntInsn(NEWARRAY, elementType.getPrimitiveTypeOperand());
        } else {
            String internalName = elementType.getInternalName();
            mv.visitTypeInsn(ANEWARRAY, internalName);
        }

        for (int i = 0; i < items.size(); i++) {
            Expression item = items.get(i);
            mv.visitInsn(DUP);
            InsnUtil.generateIntInsn(mv, i);
            item.accept(parent);
            mv.visitInsn(item.getType().getStoreArrayItemOpcode());
        }
    }

    public void generate(ArrayDeclaration arrayDeclaration) {
        List<Expression> dimensions = arrayDeclaration.getDimensions();
        dimensions.forEach(dimension -> {
            dimension.accept(parent);
        });
        String descriptor = arrayDeclaration.getType().getDescriptor();
        mv.visitMultiANewArrayInsn(descriptor, dimensions.size());
    }

    public void generate(ArrayAccess arrayAccess, boolean generateLastInsn) {
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
            if (i == sz - 1) {
                if (generateLastInsn) {
                    mv.visitInsn(resultType.getLoadArrayItemOpcode());
                }
            } else {
                mv.visitInsn(AALOAD);
            }
        }
    }
}
