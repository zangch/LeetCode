package com.github.zangch.leetcode.daily;

import org.junit.jupiter.api.Test;

/**
 * @author: zangch
 * @describe:
 * @date: 2021-09-01
 */
class StringOperationTest {
    private final StringOperation stringOperation = new StringOperation();
    @Test
    void compareVersion() { System.out.println(stringOperation.compareVersion("1.2.0", "1.1.0.0.0.2"));
    }
    @Test
    void minimalSteps() { System.out.println(stringOperation.minimalSteps(new String[]{"S#O", "M..", "M.T"}));
    }
}