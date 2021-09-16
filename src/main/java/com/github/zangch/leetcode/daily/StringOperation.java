package com.github.zangch.leetcode.daily;

import java.util.*;

/**
 * @author: zangch
 * @describe: 字符串操作
 */
public class StringOperation {
    /**
     * @author: zangch
     * @describe: 165. 比较版本号
     * 给你两个版本号 version1 和 version2 ，请你比较它们。
     * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
     * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
     * 返回规则如下：
     * 如果 version1 > version2 返回 1，
     * 如果 version1 < version2 返回 -1，
     * 除此之外返回 0。
     * @date: 2021-09-01
     */
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\."), v2 = version2.split("\\.");
        for (int i = 0 ; i < v1.length || i < v2.length ; i++) {
            if (((i < v1.length) ? Integer.parseInt(v1[i]) : 0) > ((i < v2.length) ? Integer.parseInt(v2[i]) : 0)) {
                return 1;
            } else if(((i < v1.length) ? Integer.parseInt(v1[i]) : 0) < ((i < v2.length) ? Integer.parseInt(v2[i]) : 0)) {
                return -1;
            }
        }
        return 0;
    }
    /**
     * @author: zangch
     * @describe: LCP 13. 寻宝 🥦
     * 我们得到了一副藏宝图，藏宝图显示，在一个迷宫中存在着未被世人发现的宝藏。
     * 迷宫是一个二维矩阵，用一个字符串数组表示。它标识了唯一的入口（用 'S' 表示），和唯一的宝藏地点（用 'T' 表示）。但是，宝藏被一些隐蔽的机关保护了起来。在地图上有若干个机关点（用 'M' 表示），只有所有机关均被触发，才可以拿到宝藏。
     * 要保持机关的触发，需要把一个重石放在上面。迷宫中有若干个石堆（用 'O' 表示），每个石堆都有无限个足够触发机关的重石。但是由于石头太重，我们一次只能搬一个石头到指定地点。
     * 迷宫中同样有一些墙壁（用 '#' 表示），我们不能走入墙壁。剩余的都是可随意通行的点（用 '.' 表示）。石堆、机关、起点和终点（无论是否能拿到宝藏）也是可以通行的。
     * 我们每步可以选择向上/向下/向左/向右移动一格，并且不能移出迷宫。搬起石头和放下石头不算步数。那么，从起点开始，我们最少需要多少步才能最后拿到宝藏呢？如果无法拿到宝藏，返回 -1 。
     * @date: 2021-09-09
     */
    public int minimalSteps(String[] maze) {
        int mCount = 0;
        for (String m : maze) {
            for (int i = 0 ; i < m.length() ; i++) {
                if (m.charAt(i) == 'M') mCount++;
            }
        }
        int minSteps = 0;
        Integer[] index = new Integer[]{0,0};
        Boolean[][] m = new Boolean[maze.length][maze[0].length()];
        for (Boolean[] mm : m) {
            Arrays.fill(mm, true);
        }
        findIndex('S', index, maze, m);
        while (mCount-- > 0) {
            int mPath = findIndex('M', index, maze, m);
            m[index[0]][index[1]] = true;
            int oPath = findIndex('O', index, maze, m);
            if (mPath == 0 || oPath == 0) {
                return -1;
            }
            minSteps += mPath + oPath;
        }
        int tPath = findIndex('T', index, maze, m);
        if (tPath == 0) {
            return -1;
        }
        return minSteps + tPath;
    }
    private int findIndex(char target, Integer[] index, String[] maze, Boolean[][] m) {
        int path = 0;
        Boolean[][] through = new Boolean[m.length][m[0].length];
        for (int i = 0 ; i < m.length ; i++) {
            System.arraycopy(m[i], 0, through[i], 0, through[0].length);
        }
        through[index[0]][index[1]] = true;
        List<Integer[]> current = Collections.singletonList(index);
        while (current.size() != 0) {
            path++;
            List<Integer[]> next = new ArrayList<>();
            for (Integer[] in : current) {
                if (in[0]+1 < maze.length && !through[in[0]+1][in[1]]) {
                    if (maze[in[0]+1].charAt(in[1]) == target) {
                        return path;
                    } else if (maze[in[0]+1].charAt(in[1]) != '#') {
                        next.add(new Integer[]{in[0] + 1, in[1]});
                    }
                    through[in[0]+1][in[1]] = true;
                }
                if (in[1]+1 < maze.length && !through[in[0]][in[1]+1]) {
                    if (maze[in[0]].charAt(in[1]+1) == target) {
                        return path;
                    } else if (maze[in[0]].charAt(in[1]+1) != '#') {
                        next.add(new Integer[]{in[0], in[1]+1});
                    }
                    through[in[0]][in[1]+1] = true;
                }
                if (in[0]-1 >= 0) {
                    if (maze[in[0]-1].charAt(in[1]) == target && !through[in[0]-1][in[1]]) {
                        return path;
                    } else if (maze[in[0]-1].charAt(in[1]) != '#') {
                        next.add(new Integer[]{in[0]-1, in[1]});
                    }
                    through[in[0]-1][in[1]] = true;
                }
                if (in[1]-1 >= 0) {
                    if (maze[in[0]].charAt(in[1]-1) == target && !through[in[0]][in[1]-1]) {
                        return path;
                    } else if (maze[in[0]].charAt(in[1]-1) != '#') {
                        next.add(new Integer[]{in[0], in[1]-1});
                    }
                    through[in[0]][in[1]-1] = true;
                }
                current = next;
            }
        }
        return path;
    }

}
