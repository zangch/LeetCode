package com.github.zangch.leetcode.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zangch
 * @describe: 双指针
 * @date: 2021-08-10
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
    public static int numberOfArithmeticSlicesII(int[] nums) {
        int n = nums.length;
        long d;
        List<Map<Long, Integer>> f = new ArrayList<>();
        for (int i=1 ; i < n ; i++) {
            Map<Long, Integer> dMap = new HashMap<>();
            for(int j=0 ; j < i ; j++) {
                d = (long) nums[i] - nums[j];
                dMap.put(d, f.get(i).getOrDefault(d, 0));
            }
            f.add(dMap);
        }
        return 0;
    }
}
