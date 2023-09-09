package com.example.hans_antlr4.parsing.biz_visitor;

import java.util.List;
import java.util.stream.Collectors;

import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.expression.call.Call;
import com.example.hans_antlr4.domain.expression.call.FunctionCall;
import com.example.hans_antlr4.domain.scope.FunctionSignature;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.type.ClassType;
import com.example.hans_antlr4.domain.type.Type;
import com.example.hans_antlr4.parsing.HansAntlrBaseVisitor;
import com.example.hans_antlr4.parsing.HansAntlrParser;
import com.example.hans_antlr4.parsing.HansAntlrParser.ExpressionContext;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CallExpressionVisitor extends HansAntlrBaseVisitor<Call> {
    private Scope scope;
    private ExpressionVisitor parent;

    @Override
    public Call visitFunctionCall(HansAntlrParser.FunctionCallContext ctx) {
        String funName = ctx.funcCall().functionName().getText();

        List<ExpressionContext> expressionContexts = ctx.funcCall().argumentList().expression();
        List<Expression> arguments = expressionContexts.stream().map(expressionContext -> {
            return expressionContext.accept(parent);
        }).collect(Collectors.toList());

        List<Type> argTypes = arguments.stream().map(arg -> {
            return arg.getType();
        }).collect(Collectors.toList());
        int sourceLine = ctx.getStart().getLine();
        FunctionSignature signature = scope.getSignature(funName, argTypes, sourceLine);

        return new FunctionCall(new ClassType(scope.getClassName()), signature, arguments);
    }
}
