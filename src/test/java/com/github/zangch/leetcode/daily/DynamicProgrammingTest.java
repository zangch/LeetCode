package com.github.zangch.leetcode.daily;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
    @Test
    void numDecodings() {
        System.out.println(dynamicProgramming.numDecodings("1"));
    }
    @Test
    void minSteps() {
        System.out.println(dynamicProgramming.minSteps(1000));
    }
    @Test
    void maxProduct() {
        System.out.println(dynamicProgramming.maxProduct(new int[]{-3,3,2,0,5}));
    }
    @Test
    void minimumTotal() {
        System.out.println(dynamicProgramming.minimumTotal(new ArrayList<>(1)));
    }
    @Test
    void minDistance() {
        System.out.println(dynamicProgramming.minDistance("horse", "ros"));
    }
    @Test
    void longestPalindrome() {
        System.out.println(dynamicProgramming.longestPalindrome("cc"));
    }
    @Test
    void rob() {
        System.out.println(dynamicProgramming.rob(new int[]{1,2,3,5,2,1,3}));
    }
    @Test
    void robII() {
        System.out.println(dynamicProgramming.robII(new int[]{1,2,3,5,2,1,3}));
    }
    @Test
    void integerBreak() {
        System.out.println(dynamicProgramming.integerBreak(13));
    }
    @Test
    void nthSuperUglyNumber() {
        System.out.println(dynamicProgramming.nthSuperUglyNumber(9, new int[]{2,3,5}));
    }
    @Test
    void integerReplacement() {
        System.out.println(dynamicProgramming.integerReplacement(Integer.MAX_VALUE));
    }
}