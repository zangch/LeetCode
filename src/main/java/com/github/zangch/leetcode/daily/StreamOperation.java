package com.github.zangch.leetcode.daily;

import java.util.Arrays;
/**
 * @author: zangch
 * @describe: 流操作
 */
public class StreamOperation {
    /**
     * @author: zangch
     * @describe: 789. 逃脱阻碍者
     * 你在进行一个简化版的吃豆人游戏。你从 [0, 0] 点开始出发，你的目的地是 target = [xtarget, ytarget] 。地图上有一些阻碍者，以数组 ghosts 给出，第 i 个阻碍者从 ghosts[i] = [xi, yi] 出发。所有输入均为 整数坐标 。
     * 每一回合，你和阻碍者们可以同时向东，西，南，北四个方向移动，每次可以移动到距离原位置 1 个单位 的新位置。当然，也可以选择 不动 。所有动作 同时 发生。
     * 如果你可以在任何阻碍者抓住你 之前 到达目的地（阻碍者可以采取任意行动方式），则被视为逃脱成功。如果你和阻碍者同时到达了一个位置（包括目的地）都不算是逃脱成功。
     * 只有在你有可能成功逃脱时，输出 true ；否则，输出 false 。
     * @date: 2021-08-22
     */
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        return Arrays.stream(ghosts).noneMatch(ghost -> Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]) <= Math.abs(target[0]) + Math.abs(target[1]));
    }
    /**
     * @author: zangch
     * @describe: 1109. 航班预订统计  🥦
     * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
     * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
     * 请你返回一个长度为 n 的数组 answer，其中 answer[i] 是航班 i 上预订的座位总数。
     * @date: 2021-08-31
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        Arrays.stream(bookings).forEach(booking -> {
            for (int i = booking[0] ; i <= booking[1] ; i++) {
                result[i-1] += booking[2];
            }
        });
        return result;
    }
}
