package com.github.zangch.leetcode.daily;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: zangch
 * @describe:
 * @date: 2021-09-16
 */
class FirstSearchTest {
    private final FirstSearch firstSearch = new FirstSearch();
    @Test
    void orangesRotting() {
        System.out.println(firstSearch.orangesRotting(new int[][]{{1,1,0},{2,0,1},{1,1,1}}));
    }
    @Test
    void isValidSudoku() {
        System.out.println(firstSearch.isValidSudoku(new char[][]{{'1','.'}}));
    }
    @Test
    void eatenApples() {
        System.out.println(firstSearch.eatenApples(new int[]{1,2,3,5,2}, new int[]{3,2,1,4,2}));
    }
    @Test
    void GetLeastNumbers_Solution() {
        System.out.println(firstSearch.GetLeastNumbers_Solution(new int[]{1,2,3}, 2));
    }
    @Test
    void isNStraightHand() {
        System.out.println(firstSearch.isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3));
    }
    @Test
    void catMouseGame() {
        System.out.println(firstSearch.catMouseGame(new int[][]{{8}}));
    }
}