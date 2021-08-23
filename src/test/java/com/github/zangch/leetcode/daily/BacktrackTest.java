package com.github.zangch.leetcode.daily;

import org.junit.jupiter.api.Test;

/**
 * @author: zangch
 * @describe:
 */
class BacktrackTest {
    private final Backtrack backtrack = new Backtrack();
    @Test
    void countArrangement() {
        System.out.println(backtrack.countArrangement(6));
    }
    @Test
    void letterCombinations() {
        System.out.println(backtrack.letterCombinations("234"));
    }
    @Test
    void combinationSum() {
        System.out.println(backtrack.combinationSum(new int[]{1,2,4,1,3,4}, 8).toString());
    }
    @Test
    void combinationSum2() {
        System.out.println(backtrack.combinationSum2(new int[]{1,2,4,1,3,4}, 8).toString());
    }
}