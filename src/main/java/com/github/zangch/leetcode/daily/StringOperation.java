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
    /**
     * @author: zangch
     * @describe: 187. 重复的DNA序列
     * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
     * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
     * @date: 2021-10-08
     */
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 11) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        Map<String, Integer> current = new HashMap<>();
        for (int i = 0 ; i < s.length() - 10 ; i++) {
            String DNA = s.substring(i, i + 10);
            current.put(DNA, current.getOrDefault(DNA, 0) + 1);
            if (current.get(DNA) == 2) {
                result.add(DNA);
            }
        }
        return result;
    }
    /**
     * @author: zangch
     * @describe: 352. 将数据流变为多个不相交区间
     *  给你一个由非负整数 a1, a2, ..., an 组成的数据流输入，请你将到目前为止看到的数字总结为不相交的区间列表。
     * 实现 SummaryRanges 类：
     * SummaryRanges() 使用一个空数据流初始化对象。
     * void addNum(int val) 向数据流中加入整数 val 。
     * int[][] getIntervals() 以不相交区间 [starti, endi] 的列表形式返回对数据流中整数的总结。
     * @date: 2021-10-09
     */
    public void addNum(int val) {
    }
    /**
     * @author: zangch
     * @describe: 299. 猜数字游戏
     * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
     *
     * 写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，你就会给他一个包含下述信息的提示：
     *
     * 猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls", 公牛），
     * 有多少位属于数字猜对了但是位置不对（称为 "Cows", 奶牛）。也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
     * 给你一个秘密数字 secret 和朋友猜测的数字 guess ，请你返回对朋友这次猜测的提示。
     *
     * 提示的格式为 "xAyB" ，x 是公牛个数， y 是奶牛个数，A 表示公牛，B 表示奶牛。
     *
     * 请注意秘密数字和朋友猜测的数字都可能含有重复数字。
     * @date: 2021-11-08
     */
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        Map<Character, Integer> secretMap = new HashMap<>(), guessMap = new HashMap<>();
        for (int i = 0 ; i < secret.length() ; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            }
            secretMap.put(secret.charAt(i), secretMap.getOrDefault(secret.charAt(i), 0) + 1);
            guessMap.put(guess.charAt(i), guessMap.getOrDefault(guess.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : secretMap.entrySet()) {
            cows += Math.min(entry.getValue(), guessMap.getOrDefault(entry.getKey(), 0));
        }
        return bulls + "A" + (cows - bulls) + "B";
    }
    /**
     * @author: zangch
     * @describe: 488. 祖玛游戏
     * 你正在参与祖玛游戏的一个变种。
     *
     * 在这个祖玛游戏变体中，桌面上有 一排 彩球，每个球的颜色可能是：红色 'R'、黄色 'Y'、蓝色 'B'、绿色 'G' 或白色 'W' 。你的手中也有一些彩球。
     *
     * 你的目标是 清空 桌面上所有的球。每一回合：
     *
     * 从你手上的彩球中选出 任意一颗 ，然后将其插入桌面上那一排球中：两球之间或这一排球的任一端。
     * 接着，如果有出现 三个或者三个以上 且 颜色相同 的球相连的话，就把它们移除掉。
     * 如果这种移除操作同样导致出现三个或者三个以上且颜色相同的球相连，则可以继续移除这些球，直到不再满足移除条件。
     * 如果桌面上所有球都被移除，则认为你赢得本场游戏。
     * 重复这个过程，直到你赢了游戏或者手中没有更多的球。
     * 给你一个字符串 board ，表示桌面上最开始的那排球。另给你一个字符串 hand ，表示手里的彩球。请你按上述操作步骤移除掉桌上所有球，计算并返回所需的 最少 球数。如果不能移除桌上所有的球，返回 -1 。
     * @date: 2021-11-09
     */
    public int findMinStep(String board, String hand) {
        if (hand.length() == 0) {
            return -1;
        }
        int result = 0;
        for (int i = 0 ; i < board.length() ; i++) {
            if (i != 0 && board.charAt(i) == hand.charAt(0) && board.charAt(i) == board.charAt(i - 1)) {
                String current = board.substring(0, i - 1) + board.substring(i + 1);
                remove: while (true) {
                    int count = 1;
                    char c = current.charAt(0);
                    for (int j = 1 ; j < current.length() ; j++) {
                        if (current.charAt(j) == c) {
                            count++;
                            if (count == 3) {
                                if (j != current.length() - 1 && current.charAt(j) == current.charAt(j + 1)) {
                                    current = board.substring(0, j - 2) + board.substring(j + 2);
                                    continue remove;
                                }
                                current = board.substring(0, j - 2) + board.substring(j + 1);
                                continue remove;
                            }
                        } else {
                            c = current.charAt(j);
                            count = 1;
                        }
                    }
                    break ;
                }
                result = findMinStep(current, hand.substring(1)) + 1;
            }
        }
        return result;
    }
    /**
     * @author: zangch
     * @describe: 1392. 最长快乐前缀
     * 「快乐前缀」是在原字符串中既是 非空 前缀也是后缀（不包括原字符串自身）的字符串。
     *
     * 给你一个字符串 s，请你返回它的 最长快乐前缀。
     *
     * 如果不存在满足题意的前缀，则返回一个空字符串。
     * @date: 2021-11-16
     */
    public String longestPrefix(String s) {
        String result = "";
        for (int i = 0 ; i < s.length() - 1; i++) {
            if (s.substring(0, i + 1).equals(s.substring(s.length() - i - 1))) {
                result = s.substring(0, i + 1);
            }
        }
        return result;
    }
    /**
     * @author: zangch
     * @describe: 318. 最大单词长度乘积
     * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
     * @date: 2021-11-17
     */
    public int maxProduct(String[] words) {
        int result = 0;
        boolean[][] letter = new boolean[words.length][26];
        for (int i = 0 ; i < words.length ; i++) {
            for (char c : words[i].toCharArray()) {
                int cNum = c - 'a';
                letter[i][cNum] = true;
            }
        }
        for (int i = 0 ; i < words.length ; i++) {
            f : for (int j = i + 1 ; j < words.length ; j++) {
                for (int k = 0 ; k < 26 ; k++) {
                    if (letter[i][k] & letter[j][k])
                        continue f;
                }
                result = Math.max(result, words[i].length() * words[j].length());
            }
        }
        return result;
    }
    /**
     * @author: zangch
     * @describe: 794. 有效的井字游戏
     * 给你一个字符串数组 board 表示井字游戏的棋盘。当且仅当在井字游戏过程中，棋盘有可能达到 board 所显示的状态时，才返回 true 。
     *
     * 井字游戏的棋盘是一个 3 x 3 数组，由字符 ' '，'X' 和 'O' 组成。字符 ' ' 代表一个空位。
     *
     * 以下是井字游戏的规则：
     *
     * 玩家轮流将字符放入空位（' '）中。
     * 玩家 1 总是放字符 'X' ，而玩家 2 总是放字符 'O' 。
     * 'X' 和 'O' 只允许放置在空位中，不允许对已放有字符的位置进行填充。
     * 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
     * 当所有位置非空时，也算为游戏结束。
     * 如果游戏结束，玩家不允许再放置字符。
     * @date: 2021-12-09
     */
    public boolean validTicTacToe(String[] board) {
        return true;
    }
    /**
     * @author: zangch
     * @describe: 686. 重复叠加字符串匹配
     * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
     *
     * 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
     *
     * @date: 2021-12-22
     */
    public int repeatedStringMatch(String a, String b) {
        int current, repeated = 0;
        StringBuilder h = new StringBuilder();
        while (h.length() > b.length() && ++repeated > 0)
            h.append(a);
        current = sunday(h.toString(), b);
//        current = h.indexOf(b);
        return current == -1 ? current : (current + b.length() > a.length() * repeated ? repeated + 1 : repeated);
    }
    /**
     * @author: zangch
     * @describe: 字符串匹配 sunday 算法
     * @date: 2021-12-22
     */
    private int sunday(String haystack, String needle ) {
        int nl = needle.length(), hl = haystack.length(),i = 0, j = 0;
        Map<Character, Integer> shift = new HashMap<>();
        for (int k = 0; k < nl; k++) {
            shift.put(needle.charAt(k), nl -k);
        }
        while (i <= hl - nl) {
            while(j < nl && haystack.charAt(i + j) == needle.charAt(j))
                j++;
            if (j == nl) {
                return i;
            } else {
                j = 0;
            }
            if (i < hl -nl) {
                i += shift.getOrDefault(haystack.charAt(i + nl), nl);
            } else {
                break;
            }
        }
        return -1;
    }

    /**
     * Code shared by String and StringBuffer to do searches. The
     * source is the character array being searched, and the target
     * is the string being searched for.
     *
     * @param   source       the characters being searched.
     * @param   sourceOffset offset of the source string.
     * @param   sourceCount  count of the source string.
     * @param   target       the characters being searched for.
     * @param   targetOffset offset of the target string.
     * @param   targetCount  count of the target string.
     * @param   fromIndex    the index to begin searching from.
     */
    static int indexOf(char[] source, int sourceOffset, int sourceCount,
                       char[] target, int targetOffset, int targetCount,
                       int fromIndex) {
        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }

        char first = target[targetOffset];
        int max = sourceOffset + (sourceCount - targetCount);

        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j]
                        == target[k]; j++, k++);

                if (j == end) {
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }
    /**
     * @author: zangch
     * @describe: 1044. 最长重复子串
     * 给你一个字符串 s ，考虑其所有 重复子串 ：即，s 的连续子串，在 s 中出现 2 次或更多次。这些出现之间可能存在重叠。
     *
     * 返回 任意一个 可能具有最长长度的重复子串。如果 s 不含重复子串，那么答案为 "" 。
     * @date: 2021-12-23
     */
    public String longestDupSubstring(String s) {
        String dup = "";
        for (int i = 0; i < s.length() - 1; i++) {
            int j = s.length();
            while (i < --j) {
                if (j - i <= dup.length()) {
                    break;
                } else if (s.indexOf(s.substring(i, j), i + 1) != -1) {
                    dup = s.substring(i, j);
                    break;
                }
            }
        }
        return dup;
    }
    /**
     * @author: zangch
     * @describe: 71. 简化路径
     * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
     *
     * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
     *
     * 请注意，返回的 规范路径 必须遵循下述格式：
     *
     * 始终以斜杠 '/' 开头。
     * 两个目录名之间必须只有一个斜杠 '/' 。
     * 最后一个目录名（如果存在）不能 以 '/' 结尾。
     * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
     * 返回简化后得到的 规范路径 。
     * @date: 2022-01-06
     */
    public String simplifyPath(String path) {
        int count = 0;
        StringBuilder simply = new StringBuilder();
        List<String> directories = new ArrayList<>();
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) != '/' && (path.charAt(i) != '.' || (i != path.length() - 1 && path.charAt(i + 1) != '/'))) {
                int j = i;
                StringBuilder directory = new StringBuilder();
                while (j < path.length()) {
                    if (path.charAt(j) == '/') {
                        break;
                    }
                    directory.append(path.charAt(j++));
                }
                i = j;
                directories.add(directory.toString());
            }
        }
        for (int i = directories.size() - 1; i >= 0; i--) {
            if (directories.get(i).equals("..")) {
                count++;
            } else if (count != 0) {
                count--;
            } else {
                simply.insert(0, "/" + directories.get(i));
            }
        }
        return simply.length() == 0 ? "/" : simply.toString();
    }
}
