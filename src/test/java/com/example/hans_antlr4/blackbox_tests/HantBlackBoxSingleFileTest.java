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
}
