package com.example.hans_antlr4.exception;

public class ExceptionUtil {
    public static String getWrappedExceptionMessage(String fileAbsolutePath, Throwable e) {
        return "[" + fileAbsolutePath + "] " + e.getMessage();
    }
}
