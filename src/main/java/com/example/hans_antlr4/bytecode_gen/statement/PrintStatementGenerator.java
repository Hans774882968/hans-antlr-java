package com.example.hans_antlr4.bytecode_gen.statement;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.PrintStatement;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.ClassType;
import com.example.hans_antlr4.domain.type.Type;

import lombok.Getter;

@Getter
public class PrintStatementGenerator implements Opcodes {
    private MethodVisitor mv;
    private Scope scope;
    private ExpressionGenerator expressionGenerator;

    public PrintStatementGenerator(MethodVisitor mv, Scope scope, boolean constantFolding) {
        this.mv = mv;
        this.scope = scope;
        this.expressionGenerator = new ExpressionGenerator(mv, scope, constantFolding);
    }

    private String getPrintMethodDescriptor(Type type) {
        if (!(type instanceof BuiltInType) || !type.getTypeClass().isPrimitive()) {
            return "(" + ClassType.getTypeByQualifiedName("java.lang.Object").getDescriptor() + ")V";
        }
        if (type == BuiltInType.BYTE) {
            return "(I)V";
        }
        return "(" + type.getDescriptor() + ")V";
    }

    public void generate(PrintStatement printStatement) {
        Expression expression = printStatement.getExpression();
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        expression.accept(expressionGenerator);
        Type type = expression.getType();
        String descriptor = getPrintMethodDescriptor(type); // such as "(Ljava/lang/String;)V"
        ClassType owner = new ClassType("java.io.PrintStream");
        String fieldDescriptor = owner.getInternalName(); // "java/io/PrintStream"
        String printMethodName = printStatement.isShouldNotPrintLine() ? "print" : "println";
        mv.visitMethodInsn(INVOKEVIRTUAL, fieldDescriptor, printMethodName, descriptor, false);
    }
}
