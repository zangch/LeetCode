package com.github.zangch.leetcode.daily;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author: zangch
 * @describe:
 * @date: 2021-08-20
 */
class DoublePointerTest {
    private final DoublePointer doublePointer = new DoublePointer();
    @Test
    void reverseVowels() {
        System.out.println(doublePointer.reverseVowels("hello"));
    }
    @Test
    void reverseStr() {
        System.out.println(doublePointer.reverseStr("hello world , I am IronMan", 3));
    }
    @Test
    void numRescueBoats() {
        System.out.println(doublePointer.numRescueBoats(new int[]{1,2,3,4,5}, 6));
    }
    @Test
    void longestOnes() {
        System.out.println(doublePointer.longestOnes(new int[]{0,0,0,1}, 4));
    }
    @Test
    void equalSubstring(){
        System.out.println(doublePointer.equalSubstring("abed", "bade", 3));
    }
    @Test
    void maxAbsoluteSum(){
        System.out.println(doublePointer.maxAbsoluteSum(new int[]{1,-1,4,-6,2,3,-4,2}));
    }
    @Test
    void maxArea(){
        System.out.println(doublePointer.maxArea(new int[]{1,2,4,6,2,3,4,2}));
    }
    @Test
    void rotate(){
        System.out.println(Arrays.toString(doublePointer.rotate(new int[]{1,9}, 3)));
    }
    @Test
    void splitArray(){
        System.out.println(doublePointer.splitArray(new int[]{2,5,2,7,11,13,17,5}));
    }
    @Test
    void findPeakElement(){
        System.out.println(doublePointer.findPeakElement(new int[]{1,2}));
    }
    @Test
    void searchRange(){
        System.out.println(Arrays.toString(doublePointer.searchRange(new int[]{4,4,4,4,4,4}, 5)));
    }
    @Test
    void searchMatrix(){
        System.out.println(doublePointer.searchMatrix(new int[][]{{1,2,3},{4,5,6}}, 3));
    }
    @Test
    void findMin(){
        System.out.println(doublePointer.findMin(new int[]{4,5,6,7,1,2,3}));
    }
    @Test
    void threeSum(){
        System.out.println(doublePointer.threeSum(new int[]{-1,-2,0,4,6,2,3,4,2}));
    }
    @Test
    void nthUglyNumber(){
        System.out.println(doublePointer.nthUglyNumber(7));
    }
    @Test
    void numDecodings(){
        System.out.println(doublePointer.numDecodings("1**"));
    }
    @Test
    void numSquares(){
        System.out.println(doublePointer.numSquares(10000));
    }
    @Test
    void maxSumDivThree(){
        System.out.println(doublePointer.maxSumDivThree(new int[]{1,4}));
    }
    @Test
    void trap(){
        System.out.println(doublePointer.trap(new int[]{4,2,3}));
    }
    @Test
    void  findRadius() {
        System.out.println(doublePointer.findRadius(new int[]{282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923},
                new int[]{823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612}));
    }
    @Test
    void  numFriendRequests() {
        System.out.println(doublePointer.numFriendRequests(new int[]{16,16}));
    }
    @Test
    void  countQuadruplets() {
    System.out.println(doublePointer.countQuadruplets(new int[]{28,8,49,85,37,90,20,8}));
}
    @Test
    void  kSmallestPairs() {
        System.out.println(doublePointer.kSmallestPairs(new int[]{1,2,3,4,5}, new int[]{1,2,3,4,5,6}, 20));
    }
}