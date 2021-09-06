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
     * @describe: 1004. 最大连续1的个数 III
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
    /**
     * @author: zangch
     * @describe: 1208. 尽可能使字符串相等
     * 给你两个长度相同的字符串，s 和 t。
     * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
     * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
     * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
     * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
     * @date: 2021-09-03
     */
    public int equalSubstring(String s, String t, int maxCost) {
        int count = 0, r = 0;
        int[] costSum = new int[s.length()+1];
        for (int i = 1 ; i <= s.length() ; i++) {
            costSum[i] = costSum[i-1] + Math.abs(s.charAt(i-1) - t.charAt(i-1));
        }
        for (int l = 0 ; l < s.length() ; l++) {
            while (maxCost >= costSum[r+1] - costSum[l]) {
                count = Math.max(count, r - l + 1);
                r++;
                if (r >= s.length()) {
                    return count;
                }
            }
        }
        return count;
    }
    /**
     * @author: zangch
     * @describe: 1749. 任意子数组和的绝对值的最大值 🥦
     * 给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(numsl + numsl+1 + ... + numsr-1 + numsr) 。
     * 请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。
     * abs(x) 定义如下：
     * 如果 x 是负整数，那么 abs(x) = -x 。
     * 如果 x 是非负整数，那么 abs(x) = x 。
     * @date: 2021-09-03
     */
    public int maxAbsoluteSum(int[] nums) {
        int sum = 0, max = 0, r = 0;
        for (int num : nums) {
            while (r < nums.length) {
                if (sum * nums[r] < 0 && Math.abs(sum) < Math.abs(nums[r])) {
                    break;
                }
                sum += nums[r];
                r++;
                max = Math.max(max, Math.abs(sum));
            }
            sum -= num;
        }
        return max;
    }
}