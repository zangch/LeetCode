package com.github.zangch.leetcode.daily;


import java.util.*;

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
    /**
     * @author: zangch
     * @describe: 1705. 吃苹果的最大数目
     * 有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。在第 i 天，树上会长出 apples[i] 个苹果，这些苹果将会在 days[i] 天后（也就是说，第 i + days[i] 天时）腐烂，变得无法食用。也可能有那么几天，树上不会长出新的苹果，此时用 apples[i] == 0 且 days[i] == 0 表示。
     *
     * 你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。
     *
     * 给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。
     * @date: 2021-12-24
     */
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> canEat = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        int eat = 0;
        for (int i = 0; i < apples.length || !canEat.isEmpty(); i++) {
            if (i < apples.length  && apples[i] != 0) {
                canEat.add(new int[]{i + days[i], apples[i]});
            }
            while(!canEat.isEmpty()) {
                int[] current = canEat.poll();
                if (current[0] > i) {
                    if (current[1] > 1) {
                        canEat.add(new int[]{current[0], current[1] -1});
                    }
                    eat++;
                    break;
                }
            }
        }
        return eat;
    }
    /**
     * @author: zangch
     * @describe: 给定一个长度为 n 的可能有重复值的数组，找出其中不去重的最小的 k 个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4(任意顺序皆可)。
     * 数据范围：0\le k,n \le 100000≤k,n≤10000，数组中每个数的大小0 \le val \le 10000≤val≤1000
     * 要求：空间复杂度 O(n)O(n) ，时间复杂度 O(nlogn)O(nlogn)
     * @date: 2021-12-29
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> cur = new PriorityQueue<>();
        for (int i : input) {
            cur.add(i);
        }
        while (k-- > 0) {
            result.add(cur.poll());
        }
        return result;
    }
    /**
     * @author: zangch
     * @describe: 846. 一手顺子
     * Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。
     *
     * 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。如果她可能重新排列这些牌，返回 true ；否则，返回 false 。
     * @date: 2021-12-30
     */
    public boolean isNStraightHand(int[] hand, int groupSize) {
        return false;
    }
    /**
     * @author: zangch
     * @describe: 913. 猫和老鼠 👎
     * 两位玩家分别扮演猫和老鼠，在一张 无向 图上进行游戏，两人轮流行动。
     *
     * 图的形式是：graph[a] 是一个列表，由满足 ab 是图中的一条边的所有节点 b 组成。
     *
     * 老鼠从节点 1 开始，第一个出发；猫从节点 2 开始，第二个出发。在节点 0 处有一个洞。
     *
     * 在每个玩家的行动中，他们 必须 沿着图中与所在当前位置连通的一条边移动。例如，如果老鼠在节点 1 ，那么它必须移动到 graph[1] 中的任一节点。
     *
     * 此外，猫无法移动到洞中（节点 0）。
     *
     * 然后，游戏在出现以下三种情形之一时结束：
     *
     * 如果猫和老鼠出现在同一个节点，猫获胜。
     * 如果老鼠到达洞中，老鼠获胜。
     * 如果某一位置重复出现（即，玩家的位置和移动顺序都与上一次行动相同），游戏平局。
     * 给你一张图 graph ，并假设两位玩家都都以最佳状态参与游戏：
     *
     * 如果老鼠获胜，则返回 1；
     * 如果猫获胜，则返回 2；
     * 如果平局，则返回 0 。
     * @date: 2022-01-04
     */
    public int catMouseGame(int[][] graph) {
        int[][][] dp = new int[2 * 50 * 50][50][50];
        for (int i = 0; i < 5000; i++) {
            for (int j = 0; j < 50; j++) {
                for (int k = 0; k < 50; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return catMouseGameDFS(dp, graph, 0, 1, 2);
    }
    private int catMouseGameDFS(int[][][] dp, int[][] g, int t, int m, int c) {
        int game = dp[t][m][c];
        if (m == 0) game = 1;
        if (m == c) game =  2;
        if (t > 2 * g.length * g.length) game = 0;
        if (game == -1) {
            if (t % 2 == 0) { // mouse
                boolean draw = false, win = false;
                for (int x : g[m]) {
                    int k = catMouseGameDFS(dp, g, t + 1, x, c);
                    if (k == 1) win = true;
                    if (k == 0) draw = true;
                    if (win) break;
                }
                if (win) game = 1;
                else if (draw) game = 0;
                else game = 2;
            } else { // cat
                boolean draw = false, win = false;
                for (int x : g[c]) {
                    if (x == 0) continue;
                    int k = catMouseGameDFS(dp, g, t + 1, m, x);
                    if (k == 2) win = true;
                    if (k == 0) draw = true;
                    if (win) break;
                }
                if (win) game = 2;
                else if (draw) game = 0;
                else game = 1;
            }
        }
        dp[t][m][c] = game;
        return game;
    }

}
