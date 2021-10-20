package com.github.zangch.leetcode.daily;

import java.util.*;

/**
 * @author: zangch
 * @describe: 动态规划
 */
public class DynamicProgramming {
    /**
     * @author: zangch
     * @describe: 413. 等差数列划分
     * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
     * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
     * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
     * 子数组 是数组中的一个连续序列。
     * @date: 2021-08-10
     */
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int count = 0, intervalCount = 0, d = nums[1] - nums[0];
        for (int i = 2 ; i < nums.length ; i++) {
            if (nums[i] - nums[i-1] == d) {
                intervalCount++;
            } else {
                count += (1 + intervalCount) * intervalCount / 2;
                d = nums[i] - nums[i-1];
                intervalCount = 2;
            }
        }
        count += (1 + intervalCount) * intervalCount / 2;
        return count;
    }
    /**
     * @author: zangch
     * @describe: 446. 等差数列划分 II - 子序列
     * 给你一个整数数组 nums ，返回 nums 中所有 等差子序列 的数目。
     * 如果一个序列中 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该序列为等差序列。
     * 例如，[1, 3, 5, 7, 9]、[7, 7, 7, 7] 和 [3, -1, -5, -9] 都是等差序列。
     * 再例如，[1, 1, 2, 5, 7] 不是等差序列。
     * 数组中的子序列是从数组中删除一些元素（也可能不删除）得到的一个序列。
     * 例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。
     * 题目数据保证答案是一个 32-bit 整数。
     * @date: 2021-08-11
     */
    public int numberOfArithmeticSlicesII(int[] nums) {
        int n = nums.length, count = 0;
        long d;
        List<Map<Long, Integer>> f = new ArrayList<>();
        for (int i=0 ; i < n ; i++) {
            Map<Long, Integer> dMap = new HashMap<>();
            for(int j=0 ; j < i ; j++) {
                d = (long) nums[i] - nums[j];
                dMap.put(d, f.get(j).getOrDefault(d, -1)+1);
                count += dMap.get(d);
            }
            f.add(dMap);
        }
        return count;
    }
    /**
     * @author: zangch
     * @describe: 516. 最长回文子序列 🥦
     * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
     * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
     * 例：bad
     * @date: 2021-08-12
     */
    public int longestPalindromeSubseq(String s) {

        return s.length();
    }
    /**
     * @author: zangch
     * @describe: 233. 数字 1 的个数
     * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
     * 0 <= n <= 2 * 10^9
     * @date: 2021-08-13
     */
    public int countDigitOne(int n) {
        if (n < 2) return n;
        String num = String.valueOf(n);
        int highest = num.charAt(0) - '0', digits = num.length(), deleteHighest = n % (int)Math.pow(10,digits-1) ;
        return (highest == 1 ? deleteHighest+1  :  (int)Math.pow(10,digits-1)) + (highest) * (digits-1) * (int)Math.pow(10,digits-2) + countDigitOne(deleteHighest);
    }
    /**
     * @author: zangch
     * @describe: 552. 学生出勤记录 II
     * 可以用字符串表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
     * 'A'：Absent，缺勤
     * 'L'：Late，迟到
     * 'P'：Present，到场
     * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
     * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
     * 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
     * 给你一个整数 n ，表示出勤记录的长度（次数）。请你返回记录长度为 n 时，可能获得出勤奖励的记录情况 数量 。答案可能很大，所以返回对 10^9 + 7 取余 的结果。
     * @date: 2021-08-18
     */
    public int checkRecord(int n) {
        final int MOD = 1000000007;
        int[] status = new int[]{1,1,0,1,0,0}, newStatus = new int[6];
        while (n-- > 0) {
            newStatus[0] = ((status[0] + status[1]) % MOD + status[2]) % MOD;
            newStatus[1] = status[0];
            newStatus[2] = status[1];
            newStatus[3] = (((((status[0] + status[1]) % MOD +status[2]) % MOD + status[3]) %MOD + status[4]) % MOD + status[5]) % MOD;
            newStatus[4] = status[3];
            newStatus[5] = status[4];
            System.arraycopy(newStatus, 0, status, 0, 6);
        }
        return newStatus[3];
    }
    /**
     * @author: zangch
     * @describe: 91. 解码方法
     * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
     * "AAJF" ，将消息分组为 (1 1 10 6)
     * "KJF" ，将消息分组为 (11 10 6)
     * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
     * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
     * 题目数据保证答案肯定是一个 32 位 的整数。
     * @date: 2021-09-18
     */
    public int numDecodings(String s) {
        int l = s.length();
        int[] dp = new int[l];
        if (l > 0 && s.charAt(0) == '0') {
            return 0;
        } else if (l > 0 && s.charAt(0) != '0') {
            dp[0] = 1;
        }
        if (l > 1 && ((s.charAt(0) - '0') * 10 + (s.charAt(1) - '0') < 27) && s.charAt(1) != '0') {
            dp[1] = 2;
        } else if (l > 1 && s.charAt(1) == '0' && s.charAt(0) != '1' && s.charAt(0) != '2') {
            return 0;
        } else if (l > 1){
            dp[1] = 1;
        }
        for (int i = 2 ; i < l ; i++) {
            if (s.charAt(i) == '0' && s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') {
                return 0;
            } else if (s.charAt(i) == '0') {
                dp[i] = dp[i - 2];
            } else if ((s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0') < 27 && s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 2] + dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[l - 1];
    }
    /**
     * @author: zangch
     * @describe: 650. 只有两个键的键盘
     * 最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作：
     * Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。
     * Paste（粘贴）：粘贴 上一次 复制的字符。
     * 给你一个数字 n ，你需要使用最少的操作次数，在记事本上输出 恰好 n 个 'A' 。返回能够打印出 n 个 'A' 的最少操作次数。
     * @date: 2021-09-22
     */
    public int minSteps(int n) {
        int step = 0;
        for (int i = 2 ; i <= n ; i++) {
            if (n % i == 0) {
                step += i;
                n = n / i;
                i = 1;
            }
        }
        return step;
    }
    /**
     * @author: zangch
     * @describe: 152. 乘积最大子数组
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     * @date: 2021-09-23
     */
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int[][] dp = new int[2][nums.length];
        dp[0][0] = nums[0];
        dp[1][0] = nums[0];
        for (int i = 1 ; i < nums.length ; i++) {
            if (nums[i] > 0) {
                dp[0][i] = Math.max(nums[i], nums[i] * dp[0][i - 1]);
                dp[1][i] = Math.min(nums[i], nums[i] * dp[1][i - 1]);
            } else {
                dp[0][i] = Math.max(nums[i], nums[i] * dp[1][i - 1]);
                dp[1][i] = Math.min(nums[i], nums[i] * dp[0][i - 1]);
            }
            max = Math.max(max, dp[0][i]);
        }
        return max;
    }
    /**
     * @author: zangch
     * @describe: 120. 三角形最小路径和
     * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
     * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
     * @date: 2021-09-23
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1 ; i < triangle.size() ; i++) {
            int size = triangle.get(i).size() - 1;
            List<Integer> line = triangle.get(i), beforeLine = triangle.get(i - 1);
            line.set(0, line.get(0) + beforeLine.get(0));
            for (int j = 1 ; j < size ; j++) {
                line.set(j, line.get(j) + Math.min(beforeLine.get(j), beforeLine.get(j - 1)));
            }
            triangle.get(i).set(size, line.get(size) + beforeLine.get(size - 1));
        }
        return triangle.get(triangle.size() - 1).stream().mapToInt(Integer::intValue).min().orElse(0);
    }
    /**
     * @author: zangch
     * @describe: 198. 打家劫舍
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     * @date: 2021-09-24
     */
    public int rob(int[] nums) {
        return 0;
    }
    /**
     * @author: zangch
     * @describe: 312. 戳气球
     * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
     * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
     * 求所能获得硬币的最大数量。
     * @date: 2021-09-29
     */
    public int maxCoins(int[] nums) {
        return 0;
    }
    /**
     * @author: zangch
     * @describe: 72. 编辑距离
     * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
     * 你可以对一个单词进行如下三种操作：
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     * @date: 2021-10-19
     */
    public int minDistance(String word1, String word2) {
        if (word1.length() * word2.length() == 0) {
            return word1.length() + word2.length();
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0 ; i <= word1.length() ; i++) {
            dp[i][0] = i;
        }
        for (int i = 1 ; i <= word2.length() ; i++) {
            dp[0][i] = i;
        }
        for (int i = 1 ; i <= word1.length() ; i++) {
            for (int j = 1; j <= word2.length() ; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

}