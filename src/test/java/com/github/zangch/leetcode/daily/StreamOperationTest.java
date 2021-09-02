package com.github.zangch.leetcode.daily;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author: zangch
 * @describe:
 * @date: 2021-08-23
 */
class StreamOperationTest {
    private final StreamOperation streamOperation = new StreamOperation();
    @Test
    void escapeGhosts() {
        System.out.println(streamOperation.escapeGhosts(new int[][]{{1,2},{0,1}}, new int[]{1,1}));
    }
    @Test
    void corpFlightBookings() {
        System.out.println(Arrays.toString(streamOperation.corpFlightBookings(new int[][]{{1,2,10}, {2,5,25},{2,3,20}}, 5)));
    }
}