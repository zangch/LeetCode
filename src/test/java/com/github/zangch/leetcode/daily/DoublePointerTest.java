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
    void threeSum(){
        System.out.println(doublePointer.threeSum(new int[]{1,2,4,6,2,3,4,2}));
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
}