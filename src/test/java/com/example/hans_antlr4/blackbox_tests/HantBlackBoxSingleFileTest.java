package com.example.hans_antlr4.blackbox_tests;

import org.junit.Assert;
import org.junit.Test;

import com.example.hans_antlr4.TestUtils;

import uk.org.webcompere.systemstubs.stream.SystemOut;

public class HantBlackBoxSingleFileTest {
    @Test
    public void piEstimatedValueTest() throws Exception {
        SystemOut systemOut = new SystemOut();
        systemOut.execute(() -> {
            TestUtils.runBlackBox("hant_examples\\acm_and_leetcode\\pi.hant");
        });
        systemOut.getLines().findFirst().ifPresent(v -> {
            Assert.assertTrue(v.startsWith("3.138409"));
        });
    }

    @Test
    public void binarySearchSqrtTest() throws Exception {
        SystemOut systemOut = new SystemOut();
        systemOut.execute(() -> {
            TestUtils.runBlackBox("hant_examples\\acm_and_leetcode\\binary_search_sqrt.hant");
        });
        systemOut.getLines().forEach(v -> {
            Assert.assertTrue(v.startsWith("1.41421356"));
        });
    }

    @Test
    public void equalityExpTest() throws Exception {
        SystemOut systemOut = new SystemOut();
        systemOut.execute(() -> {
            TestUtils.runBlackBox("hant_examples\\if\\equality_exp.hant");
        });
        Assert.assertEquals(
                "10 * 10 == 10 ** 2\n!(100 != 100)\n" +
                        "----- types -----\ntrue true\n" +
                        "----- booleanDemo -----\ntrue false false true\n"
                        + "true false false true\n",
                systemOut.getText().replaceAll("\r\n", "\n"));
    }

    @Test
    public void lc924Test() throws Exception {
        SystemOut systemOut = new SystemOut();
        systemOut.execute(() -> {
            TestUtils.runBlackBox("hant_examples\\acm_and_leetcode\\lc924.hant");
        });
        Assert.assertEquals(
                "0\n0\n1\n2\n0\n1\n3\n",
                systemOut.getText().replaceAll("\r\n", "\n"));
    }
}
