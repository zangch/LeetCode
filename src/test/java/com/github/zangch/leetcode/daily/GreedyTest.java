package com.github.zangch.leetcode.daily;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: zangch
 * @describe:
 * @date: 2021-09-07
 */
class GreedyTest {
    private final Greedy greedy = new Greedy();
    @Test
    void canJump() {
        System.out.println(greedy.canJump(new int[]{1,2,3,4,0,0,0,1}));
    }

    @Test
    void jump() {
        System.out.println(greedy.jump(new int[]{1,2,3,4,0,0,0,1}));
    }
}