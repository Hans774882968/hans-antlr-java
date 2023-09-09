package com.example.hans_antlr4.bytecode_gen;

import java.util.List;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.domain.global.Function;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompilationUnit implements Opcodes {
    private List<Function> functions;

    public byte[] generateBytecode(String publicClassName) {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        // version, access, name, signature, base class, interfaces
        cw.visit(52, ACC_PUBLIC + ACC_SUPER, publicClassName, null, "java/lang/Object", null);

        functions.forEach(function -> new MethodGenerator(cw).generate(function));

        cw.visitEnd();
        return cw.toByteArray();
    }
}
