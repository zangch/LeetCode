package com.github.zangch.leetcode.daily;

import java.util.*;

/**
 * @author: zangch
 * @describe:
 * @date: 2021-11-18
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * @author: zangch
     * @describe: 前序遍历 递归
     * @date: 2021-11-18
     */
    public void preOrder(TreeNode root, List<Integer> result) {
        if (root == null)
            return;

        result.add(root.val);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }

    /**
     * @author: zangch
     * @describe: 后序遍历 栈
     * @date: 2021-11-18
     */
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null)
                stack.add(node.left);
            if (node.right != null)
                stack.add(node.right);
        }
        Collections.reverse(result);
        return result;
    }

    /**
     * @author: zangch
     * @describe: 563. 二叉树的坡度
     * 给定一个二叉树，计算 整个树 的坡度 。
     * <p>
     * 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
     * <p>
     * 整个树 的坡度就是其所有节点的坡度之和。
     * @date: 2021-11-19
     */
    public int findTilt(TreeNode root) {
        int[] tilt = new int[1];
        postOrderFindTilt(root, tilt);
        return tilt[0];
    }
    private static int postOrderFindTilt(TreeNode root, int[] tilt) {
        if (root == null) return 0;
        int left = postOrderFindTilt(root.left, tilt), right = postOrderFindTilt(root.right, tilt);
        tilt[0] += Math.abs(left - right);
        return root.val + left + right;
    }
    /**
     * @author: zangch
     * @describe: 783. 二叉搜索树节点最小距离
     * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
     *
     * 差值是一个正数，其数值等于两值之差的绝对值。
     * @date: 2021-11-19
     */
    public int minDiffInBST(TreeNode root) {
        int min = Integer.MAX_VALUE;
        List<Integer> nodes = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            nodes.add(node.val);
            if (node.right != null)
                stack.add(node.right);
            if (node.left != null)
                stack.add(node.left);
        }
        int[] nodesArray = nodes.stream().mapToInt(Integer::intValue).sorted().toArray();
        for (int j = 0 ; j < nodesArray.length - 1 ; j++) {
            min = Math.min(min, Math.abs(nodesArray[j] - nodesArray[j + 1]));
        }
        return min;
    }
    /**
     * @author: zangch
     * @describe: 993. 二叉树的堂兄弟节点
     * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
     *
     * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
     *
     * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
     *
     * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
     * @date: 2021-11-19
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size(), flag = 0;
            while (len > 0) {
                TreeNode node = queue.poll();
                assert node != null;
                if (node.left != null && node.right != null) {
                    if ((node.left.val == x || node.left.val == y) && (node.right.val == x || node.right.val == y)){
                        return false;
                    }
                }
                if (node.val == x || node.val == y) {
                    flag++;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                len--;
            }
            if (flag == 2) {
                return true;
            } else if (flag == 1) {
                return false;
            }
        }
        return false;
    }
    /**
     * @author: zangch
     * @describe: 230. 二叉搜索树中第K小的元素
     * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
     * @date: 2021-11-19
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (--k == 0) {
                    return cur.val;
                }
                cur = cur.right;
            }
        }
        return -1;
    }
    /**
     * @author: zangch
     * @describe: 437. 路径总和 III
     * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
     *
     * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     * @date: 2021-11-19
     */
    public int pathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0, true);
    }
    private int dfs(TreeNode root, int targetSum, int sum, boolean cur) {
        if (root == null) return 0;
        return ((root.val + sum == targetSum) ? 1 : 0) + dfs(root.left, targetSum, sum + root.val, false) + dfs(root.right, targetSum, sum + root.val, false)
                + ((cur) ? (dfs(root.left, targetSum, 0, true) + dfs(root.right, targetSum, 0, true)) : 0);
    }
}