package com.example.hans_antlr4.type;

import org.junit.Assert;
import org.junit.Test;

import com.example.hans_antlr4.TestUtils;
import com.example.hans_antlr4.exception.assignment.AssignmentLhsAndRhsTypeIncompatibleException;
import com.example.hans_antlr4.exception.type.IllegalShiftTypeException;

public class TypeIncompatibleExceptionTest {
    @Test
    public void assignNumericToNumericTest() {
        String[] assignmentExceptionCodes = {
                "var x = 12\nx = 13L\nprint x",
                "var x = 12\nx = 1.4f\nprint x",
                "var x = 12\nx = 1.5\nprint x",
                "var x = 13L\nx = 1.4f\nprint x",
                "var x = 13L\nx = 1.5\nprint x",
                "var x = 1.4f\nx = 1.5\nprint x",
        };
        for (String code : assignmentExceptionCodes) {
            Assert.assertThrows(AssignmentLhsAndRhsTypeIncompatibleException.class, () -> {
                TestUtils.getStatementsFromCode(code);
            });
        }
    }

    @Test
    public void assignNumericToStringTest() {
        String[] assignmentExceptionCodes = {
                "var x = \"str\"\nx = true\nprint x",
                "var x = \"str\"\nx = false\nprint x",
                "var x = \"str\"\nx = 12\nprint x",
                "var x = \"str\"\nx = 12L\nprint x",
                "var x = \"str\"\nx = 1.3f\nprint x",
                "var x = \"str\"\nx = 1.4\nprint x",
        };
        for (String code : assignmentExceptionCodes) {
            Assert.assertThrows(AssignmentLhsAndRhsTypeIncompatibleException.class, () -> {
                TestUtils.getStatementsFromCode(code);
            });
        }
    }

    @Test
    public void assignStringToNumericTest() {
        String[] assignmentExceptionCodes = {
                "var x = 12\nx = \"x\"\nprint x",
                "var x = true\nx = \"str\"\nprint x",
                "var x = \"str\"\nx = false\nprint x",

                "var x = 12\nx **= \"x\"\nprint x",
                "var x = \"x\"\nx **= 12\nprint x",

                "var x = 12\nx *= \"x\"\nprint x",
                "var x = \"x\"\nx *= 12L\nprint x",

                "var x = 12\nx /= \"x\"\nprint x",
                "var x = \"x\"\nx /= 1.7f\nprint x",

                "var x = 12\nx %= \"x\"\nprint x",
                "var x = \"x\"\nx /= 1.8\nprint x",

                "var x = 12\nx += \"x\"\nprint x",
                "var x = 12\nx -= \"x\"\nprint x",
                "var x = 12\nx <<= \"x\"\nprint x",
                "var x = 12\nx >>= \"x\"\nprint x",
                "var x = 12\nx >>>= \"x\"\nprint x",
                "var x = 12\nx &= \"x\"\nprint x",
                "var x = 12\nx |= \"x\"\nprint x",
                "var x = 12\nx ^= \"x\"\nprint x",
        };
        for (String code : assignmentExceptionCodes) {
            Assert.assertThrows(AssignmentLhsAndRhsTypeIncompatibleException.class, () -> {
                TestUtils.getStatementsFromCode(code);
            });
        }
    }

    @Test
    public void invalidShiftTypeExceptionTest() {
        String[] invalidShiftTypeExceptionCodes = {
                "var x = 12\nvar y = 13f\nprint x << y",
                "var x = 12\nvar y = 13d\nprint x >> y",
                "var x = 12\nvar y = \"x\"\nprint x >>> y",
                "var x = 12\nvar y = true\nprint x << y",

                "var x = 13f\nvar y = 12\nprint x >> y",
                "var x = 14d\nvar y = 12\nprint x >>> y",
                "var x = \"x\"\nvar y = 12\nprint x << y",
                "var x = false\nvar y = 12\nprint x >> y",
        };
        for (String code : invalidShiftTypeExceptionCodes) {
            Assert.assertThrows(IllegalShiftTypeException.class, () -> {
                TestUtils.getStatementsFromCode(code);
            });
        }
    }
}
