package com.github.zangch.leetcode.daily;

import org.junit.jupiter.api.Test;

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
}