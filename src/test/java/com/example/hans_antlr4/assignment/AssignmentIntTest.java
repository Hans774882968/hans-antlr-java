package com.example.hans_antlr4.assignment;

import java.util.List;

import org.junit.Test;
import org.mockito.InOrder;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.inOrder;

import com.example.hans_antlr4.TestUtils;
import com.example.hans_antlr4.domain.global.MetaData;
import com.example.hans_antlr4.domain.scope.LocalVariable;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.type.BuiltInType;

public class AssignmentIntTest implements Opcodes {
    @Test
    public void assignmentIntTest1() {
        List<Statement> statements = TestUtils.getStatementsFromCode(
                "var x = 1\nvar y = 2\ny = (x += 20) * (y += y = (x &= 40))");
        Scope scope = new Scope(new MetaData(null));
        scope.addLocalVariable(new LocalVariable("x", BuiltInType.INT));
        scope.addLocalVariable(new LocalVariable("y", BuiltInType.INT));
        MethodVisitor mv = TestUtils.mockGenerateBytecode(statements, scope);
        InOrder inOrder = inOrder(mv);

        inOrder.verify(mv).visitVarInsn(eq(ILOAD), eq(0));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitIntInsn(eq(BIPUSH), eq(20));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitInsn(eq(IADD));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitInsn(eq(DUP));
        inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(0));
        inOrder.verify(mv).visitInsn(eq(NOP));

        inOrder.verify(mv).visitVarInsn(eq(ILOAD), eq(1));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitVarInsn(eq(ILOAD), eq(0));
        inOrder.verify(mv).visitInsn(eq(NOP));

        inOrder.verify(mv).visitIntInsn(eq(BIPUSH), eq(40));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitInsn(eq(IAND));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitInsn(eq(DUP));
        inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(0));

        inOrder.verify(mv).visitInsn(eq(DUP));
        inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(1));

        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitInsn(eq(IADD));
        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitInsn(eq(DUP));
        inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(1));

        inOrder.verify(mv).visitInsn(eq(NOP));
        inOrder.verify(mv).visitInsn(eq(IMUL));
        inOrder.verify(mv).visitVarInsn(eq(ISTORE), eq(1));
    }
}
