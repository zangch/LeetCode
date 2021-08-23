package com.github.zangch.leetcode.daily;

import org.junit.jupiter.api.Test;

/**
 * @author: zangch
 * @describe:
 */
class DynamicProgrammingTest {
    private final DynamicProgramming dynamicProgramming = new DynamicProgramming();
    @Test
    void numberOfArithmeticSlices() {
        System.out.println(dynamicProgramming.numberOfArithmeticSlices(new int[]{1,2,3,4}));
    }
    @Test
    void numberOfArithmeticSlicesII() {
        System.out.println(dynamicProgramming.numberOfArithmeticSlicesII(new int[]{1,5,9,2,13,3,4}));
    }
    @Test
    void longestPalindromeSubseq() {
        System.out.println(dynamicProgramming.longestPalindromeSubseq("honorificabilitudinitatibus"));
    }
    @Test
    void countDigitOne() {
        System.out.println(dynamicProgramming.countDigitOne(19999));
    }
    @Test
    void checkRecord() {
        System.out.println(dynamicProgramming.checkRecord(999));
    }
}