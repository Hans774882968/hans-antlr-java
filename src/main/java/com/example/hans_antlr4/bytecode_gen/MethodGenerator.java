package com.example.hans_antlr4.bytecode_gen;

import java.util.List;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.bytecode_gen.statement.StatementGenerator;
import com.example.hans_antlr4.domain.expression.EmptyExpression;
import com.example.hans_antlr4.domain.global.Function;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.Block;
import com.example.hans_antlr4.domain.statement.ReturnStatement;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.utils.DescriptorFactory;

public class MethodGenerator implements Opcodes {
    private ClassWriter classWriter;

    public MethodGenerator(ClassWriter classWriter) {
        this.classWriter = classWriter;
    }

    // 重载是为了方便单测传入 mock MethodVisitor
    public void generate(Function function) {
        String name = function.getFunctionSignature().getName();
        String description = DescriptorFactory.getMethodDescriptor(function);
        // hant 所有的函数定义和全局变量都加到对用户透明的 public class 中，所以 access 是 public static
        MethodVisitor mv = classWriter.visitMethod(ACC_PUBLIC + ACC_STATIC, name, description, null, null);
        generate(function, mv);
    }

    public void generate(Function function, MethodVisitor mv) {
        mv.visitCode();
        Block body = function.getBody();
        Scope scope = body.getScope();
        StatementGenerator statementGenerator = new StatementGenerator(mv, scope);
        body.accept(statementGenerator);
        appendReturnIfLastStatementIsNotReturn(function, statementGenerator);
        mv.visitMaxs(-1, -1);
        mv.visitEnd();
    }

    public void appendReturnIfLastStatementIsNotReturn(
            Function function,
            StatementGenerator statementGenerator) {
        boolean isLastStatementReturn = false;
        List<Statement> statements = function.getBody().getStatements();
        if (!statements.isEmpty()) {
            Statement lastStatement = statements.get(statements.size() - 1);
            isLastStatementReturn = lastStatement instanceof ReturnStatement;
        }
        if (!isLastStatementReturn) {
            EmptyExpression emptyExpression = new EmptyExpression(function.getFunctionSignature().getReturnType());
            ReturnStatement returnStatement = new ReturnStatement(emptyExpression);
            returnStatement.accept(statementGenerator);
        }
    }
}
