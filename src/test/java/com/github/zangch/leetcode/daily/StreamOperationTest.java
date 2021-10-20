package com.github.zangch.leetcode.daily;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
}