package com.example.hans_antlr4.parsing.biz_visitor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.hans_antlr4.domain.expression.EmptyExpression;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.expression.call.Call;
import com.example.hans_antlr4.domain.expression.call.ConstructorCall;
import com.example.hans_antlr4.domain.expression.call.FunctionCall;
import com.example.hans_antlr4.domain.scope.FunctionSignature;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.type.ClassType;
import com.example.hans_antlr4.domain.type.Type;
import com.example.hans_antlr4.parsing.HansAntlrParserBaseVisitor;
import com.example.hans_antlr4.parsing.HansAntlrParser;
import com.example.hans_antlr4.parsing.HansAntlrParser.ExpressionContext;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CallExpressionVisitor extends HansAntlrParserBaseVisitor<Call> {
    private Scope scope;
    private ExpressionVisitor parent;

    @Override
    public FunctionCall visitFunctionCall(HansAntlrParser.FunctionCallContext ctx) {
        String funName = ctx.functionName().getText();

        List<Expression> arguments = getArgumentsForCall(ctx.argumentList());

        List<Type> argTypes = arguments.stream().map(arg -> {
            return arg.getType();
        }).collect(Collectors.toList());
        int sourceLine = ctx.getStart().getLine();

        boolean ownerIsExplicit = ctx.owner != null;
        if (ownerIsExplicit) {
            Expression owner = ctx.owner.accept(parent);
            FunctionSignature signature = scope.getMethodCallSignature(
                    Optional.of(owner.getType()), funName, argTypes, sourceLine);
            return new FunctionCall(owner, signature, arguments, sourceLine);
        }

        FunctionSignature signature = scope.getMethodCallSignature(funName, argTypes, sourceLine);
        Expression owner = new EmptyExpression(ClassType.getTypeByQualifiedName(scope.getClassName()), sourceLine);
        return new FunctionCall(owner, signature, arguments, sourceLine);
    }

    @Override
    public ConstructorCall visitConstructorCall(HansAntlrParser.ConstructorCallContext ctx) {
        String className = ctx.qualifiedName().getText();
        List<Expression> arguments = getArgumentsForCall(ctx.argumentList());
        int sourceLine = ctx.getStart().getLine();
        return new ConstructorCall(className, arguments, sourceLine);
    }

    private List<Expression> getArgumentsForCall(HansAntlrParser.ArgumentListContext ctx) {
        List<ExpressionContext> expressionContexts = ctx.expression();
        List<Expression> arguments = expressionContexts.stream().map(expressionContext -> {
            return expressionContext.accept(parent);
        }).collect(Collectors.toList());
        return arguments;
    }
}
