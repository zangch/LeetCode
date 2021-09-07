package com.github.zangch.leetcode.daily;

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
}