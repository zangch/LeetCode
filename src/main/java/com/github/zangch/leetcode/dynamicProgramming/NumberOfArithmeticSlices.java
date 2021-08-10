package com.github.zangch.leetcode.dynamicProgramming;

/**
 * @author: zangch
 * @describe:
 * @date: 2021-08-10
 */
public class NumberOfArithmeticSlices {
    public static int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int count = 0, intervalCount = 2, d = nums[1] - nums[0];
        for (int i = 2 ; i < nums.length ; i++) {
            if (nums[i] - nums[i-1] == d) {
                intervalCount++;
            } else {
                count += ((intervalCount * intervalCount - 3 * intervalCount + 2) / 2);
                d = nums[i] - nums[i-1];
                intervalCount = 2;
            }
        }
        count += (intervalCount * intervalCount - 3 * intervalCount + 2) / 2;
        return count;
    }
    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1,2,3,4}));
    }
}
