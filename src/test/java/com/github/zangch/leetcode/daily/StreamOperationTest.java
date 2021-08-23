package com.github.zangch.leetcode.daily;

import org.junit.jupiter.api.Test;

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
}