package com.example.hans_antlr4.parsing.biz_visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.hans_antlr4.domain.expression.Parameter;
import com.example.hans_antlr4.domain.global.Function;
import com.example.hans_antlr4.domain.scope.FunctionSignature;
import com.example.hans_antlr4.domain.scope.LocalVariable;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.Block;
import com.example.hans_antlr4.domain.type.Type;
import com.example.hans_antlr4.parsing.HansAntlrBaseVisitor;
import com.example.hans_antlr4.parsing.HansAntlrParser;
import com.example.hans_antlr4.parsing.HansAntlrParser.FunctionParameterListContext;
import com.example.hans_antlr4.parsing.HansAntlrParser.TypeContext;
import com.example.hans_antlr4.utils.TypeResolver;

public class FunctionVisitor extends HansAntlrBaseVisitor<Function> {
    private Scope scope;

    public FunctionVisitor(Scope scope) {
        this.scope = new Scope(scope);
    }

    @Override
    public Function visitFunction(HansAntlrParser.FunctionContext ctx) {
        String name = getName(ctx);
        Type returnType = getReturnType(ctx);
        List<Parameter> params = getParameters(ctx);
        Block body = getBody(ctx);
        FunctionSignature functionSignature = new FunctionSignature(true, name, params, returnType);
        return new Function(functionSignature, body);
    }

    private String getName(HansAntlrParser.FunctionContext functionDeclarationContext) {
        return functionDeclarationContext.functionDeclaration().functionName().getText();
    }

    private Type getReturnType(HansAntlrParser.FunctionContext functionDeclarationContext) {
        TypeContext typeCtx = functionDeclarationContext.functionDeclaration().type();
        return TypeResolver.getFromTypeContext(typeCtx);
    }

    private List<Parameter> getParameters(HansAntlrParser.FunctionContext functionDeclarationContext) {
        FunctionParameterListContext paramsCtx = functionDeclarationContext
                .functionDeclaration()
                .functionParameterList();
        List<Parameter> parameters = paramsCtx == null
                ? new ArrayList<>()
                : paramsCtx.functionParameter().stream()
                        .map(paramCtx -> new Parameter(
                                TypeResolver.getFromTypeContext(paramCtx.type()),
                                paramCtx.Identifier().getText()))
                        .peek(param -> scope.addLocalVariable(new LocalVariable(param.getName(), param.getType())))
                        .collect(Collectors.toList());
        return parameters;
    }

    private Block getBody(HansAntlrParser.FunctionContext functionDeclarationContext) {
        StatementVisitor statementVisitor = new StatementVisitor(scope);
        return (Block) functionDeclarationContext.block().accept(statementVisitor);
    }
}
