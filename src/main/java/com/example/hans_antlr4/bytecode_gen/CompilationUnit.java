package com.example.hans_antlr4.bytecode_gen;

import java.util.Queue;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.bytecode_gen.statement.StatementGenerator;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.Statement;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompilationUnit implements Opcodes {
    private Scope scope;
    private Queue<Statement> instructionsQueue;

    public byte[] generateBytecode(String name) {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        MethodVisitor mv;
        // version, access, name, signature, base class, interfaces
        cw.visit(52, ACC_PUBLIC + ACC_SUPER, name, null, "java/lang/Object", null);
        {
            // declare static void main
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);

            StatementGenerator statementGenerator = new StatementGenerator(mv, scope);
            // apply instructions generated from traversing parse tree!
            for (Statement instruction : instructionsQueue) {
                instruction.accept(statementGenerator);
            }
            mv.visitInsn(RETURN); // add return instruction

            mv.visitMaxs(-1, -1); // set max stack and max local variables
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}
