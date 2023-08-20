package com.example.hans_antlr4.parsing.biz_visitor;

import java.util.List;
import java.util.stream.Collectors;

import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.parsing.HansAntlrBaseVisitor;
import com.example.hans_antlr4.parsing.HansAntlrParser;

public class StatementsVisitor extends HansAntlrBaseVisitor<List<Statement>> {
    private Scope scope;

    public StatementsVisitor(Scope scope) {
        super();
        this.scope = scope;
    }

    @Override
    public List<Statement> visitStatements(HansAntlrParser.StatementsContext ctx) {
        StatementVisitor statementVisitor = new StatementVisitor(scope);
        List<Statement> statements = ctx.statement().stream()
                .map(stmt -> stmt.accept(statementVisitor))
                .collect(Collectors.toList());
        return statements;
    }
}
