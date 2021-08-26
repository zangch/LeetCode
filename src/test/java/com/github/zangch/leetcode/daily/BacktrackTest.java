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
        System.out.println(backtrack.combinationSum(new int[]{1,2,4,1,3,4}, 8));
    }
    @Test
    void combinationSum2() {
        System.out.println(backtrack.combinationSum2(new int[]{1,2,4,1,3,4}, 8));
    }
    @Test
    void combine() {
        System.out.println(backtrack.combine(5,3));
    }
    @Test
    void subsets() {
        System.out.println(backtrack.subsets(new int[]{0,1,2}));
    }
    @Test
    void permute() {
        System.out.println(backtrack.permute(new int[]{0,1,2}));
    }
    @Test
    void permuteUnique() {
        System.out.println(backtrack.permuteUnique(new int[]{0,2,1,0,0}));
    }
    @Test
    void subsetXORSum() {
        System.out.println(backtrack.subsetXORSum(new int[]{5,1,6}));
    }
    @Test
    void generateParenthesis() {
        System.out.println(backtrack.generateParenthesis(3));
    }
}