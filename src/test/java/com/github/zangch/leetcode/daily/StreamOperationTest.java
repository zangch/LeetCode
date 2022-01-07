package com.github.zangch.leetcode.daily;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author: zangch
 * @describe:
 * @date: 2021-08-23
 */
class StreamOperationTest {
    private final StreamOperation streamOperation = new StreamOperation();
    @Test
    void escapeGhosts() {
        System.out.println(streamOperation.escapeGhosts(new int[][]{{1,2},{0,1}}, new int[]{1,1}));
    }
    @Test
    void xorQueries() {
        System.out.println(Arrays.toString(streamOperation.xorQueries(new int[]{1,1,2,4}, new int[][]{{1,2}, {0,1}})));
    }
    @Test
    void numberOfBoomerangs() {
        System.out.println(streamOperation.numberOfBoomerangs(new int[][]{{0,0},{0,1},{1,0},{-1,0},{0,-1}}));
    }
    @Test
    void findLongestWord() {
        System.out.println(streamOperation.findLongestWord("abc", Arrays.asList("c","b","a")));
    }
    @Test
    void firstMissingPositive() {
        System.out.println(streamOperation.firstMissingPositive(new int[]{-1,1,4}));
    }
    @Test
    void divide() {
        System.out.println(streamOperation.divide(2, -3));
    }
    @Test
    void countAndSay() {
        System.out.println(streamOperation.countAndSay(8));
    }
    @Test
    void nextGreaterElement() {
        System.out.println(Arrays.toString(streamOperation.nextGreaterElement(new int[]{8,4,1,5,9}, new int[]{8,6,4,2,1,3,5,7,9})));
    }
    @Test
    void find132pattern() {
        System.out.println(streamOperation.find132pattern(new int[]{1,2,4,3}));
    }
    @Test
    void poorPigs() {
        System.out.println(streamOperation.poorPigs(4, 15, 30));
    }
    @Test
    void findNthDigit() {
        System.out.println(streamOperation.findNthDigit(13));
    }
    @Test
    void wiggleMaxLength() {
        System.out.println(streamOperation.wiggleMaxLength(new int[]{1,1,7,4,9,2,5}));
    }
}