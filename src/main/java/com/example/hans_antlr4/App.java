package com.example.hans_antlr4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.lang3.StringUtils;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import com.example.hans_antlr4.bytecode_gen.CompilationUnit;
import com.example.hans_antlr4.parsing.ParseEntry;
import com.example.hans_antlr4.program_arguments.CompilerArguments;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    private static CompilerArguments compilerArguments = new CompilerArguments();

    private static void saveBytecodeToClassFile(String fileAbsolutePath, byte[] byteCode) throws IOException {
        final String classFile = StringUtils.replace(fileAbsolutePath, ".hant", ".class");
        @Cleanup
        OutputStream os = new FileOutputStream(classFile);
        os.write(byteCode);
    }

    private static void runClass(byte[] byteCode) {
        CodeRunner.run(byteCode);
    }

    public static void main(String[] args) {
        JCommander commander = JCommander.newBuilder()
                .programName("hant-compiler (java -jar <hant-compiler-jar-path>)")
                .addObject(compilerArguments)
                .build();
        try {
            commander.parse(args);
        } catch (ParameterException e) {
            if (e.getMessage().contains("The following option is required:")) {
                e.usage();
                System.exit(114514);
            } else {
                throw e;
            }
        }
        if (compilerArguments.isHelp()) {
            commander.usage();
            return;
        }

        String inputFilePath = compilerArguments.getFilePath();
        File hantFile = new File(inputFilePath);
        String fileName = hantFile.getName();
        String fileAbsolutePath = hantFile.getAbsolutePath();
        log.info("trying to parse hant file \"{}\" ...", fileAbsolutePath);
        CompilationUnit compilationUnit = null;
        try {
            compilationUnit = ParseEntry.parseFromFilePath(fileAbsolutePath);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        final byte[] byteCode = compilationUnit.generateBytecode(StringUtils.remove(fileName, ".hant"));

        try {
            if (compilerArguments.isRunMode()) {
                runClass(byteCode);
            } else {
                saveBytecodeToClassFile(fileAbsolutePath, byteCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
