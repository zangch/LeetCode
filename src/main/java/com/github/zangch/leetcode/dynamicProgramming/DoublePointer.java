package com.github.zangch.leetcode.dynamicProgramming;

/**
 * @author: zangch
 * @describe: 413. 等差数列划分
 *  如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 *  给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。子数组 是数组中的一个连续序列。
 * @date: 2021-08-10
 */
public class DoublePointer {
    public static int numberOfArithmeticSlices(int[] nums) {
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
    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1,2,3,4,5}));
    }
}
