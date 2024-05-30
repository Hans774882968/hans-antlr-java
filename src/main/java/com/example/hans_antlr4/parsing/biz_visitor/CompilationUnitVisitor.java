package com.example.hans_antlr4.parsing.biz_visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.hans_antlr4.bytecode_gen.CompilationUnit;
import com.example.hans_antlr4.domain.global.Function;
import com.example.hans_antlr4.domain.global.MetaData;
import com.example.hans_antlr4.domain.scope.FunctionSignature;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.Block;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.parsing.HansAntlrParserBaseVisitor;
import com.example.hans_antlr4.program_arguments.CompilerArguments;
import com.example.hans_antlr4.parsing.HansAntlrParser.CompilationUnitContext;
import com.example.hans_antlr4.parsing.HansAntlrParser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Data
public class CompilationUnitVisitor extends HansAntlrParserBaseVisitor<CompilationUnit> {
    private String publicClassName;
    private CompilerArguments compilerArguments;

    private Function getClinitFunction(CompilationUnitContext ctx, Scope scope) {
        List<Statement> globalVariables = ctx.globalVariable().stream()
                .map(variable -> variable.accept(new GlobalVariableDeclarationVisitor(scope)))
                .collect(Collectors.toList());
        Function clinitFunction = new Function(
                new FunctionSignature(true, "<clinit>", new ArrayList<>(), BuiltInType.VOID),
                new Block(globalVariables, scope));
        return clinitFunction;
    }

    @Override
    public CompilationUnit visitCompilationUnit(HansAntlrParser.CompilationUnitContext ctx) {
        Scope scope = new Scope(new MetaData(publicClassName));
        // 在读取所有函数前，要预先读取函数签名
        FunctionSignatureVisitor functionSignatureVisitor = new FunctionSignatureVisitor();
        ctx.function().stream()
                .map(method -> method.functionDeclaration().accept(functionSignatureVisitor))
                .peek(scope::addSignature)
                .collect(Collectors.toList());

        List<Function> methods = new ArrayList<>();

        Function clinitFunction = getClinitFunction(ctx, scope);
        methods.add(clinitFunction);

        methods.addAll(
                ctx.function().stream()
                        .map(method -> method.accept(new FunctionVisitor(scope)))
                        .collect(Collectors.toList()));

        return new CompilationUnit(methods, compilerArguments);
    }
}
