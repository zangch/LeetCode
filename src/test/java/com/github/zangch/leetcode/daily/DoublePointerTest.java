package com.github.zangch.leetcode.daily;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}