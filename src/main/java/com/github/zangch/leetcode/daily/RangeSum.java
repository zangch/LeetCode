package com.github.zangch.leetcode.daily;

import java.util.*;

/**
 * @author: zangch
 * @describe: 区间求和
 */
public class RangeSum {
    /**
     * @author: zangch
     * @describe: 1109. 航班预订统计
     * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
     * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
     * 请你返回一个长度为 n 的数组 answer，其中 answer[i] 是航班 i 上预订的座位总数。
     * @date: 2021-08-31
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n+1], answer = new int[n];
        for (int[] booking : bookings) {
            diff[booking[0]-1] += booking[2];
            diff[booking[1]] -= booking[2];
        }
        answer[0] = diff[0];
        for (int i = 1 ; i < n ; i++) {
            answer[i] = answer[i-1] + diff[i];
        }
        return answer;
    }
    /**
     * @author: zangch
     * @describe: 304. 二维区域和检索 - 矩阵不可变
     * 给定一个二维矩阵 matrix，以下类型的多个请求：
     * 计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
     * 实现 NumMatrix 类：
     * NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
     * int sumRegion(int row1, int col1, int row2, int col2) 返回左上角 (row1, col1) 、右下角 (row2, col2) 的子矩阵的元素总和。
     * @date: 2021-09-02
     */
    static class NumMatrix {
        private final int[][] sum;

        public NumMatrix(int[][] matrix) {
            sum = new int[matrix.length][matrix.length == 0 ? 0 : matrix[0].length];
            for (int i = 0 ; i < matrix.length ; i++) {
                for (int j = 0 ; j < matrix[0].length ; j++) {
                    sum[i][j] = (i == 0 ? 0 : sum[i-1][j]) + (j ==0 ? 0 : sum[i][j-1]) - (i == 0 || j ==0 ? 0 : sum[i-1][j-1]) + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sum[row2][col2] - (row1 == 0 ? 0 : sum[row1-1][col2]) - (col1 == 0 ? 0 : sum[row2][col1-1]) + (row1 ==0 || col1 ==0 ? 0 : sum[row1-1][col1-1]);
        }
    }
    /**
     * @author: zangch
     * @describe: 363. 矩形区域不超过 K 的最大数值和
     * 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
     * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
     * @date: 2021-09-02
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        return matrix.length +k;
    }
    /**
     * @author: zangch
     * @describe: 523. 连续的子数组和
     * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
     * 子数组大小 至少为 2 ，且子数组元素总和为 k 的倍数。
     * 如果存在，返回 true ；否则，返回 false 。
     * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
     * @date: 2021-09-02
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length+1];
        Set<Integer> remainder = new HashSet<>();
        for (int i = 1 ; i <= nums.length ; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        for (int i = 2 ; i <= nums.length ; i++) {
            remainder.add(sum[i-2] % k);
            if (remainder.contains(sum[i] % k)) return true;
        }
        return false;
    }
    /**
     * @author: zangch
     * @describe: 525. 连续数组
     * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
     * @date: 2021-09-02
     */
    public int findMaxLength(int[] nums) {
        int max = 0;
        int[] sum = new int[nums.length+1];
        Map<Integer, Integer> dif = new HashMap<>();
        dif.put(0,0);
        for (int i = 1 ; i <= nums.length ; i++) {
            sum[i] = sum[i-1] + nums[i-1];
            int temp = sum[i]*2 -i;
            if (dif.containsKey(temp)) {
                max = Math.max(max, i - dif.get(temp));
            } else {
                dif.put(temp, i);
            }
        }
        return max;
    }
    /**
     * @author: zangch
     * @describe: 930. 和相同的二元子数组
     * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
     * 子数组 是数组的一段连续部分。
     * @date: 2021-09-03
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        int[] sums = new int[nums.length+1];
        for (int i = 1 ; i <= nums.length ; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
        for (int i = 1 ; i <= nums.length ; i++) {
            for (int j = i ; j <= nums.length ; j++) {
                int rang = sums[j] - sums[i-1];
                if (rang == goal) {
                    sum++;
                } else if (rang > goal) {
                    break;
                }
            }
        }
        return sum;
    }
}
