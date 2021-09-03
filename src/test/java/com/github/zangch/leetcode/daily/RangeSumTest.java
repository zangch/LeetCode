package com.github.zangch.leetcode.daily;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author: zangch
 * @describe:
 * @date: 2021-09-02
 */
class RangeSumTest {
    private final RangeSum rangeSum = new RangeSum();
    @Test
    void corpFlightBookings() {
        System.out.println(Arrays.toString(rangeSum.corpFlightBookings(new int[][]{{1,2,10}, {2,5,25},{2,3,20}}, 5)));
    }
    @Test
    void NumMatrix() {
        RangeSum.NumMatrix numMatrix = new RangeSum.NumMatrix(new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}});
        System.out.println(numMatrix.sumRegion(2,1, 4,3));
    }
    @Test
    void maxSumSubmatrix() {
        System.out.println(rangeSum.maxSumSubmatrix(new int[][]{{3,0,1,-4,2},{5,6,-3,-2,1},{1,-2,0,-1,5},{-4,-1,0,-1,7},{1,0,3,0,-5}}, 3));
    }
    @Test
    void checkSubarraySum() {
        System.out.println(rangeSum.checkSubarraySum(new int[]{23,2,4,6,7}, 6));
    }
    @Test
    void findMaxLength() {
        System.out.println(rangeSum.findMaxLength(new int[]{0,0,1,0,1,1,1,0,1,0,1,1,1,1,1,0,1}));
    }
    @Test
    void numSubarraysWithSum() {
        System.out.println(rangeSum.numSubarraysWithSum(new int[]{0,1,0,1,1,1,1,1,0,1}, 4));
    }
}