package com.github.zangch.leetcode.daily;

import java.util.*;

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
    /**
     * @author: zangch
     * @describe: 11. 盛最多水的容器
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * 说明：你不能倾斜容器。
     * @date: 2021-09-06
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1, max = 0;
        while (left < right) {
            max = Math.max(max, (right-left) * Math.min(height[left], height[right]));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
    /**
     * @author: zangch
     * @describe: 15. 三数之和 🥦
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * @date: 2021-09-06
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<List<Integer>>> sum = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++) {
            for (int j = i+1 ; j < nums.length ; j++) {
                if (sum.containsKey(-nums[j])) {
                    for (List<Integer> temp : sum.get(-nums[j])){
                        temp.add(nums[j]);
                        result.add(temp);
                    }
                }
                List<List<Integer>> temp = sum.getOrDefault(nums[i] + nums[j], new ArrayList<>());
                temp.add(Arrays.asList(nums[i], nums[j]));
                sum.putIfAbsent(nums[i] + nums[j],temp);
            }
        }
        return result;
    }
    /**
     * @author: zangch
     * @describe: 189. 旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * 进阶：
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
     * @date: 2021-09-09
     */
    public int[] rotate(int[] nums, int k) {
        k = k % nums.length;
        int i = k % nums.length, j = k % nums.length, num = nums[0], count = 0;
        while (count != nums.length) {
            int temp = nums[j];
            nums[j] = num;
            num = temp;
            j = (j + k) % nums.length;
            count++;
            if (j == i ) {
                j = (j+1) % nums.length;
                i = j;
                num = nums[(i - k + nums.length) % nums.length];
            }
        }
        return nums;
    }
    /**
     * @author: zangch
     * @describe: LCP 14. 切分数组 G
     * 给定一个整数数组 nums ，小李想将 nums 切割成若干个非空子数组，使得每个子数组最左边的数和最右边的数的最大公约数大于 1 。为了减少他的工作量，请求出最少可以切成多少个子数组。
     * @date: 2021-09-10
     */
    public int splitArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        int min = splitArray(Arrays.copyOfRange(nums, 1, nums.length)) +1;
        for (int i = 1 ; i < nums.length ; i++) {
            if (gcd(nums[0], nums[i]) > 1)
                min = Math.min(min, splitArray(Arrays.copyOfRange(nums, i+1, nums.length)) +1);
        }
        return min;
    }
    private int gcd(int a,int b){
        if(b == 0)
            return a;
        return gcd(b,a%b);
    }
    /**
     * @author: zangch
     * @describe: 峰值元素是指其值严格大于左右相邻值的元素。
     * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
     * 你可以假设 nums[-1] = nums[n] = -∞ 。
     * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
     * @date: 2021-09-15
     */
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length -1;
        while (left <= right) {
            int middle = (left + right) /2;
            if ((middle == 0 || nums[middle] > nums[middle-1]) && (middle == nums.length -1 || nums[middle] > nums[middle+1])) {
                return middle;
            } else if (middle == 0 || nums[middle] > nums[middle -1]) {
                left = middle +1;
            } else {
                right = middle -1;
            }
        }
        return -1;
    }
    /**
     * @author: zangch
     * @describe: 567. 字符串的排列
     * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。
     * 换句话说，s1 的排列之一是 s2 的 子串 。
     * @date: 2021-09-15
     */
    public boolean checkInclusion(String s1, String s2) {
        return true;
    }
    public int majorityElement(int[] nums) {
        int current = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                current = num;
            }
            count += (current == num) ? 1 : -1;
        }
        return current;
    }
}