package com.example.hans_antlr4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.lang3.StringUtils;

import com.example.hans_antlr4.bytecode_gen.CompilationUnit;
import com.example.hans_antlr4.parsing.ParseEntry;
import com.example.hans_antlr4.validation.ARGUMENT_ERRORS;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    private static boolean runMode = false;

    private static ARGUMENT_ERRORS getArgumentValidationError(String[] args) {
        if ((runMode && args.length != 2) || (!runMode && args.length != 1)) {
            return ARGUMENT_ERRORS.NO_FILE;
        }
        String filePath = runMode ? args[1] : args[0];
        if (!filePath.endsWith(".hant")) {
            return ARGUMENT_ERRORS.BAD_FILE_EXTENSION;
        }
        return ARGUMENT_ERRORS.NONE;
    }

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
        runMode = args[0].equals("run");
        ARGUMENT_ERRORS argumentError = getArgumentValidationError(args);
        if (argumentError != ARGUMENT_ERRORS.NONE) {
            log.error(argumentError.getMessage());
            return;
        }

        String inputFilePath = runMode ? args[1] : args[0];
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
            if (runMode) {
                runClass(byteCode);
            } else {
                saveBytecodeToClassFile(fileAbsolutePath, byteCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
