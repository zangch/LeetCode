package com.github.zangch.leetcode.daily;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zangch
 * @describe:
 * @date: 2021-11-18
 */
class TreeNodeTest {

    private final TreeNode treeNode = new TreeNode();
    private final TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(5));
    private final List<Integer> result = new ArrayList<>();

    @Test
    void preOrder() {
        treeNode.preOrder(root, result);
        result.forEach(System.out::print);
    }
    @Test
    void postOrderTraversal() {
        treeNode.postOrderTraversal(root).forEach(System.out::print);
    }
    @Test
    void findTilt() {
        System.out.println(treeNode.findTilt(root));
    }
    @Test
    void minDiffInBST() {
        System.out.println(treeNode.minDiffInBST(root));
    }
    @Test
    void isCousins() {
        System.out.println(treeNode.isCousins(root,4,5));
    }
    @Test
    void kthSmallest() {
        System.out.println(treeNode.kthSmallest(root, 2));
    }
    @Test
    void pathSum() {
        System.out.println(treeNode.pathSum(root, 6));
    }
}