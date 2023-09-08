package com.example.hans_antlr4;

import static org.mockito.Mockito.mock;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.objectweb.asm.MethodVisitor;

import com.example.hans_antlr4.bytecode_gen.CompilationUnit;
import com.example.hans_antlr4.bytecode_gen.statement.StatementGenerator;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.parsing.ParseEntry;

public class TestUtils {
    public static Statement getFirstStatementFromCode(String code) {
        CompilationUnit compilationUnit = ParseEntry.parseFromCode(code);
        return compilationUnit.getInstructionsQueue().get(0);
    }

    public static Statement getLastStatementFromCode(String code) {
        CompilationUnit compilationUnit = ParseEntry.parseFromCode(code);
        return compilationUnit.getInstructionsQueue().get(compilationUnit.getInstructionsQueue().size() - 1);
    }

    public static List<Statement> getStatementsFromCode(String code) {
        CompilationUnit compilationUnit = ParseEntry.parseFromCode(code);
        return compilationUnit.getInstructionsQueue();
    }

    public static MethodVisitor mockGenerateBytecode(List<Statement> statements) {
        MethodVisitor mv = mock(MethodVisitor.class);
        Scope scope = mock(Scope.class);
        StatementGenerator statementGenerator = new StatementGenerator(mv, scope);
        for (Statement statement : statements) {
            statement.accept(statementGenerator);
        }
        return mv;
    }

    public static MethodVisitor mockGenerateBytecode(List<Statement> statements, Scope scope) {
        MethodVisitor mv = mock(MethodVisitor.class);
        StatementGenerator statementGenerator = new StatementGenerator(mv, scope);
        for (Statement statement : statements) {
            statement.accept(statementGenerator);
        }
        return mv;
    }

    public static void runBlackBox(String filePath) {
        App.main(ArrayUtils.addAll(new String[] {
                "-runMode",
                "-file",
        }, filePath));
    }
}
