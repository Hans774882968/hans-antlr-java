package com.example.hans_antlr4;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Test;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.domain.statement.Statement;

public class HantBlockTest {
    @Test
    public void confirmNewScopeCreatedTest() {
        // 因为全局的 Scope 是 cglib mock 出来的，所以我们就不测有“全局变量”的情况了， hant_examples/block.hant cover 到就行
        List<Statement> statements = TestUtils.getStatementsFromCode(
                "{ { var x = 10 } var x = 20 { var x = 30 { var y = 40 } { var y = 50 print x + y } } var y = 60 print x + y }");
        MethodVisitor mv = TestUtils.mockGenerateBytecode(statements);

        int[] vals = { 10, 20, 30, 40, 50, 60 };
        for (int v : vals) {
            verify(mv, times(1)).visitIntInsn(eq(Opcodes.BIPUSH), eq(v));
        }
        verify(mv, times(2)).visitVarInsn(eq(Opcodes.ISTORE), eq(0));
        verify(mv, times(2)).visitVarInsn(eq(Opcodes.ISTORE), eq(1));
        verify(mv, times(2)).visitVarInsn(eq(Opcodes.ISTORE), eq(2));
        verify(mv, times(0)).visitVarInsn(eq(Opcodes.ISTORE), eq(3));
    }
}
