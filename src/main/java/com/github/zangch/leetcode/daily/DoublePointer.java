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
     * @describe: 34. 在排序数组中查找元素的第一个和最后一个位置
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     * 进阶：
     * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
     * @date: 2021-09-22
     */
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int[] result = new int[]{-1, -1};
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target && (middle == 0 || nums[middle - 1] < target)) {
                result[0] = middle;
                break;
            } else if (nums[middle] >= target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        if (result[0] == -1)
            return result;
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target && (middle == nums.length -1 || nums[middle + 1] > target)) {
                result[1] = middle;
                break;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return result;
    }
    /**
     * @author: zangch
     * @describe: 74. 搜索二维矩阵
     * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     * 每行中的整数从左到右按升序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     * @date: 2021-09-22
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = matrix[0].length - 1, down = 0;
        while (left >= 0 && down < matrix.length) {
            if (matrix[left][down] == target) {
                return true;
            } else if (matrix[left][down] < target) {
                down++;
            } else {
                left--;
            }
        }
        return false;
    }
    /**
     * @author: zangch
     * @describe: 153. 寻找旋转排序数组中的最小值
     * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
     * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
     * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
     * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
     * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
     * @date: 2021-09-23
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, min = Integer.MAX_VALUE;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] >= nums[left]) {
                min = Math.min(min, nums[left]);
                left = middle + 1;
            } else {
                min = Math.min(min, nums[middle + 1]);
                right = middle;
            }
        }
        return min;
    }
    /**
     * @author: zangch
     * @describe: 15. 三数之和 🥦
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * @date: 2021-09-24
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0 ; i < nums.length ; i++) {
            for (int j = i + 1 ; j < nums.length ; j++) {
                for (int k = j + 1 ; k < nums.length ; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return result;
    }
    /**
     * @author: zangch
     * @describe: 264. 丑数 II
     * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
     * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
     * @date: 2021-09-26
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int i2 = 1, i3 = 1, i5 = 1;
        for (int i = 2 ; i <= n ; i++) {
            dp[i] = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] * 5));
            if (dp[i] == dp[i2] * 2) i2++;
            if (dp[i] == dp[i3] * 3) i3++;
            if (dp[i] == dp[i5] * 5) i5++;
        }
        return dp[n];
    }

    /**
     * @author: zangch
     * @describe: 639. 解码方法 II
     * 一条包含字母 A-Z 的消息通过以下的方式进行了编码：
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * 要 解码 一条已编码的消息，所有的数字都必须分组，然后按原来的编码方案反向映射回字母（可能存在多种方式）。例如，"11106" 可以映射为：
     * "AAJF" 对应分组 (1 1 10 6)
     * "KJF" 对应分组 (11 10 6)
     * 注意，像 (1 11 06) 这样的分组是无效的，因为 "06" 不可以映射为 'F' ，因为 "6" 与 "06" 不同。
     * 除了 上面描述的数字字母映射方案，编码消息中可能包含 '*' 字符，可以表示从 '1' 到 '9' 的任一数字（不包括 '0'）。例如，编码字符串 "1*" 可以表示 "11"、"12"、"13"、"14"、"15"、"16"、"17"、"18" 或 "19" 中的任意一条消息。对 "1*" 进行解码，相当于解码该字符串可以表示的任何编码消息。
     * 给你一个字符串 s ，由数字和 '*' 字符组成，返回 解码 该字符串的方法 数目 。
     * 由于答案数目可能非常大，返回对 109 + 7 取余 的结果。
     * @date: 2021-09-27
     */
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = (s.charAt(0) == '*' ? 9 : 1);
        for (int i = 1 ; i < s.length() ; i++) {
            long count = 0;
            if (s.charAt(i) != '0')
                count += (s.charAt(i) == '*') ? 9L * dp[i] : dp[i];
            if (s.charAt(i - 1) == '1')
                count += (s.charAt(i) == '*') ? 9L * dp[i - 1] : dp[i - 1];
            if (s.charAt(i - 1) == '2' && (s.charAt(i) - '0' < 7 || s.charAt(i) == '*'))
                count += (s.charAt(i) == '*') ? 6L * dp[i - 1] : dp[i - 1];
            if (s.charAt(i - 1) == '*'){
                if (s.charAt(i) == '*') {
                    count += 15L * dp[i - 1];
                } else if (s.charAt(i) - '0' < 7) {
                    count += 2L * dp[i - 1];
                } else {
                    count += dp[i - 1];
                }
            }
            if (count == 0)
                return 0;
            dp[i + 1] = (int)(count % 1000000007);
        }
        return dp[s.length()];
    }
    /**
     * @author: zangch
     * @describe: 279. 完全平方数
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
     * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
     * @date: 2021-09-28
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2 ; i <= n ; i++) {
            if (Math.sqrt(i) % 1 == 0) {
                dp[i] = 1;
                continue;
            }
            int min = Integer.MAX_VALUE, current = i;
            while (--current >= i / 2) {
                min = Math.min(min, dp[current] + dp[i - current]);
            }
            dp[i] = min;
        }
        return dp[n];
    }
    /**
     * @author: zangch
     * @describe: 42. 接雨水
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * @date: 2021-09-28
     */
    public int trap(int[] height) {
        int l = height.length, result = 0;
        Stack<Integer> monotonousStack = new Stack<>();
        monotonousStack.add(l - 1);
        for (int i = l - 2 ; i >= 0 ; i--) {
            while (!monotonousStack.empty() && height[i] >= height[monotonousStack.peek()]) {
                int current = monotonousStack.pop();
                if (monotonousStack.empty() || height[current] == height[i]) break;
                int higher = monotonousStack.peek();
                result += (higher - i - 1) * (Math.min(height[higher], height[i])- height[current]);
            }
            monotonousStack.add(i);
        }
        return result;
    }
    /**
     * @author: zangch
     * @describe: 1262. 可被三整除的最大和
     * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
     * @date: 2021-09-28
     */
    public int maxSumDivThree(int[] nums) {
        return 0;
    }
    /**
     * @author: zangch
     * @describe: 407. 接雨水 II
     * 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
     * @date: 2021-11-04
     */
    public int trapRainWater(int[][] heightMap) {
        return 0;
    }
    /**
     * @author: zangch
     * @describe: 给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 素数 组成，且其中所有整数互不相同。
     *
     * 对于每对满足 0 < i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。
     *
     * 那么第 k 个最小的分数是多少呢? 以长度为 2 的整数数组返回你的答案, 这里 answer[0] == arr[i] 且answer[1] == arr[j] 。
     * @date: 2021-11-29
     */
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
          return new int[2];
    }
    /**
     * @author: zangch
     * @describe: 475. 供暖器
     * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
     *
     * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
     *
     * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
     *
     * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
     * @date: 2021-12-20
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int radius = 0, i = -1, j = 0;
        while (++i < houses.length) {
            while (j < heaters.length - 1 && houses[i] > heaters[j + 1]) {
                j++;
            }
            if (j < heaters.length - 1) {
                radius = Math.max(radius, Math.min(Math.abs(houses[i] - heaters[j]), Math.abs(houses[i] - heaters[j + 1])));
            } else {
                radius = Math.max(radius, Math.abs(houses[i] - heaters[j]));
            }
        }
        return radius;
    }
    /**
     * @author: zangch
     * @describe: 825. 适龄的朋友
     * 在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。
     *
     * 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
     *
     * age[y] <= 0.5 * age[x] + 7
     * age[y] > age[x]
     * age[y] > 100 && age[x] < 100
     * 否则，x 将会向 y 发送一条好友请求。
     *
     * 注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。
     *
     * 返回在该社交媒体网站上产生的好友请求总数。
     * @date: 2021-12-27
     */
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int friends = 0;
        for (int i = 0, l = 0, r = 1; i < ages.length; i++) {
            while (l < i && !check(ages[i], ages[l])) l++;
            if (r <= i) r = i + 1;
            while (r < ages.length && check(ages[i], ages[r])) r++;
            friends += r - l - 1;
        }
        return friends;
    }
    private boolean check(int x, int y) {
        return !(y <= 0.5 * x +7 || y > x);
    }
    /**
     * @author: zangch
     * @describe: 
     * @date: 2021-12-28
     */
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        return new ArrayList<>();
    }
    public int countQuadruplets(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for(int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] == nums[l]) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}