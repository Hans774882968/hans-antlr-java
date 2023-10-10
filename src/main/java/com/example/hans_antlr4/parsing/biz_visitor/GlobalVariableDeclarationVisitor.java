package com.example.hans_antlr4.parsing.biz_visitor;

import java.util.List;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.tree.TerminalNode;

import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.scope.GlobalVariable;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.var.GlobalVariableDeclaration;
import com.example.hans_antlr4.domain.statement.var.VarDefUnit;
import com.example.hans_antlr4.parsing.HansAntlrParser;
import com.example.hans_antlr4.parsing.HansAntlrParser.ExpressionContext;
import com.example.hans_antlr4.parsing.HansAntlrParserBaseVisitor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GlobalVariableDeclarationVisitor extends HansAntlrParserBaseVisitor<GlobalVariableDeclaration> {
    private Scope scope;

    @Override
    public GlobalVariableDeclaration visitGlobalVariable(HansAntlrParser.GlobalVariableContext ctx) {
        List<VarDefUnit> varDefUnits = ctx.variable().varDefUnit().stream().map(varDefUnitCtx -> {
            final TerminalNode varTerminalNode = varDefUnitCtx.Identifier();
            final String varName = varTerminalNode.getText();
            final ExpressionContext expressionContext = varDefUnitCtx.expression();
            final ExpressionVisitor expressionVisitor = new ExpressionVisitor(scope);
            Expression expression = expressionContext.accept(expressionVisitor);

            scope.addGlobalVariable(new GlobalVariable(varName, expression.getType()));

            return new VarDefUnit(varName, expression);
        }).collect(Collectors.toList());

        GlobalVariableDeclaration variableDeclaration = new GlobalVariableDeclaration(varDefUnits);

        return variableDeclaration;
    }
}
