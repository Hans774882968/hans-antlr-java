package com.example.hans_antlr4.blackbox_tests;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.example.hans_antlr4.TestUtils;

public class HantBlackBoxMostExamplesTest {
    @Test
    public void runMostExamples() throws IOException {
        // 跳过期望编译不能通过的文件和需要用户输入的文件
        List<String> excludedFiles = Arrays.asList(
                "hant_examples\\for\\outside_loop_break.hant",
                "hant_examples\\for\\outside_loop_continue.hant",
                "hant_examples\\type\\arithmetic_invalid_type.hant",
                "hant_examples\\type\\bitwise_invalid_type.hant",
                "hant_examples\\type\\incompatible.hant",
                "hant_examples\\type\\shift_invalid_type.hant",
                "hant_examples\\object\\stdin_double.hant",
                "hant_examples\\acm_and_leetcode\\hdu4746.hant");

        Path path = Paths.get("hant_examples");
        Files.walkFileTree(path, new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                String strFilePath = file.toString();
                if (!strFilePath.endsWith(".hant") || excludedFiles.stream().anyMatch(f -> strFilePath.contains(f))) {
                    return FileVisitResult.CONTINUE;
                }
                TestUtils.runBlackBox(strFilePath);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
