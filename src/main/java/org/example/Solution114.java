package org.example;

/**
 * 二叉树展开为链表
 *
 * @author xiaojie.huang
 * @date 2024-01-19
 */
public class Solution114 {
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

    TreeNode dummy = new TreeNode();
    TreeNode next = dummy;
    public void flatten(TreeNode root) {
        if (root != null) {
            dfs(root);
            root.left = null;
            root.right = dummy.right.right;
        }
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        next.right = new TreeNode(root.val);
        next = next.right;
        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        TreeNode a6 = new TreeNode(6);
        a1.left = a2;
        a1.right = a5;
        a2.left = a3;
        a2.right = a4;
        a5.right = a6;
        new Solution114().flatten(a1);
        System.out.println(a1);
    }

}
