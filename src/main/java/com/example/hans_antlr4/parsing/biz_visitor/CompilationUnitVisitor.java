package com.example.hans_antlr4.parsing.biz_visitor;

import com.example.hans_antlr4.bytecode_gen.CompilationUnit;
import com.example.hans_antlr4.domain.global.MetaData;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.parsing.HansAntlrBaseVisitor;
import com.example.hans_antlr4.parsing.HansAntlrParser;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class CompilationUnitVisitor extends HansAntlrBaseVisitor<CompilationUnit> {
    @Override
    public CompilationUnit visitCompilationUnit(HansAntlrParser.CompilationUnitContext ctx) {
        Scope scope = new Scope(new MetaData(null));
        StatementVisitor statementVisitor = new StatementVisitor(scope);
        ctx.statements().accept(statementVisitor);
        return new CompilationUnit(scope, statementVisitor.getInstructionsQueue());
    }
}
