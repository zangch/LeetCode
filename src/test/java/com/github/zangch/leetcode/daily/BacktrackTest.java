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
        System.out.println(backtrack.combinationSum(new int[]{2,3,4,5,6}, 8).toString());
    }
}