package com.example.hans_antlr4.bytecode_gen;

import java.util.List;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.domain.global.Function;
import com.example.hans_antlr4.domain.scope.GlobalVariable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompilationUnit implements Opcodes {
    private List<Function> functions;

    public ClassWriter createClassWriter(String publicClassName) {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        // version, access, name, signature, base class, interfaces
        cw.visit(52, ACC_PUBLIC + ACC_SUPER, publicClassName, null, "java/lang/Object", null);
        return cw;
    }

    public void generateGlobalVariableBytecode(ClassWriter cw) {
        functions.stream()
                .filter(func -> func.getFunctionSignature().getName().equals("<clinit>"))
                .findFirst()
                .ifPresent(clinit -> {
                    List<GlobalVariable> globalVariables = clinit.getBody().getScope().getGlobalVariables();
                    globalVariables.forEach(globalVariable -> {
                        String varName = globalVariable.getVarName();
                        String descriptor = globalVariable.getType().getDescriptor();
                        FieldVisitor fieldVisitor = cw.visitField(
                                ACC_PUBLIC | ACC_STATIC, varName, descriptor, null, null);
                        fieldVisitor.visitEnd();
                    });
                });
    }

    public byte[] generateBytecode(String publicClassName) {
        ClassWriter cw = createClassWriter(publicClassName);

        generateGlobalVariableBytecode(cw);

        functions.forEach(function -> new MethodGenerator(cw).generate(function));

        cw.visitEnd();
        return cw.toByteArray();
    }
}
