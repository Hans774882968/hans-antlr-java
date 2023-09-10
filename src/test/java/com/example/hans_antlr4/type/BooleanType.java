package com.example.hans_antlr4.type;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.inOrder;

import java.util.List;

import org.junit.Test;
import org.mockito.InOrder;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.TestUtils;
import com.example.hans_antlr4.domain.global.MetaData;
import com.example.hans_antlr4.domain.scope.LocalVariable;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.exception.func.MainMethodNotFoundInPublicClass;

public class BooleanType implements Opcodes {
    @Test
    public void booleanVarDefinition() throws MainMethodNotFoundInPublicClass {
        List<Statement> statements = TestUtils.getStatementsFromCode(
                "var tmpB1 = true\nvar tmpB2 = false");
        Scope scope = new Scope(new MetaData(null));
        scope.addLocalVariables(
                new LocalVariable("tmpB1", BuiltInType.BOOLEAN),
                new LocalVariable("tmpB2", BuiltInType.BOOLEAN));
        MethodVisitor mv = TestUtils.mockGenerateBytecode(statements, scope);
        InOrder inOrder = inOrder(mv);

        inOrder.verify(mv).visitLdcInsn(eq(true));
        inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(0));
        inOrder.verify(mv).visitLdcInsn(eq(false));
        inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(1));
    }
}
