package com.example.hans_antlr4;

import static org.mockito.Mockito.mock;

import java.util.Queue;

import org.objectweb.asm.MethodVisitor;

import com.example.hans_antlr4.bytecode_gen.CompilationUnit;
import com.example.hans_antlr4.bytecode_gen.statement.StatementGenerator;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.parsing.ParseEntry;

public class TestUtils {
    public static Statement getFirstStatementFromCode(String code) {
        CompilationUnit compilationUnit = ParseEntry.parseFromCode(code);
        return compilationUnit.getInstructionsQueue().peek();
    }

    public static Queue<Statement> getStatementsFromCode(String code) {
        CompilationUnit compilationUnit = ParseEntry.parseFromCode(code);
        return compilationUnit.getInstructionsQueue();
    }

    public static MethodVisitor mockGenerateBytecode(Queue<Statement> statements) {
        MethodVisitor mv = mock(MethodVisitor.class);
        Scope scope = mock(Scope.class);
        StatementGenerator statementGenerator = new StatementGenerator(mv, scope);
        for (Statement statement : statements) {
            statement.accept(statementGenerator);
        }
        return mv;
    }
}
