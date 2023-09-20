package com.example.hans_antlr4.parsing.biz_visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.hans_antlr4.domain.expression.Parameter;
import com.example.hans_antlr4.domain.scope.FunctionSignature;
import com.example.hans_antlr4.domain.type.Type;
import com.example.hans_antlr4.parsing.HansAntlrParserBaseVisitor;
import com.example.hans_antlr4.parsing.HansAntlrParser;
import com.example.hans_antlr4.parsing.HansAntlrParser.FunctionParameterListContext;
import com.example.hans_antlr4.utils.TypeResolver;

public class FunctionSignatureVisitor extends HansAntlrParserBaseVisitor<FunctionSignature> {
    @Override
    public FunctionSignature visitFunctionDeclaration(HansAntlrParser.FunctionDeclarationContext ctx) {
        String functionName = ctx.functionName().getText();
        FunctionParameterListContext paramsCtx = ctx.functionParameterList();
        List<Parameter> parameters = paramsCtx == null
                ? new ArrayList<>()
                : paramsCtx.functionParameter().stream()
                        .map(paramCtx -> new Parameter(
                                TypeResolver.getFromTypeContext(paramCtx.type()),
                                paramCtx.Identifier().getText()))
                        .collect(Collectors.toList());
        Type returnType = TypeResolver.getFromTypeContext(ctx.type());
        return new FunctionSignature(true, functionName, parameters, returnType);
    }
}
