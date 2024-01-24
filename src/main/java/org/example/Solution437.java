package org.example;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 路径总和 III
 *
 * @author xiaojie.huang
 * @date 2024-01-24
 */
public class Solution437 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    int total = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return total;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode pop = deque.pollFirst();
            dfs(pop, targetSum);
            if (pop.left != null) {
                deque.addLast(pop.left);
            }
            if (pop.right != null) {
                deque.addLast(pop.right);
            }
        }
        return total;
    }

    private void dfs(TreeNode node, int targetSum) {
        if (node == null) {
            return;
        }
        if (node.val == targetSum) {
            ++total;
        }
        foundTarget(node.left, node.val, targetSum);
        foundTarget(node.right, node.val, targetSum);
    }

    private void foundTarget(TreeNode node, long count, long target) {
        if (node == null) {
            return;
        }
        count += node.val;
        if (count == target) {
            ++total;
        }
        foundTarget(node.left, count, target);
        foundTarget(node.right, count, target);
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1000000000);
        TreeNode a2 = new TreeNode(1000000000);
        TreeNode a3 = new TreeNode(294967296);
        TreeNode a4 = new TreeNode(1000000000);
        TreeNode a5 = new TreeNode(1000000000);
        TreeNode a6 = new TreeNode(1000000000);
        a1.left = a2;
        a2.left = a3;
        a3.left = a4;
        a4.left = a5;
        a5.left = a6;
        System.out.println(new Solution437().pathSum(a1, 0));
    }

}
