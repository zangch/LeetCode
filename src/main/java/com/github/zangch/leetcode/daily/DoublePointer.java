package com.github.zangch.leetcode.daily;

import java.util.Arrays;

/**
 * @author: zangch
 * @describe: 双指针
 */
public class DoublePointer {
    /**
     * @author: zangch
     * @describe: 345. 反转字符串中的元音字母
     * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
     * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
     * @date: 2021-08-19
     */
    public String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0, j = cs.length ; i < j ; i++) {
            if (cs[i] == 'a' || cs[i] == 'e' || cs[i] == 'i' || cs[i] == 'o' || cs[i] == 'u' || cs[i] == 'A' || cs[i] == 'E' || cs[i] == 'I' || cs[i] == 'O' || cs[i] == 'U') {
                while (--j > i) {
                    if (cs[j] == 'a' || cs[j] == 'e' || cs[j] == 'i' || cs[j] == 'o' || cs[j] == 'u' || cs[j] == 'A' || cs[j] == 'E' || cs[j] == 'I' || cs[j] == 'O' || cs[j] == 'U') {
                        char temp = cs[i];
                        cs[i] = cs[j];
                        cs[j] = temp;
                        break;
                    }
                }
            }
        }
        return String.valueOf(cs);
    }
    /**
     * @author: zangch
     * @describe: 541. 反转字符串 II
     * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     * 例：输入：s = "abcdefg", k = 2 输出："bacdfeg"
     * @date: 2021-08-20
     */
    public String reverseStr(String s, int k) {
        int i = 0, len = s.length()-1;
        while (i < len) {
            if (i + k > len) {
                s = s.substring(0, i) + new StringBuilder(s.substring(i, len+1)).reverse();
                return s;
            } else {
                s = s.substring(0, i) + new StringBuilder(s.substring(i, i + k)).reverse() + s.substring(i + k);
                i = i + k*2;
            }
        }
        return s;
    }
    /**
     * @author: zangch
     * @describe: 881. 救生艇
     * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
     * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
     * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
     * @date: 2021-08-26
     */
    public int numRescueBoats(int[] people, int limit) {
        int count = 0, j = people.length-1;
        Arrays.sort(people);
        for (int i = 0 ; i <= j ; i++) {
            if (people[i] + people[j] > limit) {
                i--;
            }
            j--;
            count++;
        }
        return count;
    }
    /**
     * @author: zangch
     * @describe: 1004. 最大连续1的个数 III 🥦
     * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
     * 返回仅包含 1 的最长（连续）子数组的长度。
     * @date: 2021-09-03
     */
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, count = 0, longest = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                count++;
            }
            if (k >= count) {
                right++;
            } else {
                longest = Math.max(longest, right-left);
                if (nums[left] == 0) {
                    count--;
                }
                if (nums[right] == 0) {
                    count--;
                }
                left++;
            }
        }
        return Math.max(longest, right-left);
    }
}
