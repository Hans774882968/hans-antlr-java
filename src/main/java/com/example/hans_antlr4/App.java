package com.example.hans_antlr4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import com.example.hans_antlr4.bytecode_gen.CompilationUnit;
import com.example.hans_antlr4.parsing.ParseEntry;
import com.example.hans_antlr4.program_arguments.CompilerArguments;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    private CompilerArguments compilerArguments = new CompilerArguments();

    private void setLogLevel() {
        Logger logger = (Logger) LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
        Level wantLevel = compilerArguments.isDebug() ? Level.DEBUG : Level.INFO;
        logger.setLevel(wantLevel);
    }

    private void saveBytecodeToClassFile(String fileAbsolutePath, byte[] byteCode) throws IOException {
        final String classFile = StringUtils.replace(fileAbsolutePath, ".hant", ".class");
        @Cleanup
        OutputStream os = new FileOutputStream(classFile);
        os.write(byteCode);
    }

    private void runClass(byte[] byteCode) {
        CodeRunner.run(byteCode);
    }

    public static void main(String[] args) {
        App app = new App();
        JCommander commander = JCommander.newBuilder()
                .programName("hant-compiler (java -jar <hant-compiler-jar-path>)")
                .addObject(app.compilerArguments)
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
        if (app.compilerArguments.isHelp()) {
            commander.usage();
            return;
        }
        app.setLogLevel();

        String inputFilePath = app.compilerArguments.getFilePath();
        File hantFile = new File(inputFilePath);
        String fileName = hantFile.getName();
        String fileAbsolutePath = hantFile.getAbsolutePath();
        log.debug("trying to parse hant file \"{}\" ...", fileAbsolutePath);
        String publicClassName = StringUtils.remove(fileName, ".hant");
        CompilationUnit compilationUnit = null;
        try {
            ParseEntry.publicClassName = publicClassName;
            compilationUnit = ParseEntry.parseFromFilePath(fileAbsolutePath);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        final byte[] byteCode = compilationUnit.generateBytecode(publicClassName);

        try {
            if (app.compilerArguments.isRunMode()) {
                app.runClass(byteCode);
            } else {
                app.saveBytecodeToClassFile(fileAbsolutePath, byteCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
