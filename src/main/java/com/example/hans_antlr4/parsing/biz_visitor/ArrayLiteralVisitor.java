package com.example.hans_antlr4.parsing.biz_visitor;

import java.util.List;
import java.util.stream.Collectors;

import com.example.hans_antlr4.domain.expression.ArrayLiteral;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.parsing.HansAntlrParser;
import com.example.hans_antlr4.parsing.HansAntlrParserBaseVisitor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ArrayLiteralVisitor extends HansAntlrParserBaseVisitor<ArrayLiteral> {
    private ExpressionVisitor parent;

    @Override
    public ArrayLiteral visitArrayLiteral(HansAntlrParser.ArrayLiteralContext ctx) {
        List<Expression> items = ctx.expression().stream()
                .map(expr -> expr.accept(parent))
                .collect(Collectors.toList());
        int sourceLine = ctx.getStart().getLine();
        return new ArrayLiteral(items, sourceLine);
    }
}
