package com.github.zangch.leetcode.daily;


/**
 * @author: zangch
 * @describe:
 * @date: 2021-09-16
 */
public class FirstSearch {
    /**
     * @author: zangch
     * @describe: 994. 腐烂的橘子
     * 在给定的网格中，每个单元格可以有以下三个值之一：
     * 值 0 代表空单元格；
     * 值 1 代表新鲜橘子；
     * 值 2 代表腐烂的橘子。
     * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
     * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
     * @date: 2021-09-16
     */
    public int orangesRotting(int[][] grid) {
        boolean current = false;
        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && (i ==0 || grid[i-1][j] == 0) && (j == 0 || grid[i][j-1] == 0) && (i == grid.length-1 || grid[i+1][j] == 0) && (j == grid[0].length-1 || grid[i][j+1] == 0)) {
                    return -1;
                } else if (grid[i][j] == 1) {
                    current = true;
                }

            }
        }
        if (!current) return 0;
        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0 ; j < grid[0].length ; j++) {
                if (grid[i][j] == 2) {
                    if (i > 0 && grid[i -1][j] == 1) {
                        grid[i -1][j] = 2;
                    }
                    if (j > 0 && grid[i][j -1] == 1) {
                        grid[i][j -1] = 2;
                    }
                    if (i < grid.length -1 && grid[i +1][j] == 1) {
                        grid[i +1][j] = 2;
                    }
                    if (j < grid[0].length -1 && grid[i][j +1] == 1) {
                        grid[i][j +1] = 2;
                    }
                }
            }
        }
        return orangesRotting(grid) +1;
    }
    /**
     * @author: zangch
     * @describe: 36. 有效的数独
     * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
     * 数独部分空格内已填入了数字，空白格用 '.' 表示。
     * 注意：
     * 一个有效的数独（部分已被填充）不一定是可解的。
     * 只需要根据以上规则，验证已经填入的数字是否有效即可。
     * @date: 2021-09-17
     */
    public boolean isValidSudoku(char[][] board) {
        // current[行、列、区域][下标][数字]
        boolean[][][] current = new boolean[3][9][10];
        for (int i = 0 ; i < board.length ; i++) {
            for (int j = 0 ; j < board[0].length ; j++) {
                if (board[i][j] != '.') {
                    if (current[0][i][board[i][j] - '0']) {
                        return false;
                    } else {
                        current[0][i][board[i][j] - '0'] = true;
                    }
                    if (current[1][j][board[i][j] - '0']) {
                        return false;
                    } else {
                        current[1][j][board[i][j] - '0'] = true;
                    }
                    if (current[2][3*(i /3) + (j /3)][board[i][j] - '0']) {
                        return false;
                    } else {
                        current[2][3*(i /3) + (j /3)][board[i][j] - '0'] = true;
                    }
                }
            }
        }
        return true;
    }
}
