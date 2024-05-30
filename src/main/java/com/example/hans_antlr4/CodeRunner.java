package com.example.hans_antlr4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.example.hans_antlr4.exception.ExceptionUtil;
import com.example.hans_antlr4.exception.HantRuntimeException;

class MyClassLoader extends ClassLoader {
    public Class<?> myDefineClass(byte[] arg1, int arg2, int arg3) {
        return super.defineClass(null, arg1, arg2, arg3);
    }
}

public class CodeRunner {
    public static void run(byte[] byteCode, String fileAbsolutePath, String[] args) {
        MyClassLoader cl = new MyClassLoader();
        Class<?> cls = cl.myDefineClass(byteCode, 0, byteCode.length);
        try {
            Method mainMethod = cls.getDeclaredMethod("main", String[].class);
            mainMethod.invoke(null, (Object) args);
        } catch (InvocationTargetException e) {
            throw new HantRuntimeException(
                    ExceptionUtil.getWrappedExceptionMessage(fileAbsolutePath, e.getTargetException()),
                    e.getTargetException());
        } catch (Exception e) {
            throw new HantRuntimeException(
                    ExceptionUtil.getWrappedExceptionMessage(fileAbsolutePath, e), e);
        }
    }
}
