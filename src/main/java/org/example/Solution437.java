package org.example;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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
        /*TreeNode a1 = new TreeNode(1000000000);
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
        System.out.println(new Solution437().pathSum(a1, 0));*/

        TreeNode a1 = new TreeNode(10);
        TreeNode a2 = new TreeNode(5);
        TreeNode a3 = new TreeNode(-3);
        TreeNode a4 = new TreeNode(3);
        TreeNode a5 = new TreeNode(2);
        TreeNode a6 = new TreeNode(11);
        TreeNode a7 = new TreeNode(3);
        TreeNode a8 = new TreeNode(-2);
        TreeNode a9 = new TreeNode(1);

        a1.left = a2;
        a1.right = a3;

        a2.left = a4;
        a2.right = a5;

        a3.right= a6;

        a4.left = a7;
        a4.right = a8;

        a5.right = a9;

        System.out.println(new Solution437().pathSum2(a1, 8));
    }

    /**
     * 前缀和
     */
    public int pathSum2(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<Long, Integer>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        curr += root.val;

        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }

}
