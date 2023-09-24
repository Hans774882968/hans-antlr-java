package com.example.hans_antlr4.parsing.biz_visitor;

import org.antlr.v4.runtime.tree.TerminalNode;

import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.scope.GlobalVariable;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.GlobalVariableDeclaration;
import com.example.hans_antlr4.parsing.HansAntlrParser;
import com.example.hans_antlr4.parsing.HansAntlrParser.ExpressionContext;
import com.example.hans_antlr4.parsing.HansAntlrParserBaseVisitor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GlobalVariableDeclarationVisitor extends HansAntlrParserBaseVisitor<GlobalVariableDeclaration> {
    private Scope scope;

    @Override
    public GlobalVariableDeclaration visitGlobalVariable(HansAntlrParser.GlobalVariableContext ctx) {
        final TerminalNode varTerminalNode = ctx.variable().Identifier();
        final String varName = varTerminalNode.getText();
        final ExpressionContext expressionContext = ctx.variable().expression();
        final ExpressionVisitor expressionVisitor = new ExpressionVisitor(scope);
        Expression expression = expressionContext.accept(expressionVisitor);

        scope.addGlobalVariable(new GlobalVariable(varName, expression.getType()));
        GlobalVariableDeclaration variableDeclaration = new GlobalVariableDeclaration(varName, expression);

        return variableDeclaration;
    }
}
