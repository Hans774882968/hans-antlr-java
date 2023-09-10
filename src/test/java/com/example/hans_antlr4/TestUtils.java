package com.example.hans_antlr4;

import static org.mockito.Mockito.mock;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.ArrayUtils;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import com.example.hans_antlr4.bytecode_gen.CompilationUnit;
import com.example.hans_antlr4.bytecode_gen.MethodGenerator;
import com.example.hans_antlr4.bytecode_gen.statement.StatementGenerator;
import com.example.hans_antlr4.domain.global.Function;
import com.example.hans_antlr4.domain.scope.FunctionSignature;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.exception.func.MainMethodNotFoundInPublicClass;
import com.example.hans_antlr4.parsing.ParseEntry;

public class TestUtils {
    private static Function findPublicClassMainMethod(CompilationUnit compilationUnit)
            throws MainMethodNotFoundInPublicClass {
        Optional<Function> oFunc = compilationUnit.getFunctions().stream().filter(function -> {
            FunctionSignature functionSignature = function.getFunctionSignature();
            if (!functionSignature.getName().equals("start")) {
                return false;
            }
            if (functionSignature.getReturnType() != BuiltInType.VOID) {
                return false;
            }
            if (functionSignature.getParameters().size() != 0) {
                return false;
            }
            return true;
        }).findFirst();
        if (oFunc.isPresent()) {
            return oFunc.get();
        }
        throw new MainMethodNotFoundInPublicClass();
    }

    private static Statement getFirstStatementFromFunction(Function function) {
        return function.getBody().getStatements().get(0);
    }

    private static Statement getLastStatementFromFunction(Function function) {
        List<Statement> statements = function.getBody().getStatements();
        return statements.get(statements.size() - 1);
    }

    private static String buildMainMethodCodeFromSnippet(String code) {
        return "void start() {" + code + "}\nvoid main(string[] args) {start()}";
    }

    public static Statement getFirstStatementFromCode(String code) throws MainMethodNotFoundInPublicClass {
        code = buildMainMethodCodeFromSnippet(code);
        CompilationUnit compilationUnit = ParseEntry.parseFromCode(code);
        return getFirstStatementFromFunction(
                findPublicClassMainMethod(compilationUnit));
    }

    public static Statement getLastStatementFromCode(String code) throws MainMethodNotFoundInPublicClass {
        code = buildMainMethodCodeFromSnippet(code);
        CompilationUnit compilationUnit = ParseEntry.parseFromCode(code);
        return getLastStatementFromFunction(
                findPublicClassMainMethod(compilationUnit));
    }

    public static List<Statement> getStatementsFromCode(String code) throws MainMethodNotFoundInPublicClass {
        code = buildMainMethodCodeFromSnippet(code);
        CompilationUnit compilationUnit = ParseEntry.parseFromCode(code);
        return findPublicClassMainMethod(compilationUnit).getBody().getStatements();
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

    public static MethodVisitor mockGenerateOneFunction(String code) {
        CompilationUnit compilationUnit = ParseEntry.parseFromCode(code);
        ClassWriter cw = mock(ClassWriter.class);
        MethodVisitor mv = mock(MethodVisitor.class);
        new MethodGenerator(cw).generate(compilationUnit.getFunctions().get(0), mv);
        return mv;
    }

    public static MethodVisitor[] mockGenerateFunctions(String code) {
        CompilationUnit compilationUnit = ParseEntry.parseFromCode(code);
        ClassWriter cw = mock(ClassWriter.class);
        MethodVisitor[] mvs = new MethodVisitor[compilationUnit.getFunctions().size()];
        for (int i = 0; i < mvs.length; i++) {
            Function fn = compilationUnit.getFunctions().get(i);
            MethodVisitor mv = mock(MethodVisitor.class);
            mvs[i] = mv;
            new MethodGenerator(cw).generate(fn, mv);
        }
        return mvs;
    }
}
