package com.github.zangch.leetcode.daily;

/**
 * @author: zangch
 * @describe: 流操作
 */
public class StreamOperation {
    /**
     * @author: zangch
     * @describe: 789. 逃脱阻碍者 🥦
     * 你在进行一个简化版的吃豆人游戏。你从 [0, 0] 点开始出发，你的目的地是 target = [xtarget, ytarget] 。地图上有一些阻碍者，以数组 ghosts 给出，第 i 个阻碍者从 ghosts[i] = [xi, yi] 出发。所有输入均为 整数坐标 。
     * 每一回合，你和阻碍者们可以同时向东，西，南，北四个方向移动，每次可以移动到距离原位置 1 个单位 的新位置。当然，也可以选择 不动 。所有动作 同时 发生。
     * 如果你可以在任何阻碍者抓住你 之前 到达目的地（阻碍者可以采取任意行动方式），则被视为逃脱成功。如果你和阻碍者同时到达了一个位置（包括目的地）都不算是逃脱成功。
     * 只有在你有可能成功逃脱时，输出 true ；否则，输出 false 。
     * @date: 2021-08-22
     */
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int d = Math.abs(target[0]) + Math.abs(target[1]);
        int[] dis = new int[ghosts.length];
        for (int i = 0 ; i < ghosts.length ; i++) {
            dis[i] = Math.abs(ghosts[i][0]) + Math.abs(ghosts[i][1]);
        }
        for(int ds : dis) {
            if (ds <= d) {
                return false;
            }
        }
        return true;
    }
}
