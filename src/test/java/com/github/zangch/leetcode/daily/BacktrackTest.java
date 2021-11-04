package com.github.zangch.leetcode.daily;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
    @Test
    void exist() {
        System.out.println(backtrack.exist(new char[][]{{'a','b'}}, "ab"));
    }
    @Test
    void subsetsWithDup() {
        System.out.println(backtrack.subsetsWithDup(new int[]{1,0,2,0,0}));
    }
    @Test
    void solveSudoku() {
        System.out.println(Arrays.deepToString(backtrack.solveSudoku(new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}})));
    }
    @Test
    void solveNQueens() {
        System.out.println(backtrack.solveNQueens(6));
    }
    @Test
    void restoreIpAddresses() {
        System.out.println(backtrack.restoreIpAddresses("010010"));
    }
    @Test
    void totalNQueens() {
        System.out.println(backtrack.totalNQueens(9));
    }
    @Test
    void findWords() {
        System.out.println(backtrack.findWords(new char[][]{{'a'}}, new String[]{"a"}));
    }
    @Test
    void letterCasePermutation() {
        System.out.println(backtrack.letterCasePermutation("C"));
    }
    @Test
    void reorderedPowerOf2() {
        System.out.println(backtrack.reorderedPowerOf2(1240));
    }
}