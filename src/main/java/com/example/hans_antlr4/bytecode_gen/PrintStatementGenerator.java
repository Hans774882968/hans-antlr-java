package com.example.hans_antlr4.bytecode_gen;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.PrintStatement;
import com.example.hans_antlr4.domain.type.ClassType;
import com.example.hans_antlr4.domain.type.Type;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PrintStatementGenerator implements Opcodes {
    private Scope scope;

    public void generate(MethodVisitor mv, PrintStatement printStatement) {
        ExpressionGenerator expressionGenerator = new ExpressionGenerator(mv, scope);
        Expression expression = printStatement.getExpression();
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        expression.accept(expressionGenerator);
        Type type = expression.getType();
        String descriptor = "(" + type.getDescriptor() + ")V"; // such as "(Ljava/lang/String;)V"
        ClassType owner = new ClassType("java.io.PrintStream");
        String fieldDescriptor = owner.getInternalName(); // "java/io/PrintStream"
        mv.visitMethodInsn(INVOKEVIRTUAL, fieldDescriptor, "println", descriptor, false);
    }
}
