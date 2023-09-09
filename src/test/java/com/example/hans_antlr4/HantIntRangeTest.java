package com.example.hans_antlr4;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.bytecode_gen.statement.StatementGenerator;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.exception.func.MainMethodNotFoundInPublicClass;

public class HantIntRangeTest {
    public void intRangeTestTemplate(String code, int intValue, int bipushTimes, int sipushTimes, int ldcTimes)
            throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getFirstStatementFromCode(code);

        MethodVisitor mv = mock(MethodVisitor.class);
        Scope scope = mock(Scope.class);
        StatementGenerator statementGenerator = new StatementGenerator(mv, scope);

        statement.accept(statementGenerator);
        verify(mv, times(bipushTimes)).visitIntInsn(Opcodes.BIPUSH, intValue);
        verify(mv, times(sipushTimes)).visitIntInsn(Opcodes.SIPUSH, intValue);
        verify(mv, times(ldcTimes)).visitLdcInsn(intValue);
    }

    @Test
    public void intRangeTests() throws MainMethodNotFoundInPublicClass {
        intRangeTestTemplate("var v1 = 127", 127, 1, 0, 0);
        intRangeTestTemplate("var v2 = 128", 128, 0, 1, 0);
        intRangeTestTemplate("var v3 = 32767", 32767, 0, 1, 0);
        intRangeTestTemplate("var v4 = 32768", 32768, 0, 0, 1);
    }
}
