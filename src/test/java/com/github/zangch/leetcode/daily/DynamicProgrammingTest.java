package com.github.zangch.leetcode.daily;

import org.junit.jupiter.api.Test;

/**
 * @author: zangch
 * @describe:
 * @date: 2021-08-11
 */
class DynamicProgrammingTest {

    @Test
    void numberOfArithmeticSlices() {
        System.out.println(DynamicProgramming.numberOfArithmeticSlices(new int[]{1,2,3,4}));
    }

    @Test
    void numberOfArithmeticSlicesII() {
        System.out.println(DynamicProgramming.numberOfArithmeticSlicesII(new int[]{1,5,9,2,13,3,4}));
    }
}