package com.github.zangch.leetcode.daily;

import java.util.*;

/**
 * @author: zangch
 * @describe: 贪心
 */
public class Greedy {
    /**
     * @author: zangch
     * @describe: 44. 通配符匹配
     * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
     * '?' 可以匹配任何单个字符。
     * '*' 可以匹配任意字符串（包括空字符串）。
     * 两个字符串完全匹配才算匹配成功。
     * 说明:
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
     * @date: 2021-09-07
     */
    public boolean isMatch(String s, String p) {
        return true;
    }
    /**
     * @author: zangch
     * @describe: 55. 跳跃游戏
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标。
     * @date: 2021-09-07
     */
    public boolean canJump(int[] nums) {
        int index = 0;
        for (int i = 0 ; i <= index && i < nums.length ; i++) {
            index = Math.max(index, nums[i] + i);
        }
        return (index >= nums.length-1);
    }
    /**
     * @author: zangch
     * @describe: 45. 跳跃游戏 II 丑陋
     * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * 假设你总是可以到达数组的最后一个位置。
     * @date: 2021-09-07
     */
    public int jump(int[] nums) {
        int index = 0, count = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            int temp = index;
            while (i <= temp && i < nums.length) {
                index = Math.max(index, nums[i] + i);
                i++;
            }
            count++;
            i--;
        }
        return --count;
    }
    /**
     * @author: zangch
     * @describe: 122. 买卖股票的最佳时机 II
     * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * @date: 2021-09-07
     */
    public int maxProfit(int[] prices) {
        int profit = 0, current = prices[0];
        for (int i = 1 ; i < prices.length ; i++) {
            if (prices[i] > current) {
                profit += prices[i] - current;
            }
            current = prices[i];
        }
        return profit;
    }
    /**
     * @author: zangch
     * @describe: 134. 加油站
     * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
     * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
     * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
     * 说明:
     * 如果题目有解，该答案即为唯一答案。
     * 输入数组均为非空数组，且长度相同。
     * 输入数组中的元素均为非负数。
     * @date: 2021-09-07
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        return 0;
    }
    /**
     * @author: zangch
     * @describe: 135. 分发糖果
     * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
     * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
     * 每个孩子至少分配到 1 个糖果。
     * 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
     * 那么这样下来，老师至少需要准备多少颗糖果呢？
     * @date: 2021-09-07
     */
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length], right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1 ; i < ratings.length ; i++) {
            if (ratings[i] > ratings[i-1]) {
                left[i] = left[i-1] +1;
            }
        }
        int minCandy = left[left.length-1];
        for (int i = ratings.length-2 ; i >= 0 ; i--) {
            if (ratings[i] > ratings[i+1]) {
                right[i] = right[i+1] +1;
            }
            minCandy += Math.max(left[i], right[i]);
        }
        return minCandy;
    }
    /**
     * @author: zangch
     * @describe: 179. 最大数
     * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
     * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     * @date: 2021-09-07
     */
    public String largestNumber(int[] nums) {
        String [] newNums = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        StringBuilder result = new StringBuilder();
        Arrays.sort(newNums, (m,n) -> (int)(Long.parseLong(n+m) - Long.parseLong(m+n)));
        if ("0".equals(newNums[0])) {
            return "0";
        }
        for (String num : newNums) {
            result.append(num);
        }
        return result.toString();
    }
    /**
     * @author: zangch
     * @describe: 502. IPO
     * 假设 力扣（LeetCode）即将开始 IPO 。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。 由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。
     * 给你 n 个项目。对于每个项目 i ，它都有一个纯利润 profits[i] ，和启动该项目需要的最小资本 capital[i] 。
     * 最初，你的资本为 w 。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
     * 总而言之，从给定项目中选择 最多 k 个不同项目的列表，以 最大化最终资本 ，并输出最终可获得的最多资本。
     * 答案保证在 32 位有符号整数范围内。
     * @date: 2021-09-08
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int max = w;
        PriorityQueue<Integer> profitsPriority = new PriorityQueue<>((o1, o2) -> profits[o2] - profits[o1]);
        PriorityQueue<Integer> capitalPriority = new PriorityQueue<>(Comparator.comparingInt(o -> capital[o]));
        for (int i = 0 ; i < profits.length ; i++) {
            if (capital[i] <= w) {
                profitsPriority.add(i);
            } else {
                capitalPriority.add(i);
            }
        }
        while (k-- > 0) {
            if (profitsPriority.peek() == null) {
                break;
            }
            max += profits[profitsPriority.poll()];
            while (capitalPriority.peek() != null && capital[capitalPriority.peek()] <= max) {
                profitsPriority.add(capitalPriority.poll());
            }
        }
        return max;
    }
    /**
     * @author: zangch
     * @describe: 68. 文本左右对齐 🥦
     * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
     * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
     * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
     * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
     * 说明:
     * 单词是指由非空格字符组成的字符序列。
     * 每个单词的长度大于 0，小于等于 maxWidth。
     * 输入单词数组 words 至少包含一个单词。
     * @date: 2021-09-09
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        return result;
    }
}