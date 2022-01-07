package com.github.zangch.leetcode.daily;

import org.junit.jupiter.api.Test;

/**
 * @author: zangch
 * @describe:
 * @date: 2021-09-01
 */
class StringOperationTest {
    private final StringOperation stringOperation = new StringOperation();
    @Test
    void compareVersion() {
        System.out.println(stringOperation.compareVersion("1.2.0", "1.1.0.0.0.2"));
    }
    @Test
    void minimalSteps() {
        System.out.println(stringOperation.minimalSteps(new String[]{"S#O", "M..", "M.T"}));
    }
    @Test
    void findRepeatedDnaSequences() {
        System.out.println(stringOperation.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
    @Test
    void getHint() {
        System.out.println(stringOperation.getHint("111111", "111221"));
    }
    @Test
    void longestPrefix() {
        System.out.println(stringOperation.longestPrefix("abababababab"));
    }
    @Test
    void maxProduct() {
        System.out.println(stringOperation.maxProduct(new String[]{"aaaa", "bb", "aab"}));
    }
    @Test
    void repeatedStringMatch() {
        System.out.println(stringOperation.repeatedStringMatch("a", "aa"));
    }
    @Test
    void longestDupSubstring() {
        System.out.println(stringOperation.longestDupSubstring("banana"));
    }
    @Test
    void simplifyPath() {
        System.out.println(stringOperation.simplifyPath("//.../.a/../a/df/s/.."));
    }
}