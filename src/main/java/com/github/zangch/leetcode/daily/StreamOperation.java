package com.github.zangch.leetcode.daily;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author: zangch
 * @describe: 流操作
 */
public class StreamOperation {
    /**
     * @author: zangch
     * @describe: 789. 逃脱阻碍者
     * 你在进行一个简化版的吃豆人游戏。你从 [0, 0] 点开始出发，你的目的地是 target = [xtarget, ytarget] 。地图上有一些阻碍者，以数组 ghosts 给出，第 i 个阻碍者从 ghosts[i] = [xi, yi] 出发。所有输入均为 整数坐标 。
     * 每一回合，你和阻碍者们可以同时向东，西，南，北四个方向移动，每次可以移动到距离原位置 1 个单位 的新位置。当然，也可以选择 不动 。所有动作 同时 发生。
     * 如果你可以在任何阻碍者抓住你 之前 到达目的地（阻碍者可以采取任意行动方式），则被视为逃脱成功。如果你和阻碍者同时到达了一个位置（包括目的地）都不算是逃脱成功。
     * 只有在你有可能成功逃脱时，输出 true ；否则，输出 false 。
     * @date: 2021-08-22
     */
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        return Arrays.stream(ghosts).noneMatch(ghost -> Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]) <= Math.abs(target[0]) + Math.abs(target[1]));
    }
    /**
     * @author: zangch
     * @describe: 1310. 子数组异或查询
     * 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
     * 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
     * 并返回一个包含给定查询 queries 所有结果的数组。
     * @date: 2021-09-03
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xor = new int[arr.length+1];
        for (int i = 1 ; i <= arr.length ; i++) {
            xor[i] = xor[i-1] ^ arr[i-1];
        }
        return Arrays.stream(queries).mapToInt(query -> xor[query[1]+1] ^ xor[query[0]]).toArray();
    }
    /**
     * @author: zangch
     * @describe: 447. 回旋镖的数量
     * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
     * 返回平面上所有回旋镖的数量。
     * @date: 2021-09-13
     */
    public int numberOfBoomerangs(int[][] points) {
        return Arrays.stream(points).mapToInt(o -> {
            Map<Double, Integer> distance = new HashMap<>();
            Arrays.stream(points).forEach(p -> {
                Double d = Math.pow(p[0] - o[0], 2) + Math.pow(p[1] - o[1], 2);
                distance.put(d, distance.getOrDefault(d, 0) +1);
            });
            return distance.values().stream().mapToInt(n -> n * (n -1)).sum();
        }).sum();
    }
    /**
     * @author: zangch
     * @describe: 524. 通过删除字母匹配到字典里最长单词
     * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
     * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
     * @date: 2021-09-14
     */
    public String findLongestWord(String s, List<String> dictionary) {
        String longest = "";
        for (String d : dictionary) {
            int i = 0, j = 0;
            while (i < s.length()) {
                if (s.charAt(i++) == d.charAt(j)) {
                    j++;
                }
                if (j == d.length()) {
                    if (longest.length() < j) {
                        longest = d;
                    } else if (longest.length() == j && d.compareTo(longest) < 0) {
                        longest = d;
                    }
                    break;
                }
            }
        }
        return longest;
    }
    /**
     * @author: zangch
     * @describe: 41. 缺失的第一个正数
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
     * @date: 2021-09-29
     */
    public int firstMissingPositive(int[] nums) {
        int miss = 1;
        Set<Integer> numSet = new HashSet<>();
        numSet.add(1);
        for (int num : nums) {
            if (num == miss) {
                while (!numSet.add(miss)) {
                    miss++;
                }
            } else if (num > 0) {
                numSet.add(num);
            }
        }
        return miss;
    }
    /**
     * @author: zangch
     * @describe: 29. 两数相除
     * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
     * 返回被除数 dividend 除以除数 divisor 得到的商。
     * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
     * @date: 2021-10-12
     */
    public int divide(int dividend, int divisor) {
        return dividend / divisor;
    }
    /**
     * @author: zangch
     * @describe: 38. 外观数列
     * 给定一个正整数 n ，输出外观数列的第 n 项。
     * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
     * 你可以将其视作是由递归公式定义的数字字符串序列：
     * countAndSay(1) = "1"
     * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
     * @date: 2021-10-15
     */
    public String countAndSay(int n) {
        String result = "1";
        while (--n > 0) {
            int count = 1;
            char c = result.charAt(0);
            StringBuilder next = new StringBuilder();
            for (int i = 1 ; i < result.length() ; i++) {
                if (result.charAt(i) == c) {
                    count++;
                } else {
                    next.append(count).append(c);
                    count = 1;
                    c = result.charAt(i);
                }
            }
            next.append(count).append(c);
            result = next.toString();
        }
        return result;
    }
}
