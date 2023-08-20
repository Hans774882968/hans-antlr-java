package com.example.hans_antlr4.bytecode_gen.statement;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.Block;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BlockStatementGenerator implements Opcodes {
    private MethodVisitor mv;

    public void generate(Block blockStatement) {
        Scope newScope = blockStatement.getScope();
        StatementGenerator statementGenerator = new StatementGenerator(mv, newScope);
        blockStatement.getStatements().forEach(stmt -> stmt.accept(statementGenerator));
    }
}
