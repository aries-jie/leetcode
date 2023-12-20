package org.example;


import java.util.*;

/**
 * 回文链表
 * @author xiaojie.huang
 * @since 2023-12-16
 */
public class Solution104 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class Result {
        int depth;
    }

    public int maxDepth(TreeNode root) {
        Result a = new Result();
        fds(root, 1, a);
        return a.depth;
    }

    void fds(TreeNode root, int depth, Result max) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            // 叶子节点
            if (max.depth < depth) {
                max.depth = depth;
            }
        } else {
            fds(root.left, depth + 1, max);
            fds(root.right, depth + 1, max);
        }
    }

    /**
     * 官方题解
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth2(root.left);
            int rightHeight = maxDepth2(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
    }

}
