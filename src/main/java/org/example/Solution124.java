package org.example;

/**
 * 二叉树中的最大路径和
 *
 * @author xiaojie.huang
 * @date 2024-01-28
 */
public class Solution124 {
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

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max(root);
        return max;
    }

    private int max(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = max(root.left);
        int right = max(root.right);
        left = Math.max(left, 0);
        right = Math.max(right, 0);
        max = Math.max(root.val + left + right, max);
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    private static void test1() {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        a1.left = a2;
        a1.right = a3;
        System.out.println(new Solution124().maxPathSum(a1));
    }

    private static void test2() {
        TreeNode a1 = new TreeNode(-10);
        TreeNode a2 = new TreeNode(9);
        TreeNode a3 = new TreeNode(20);
        TreeNode a4 = new TreeNode(15);
        TreeNode a5 = new TreeNode(7);
        a1.left = a2;
        a1.right = a3;
        a3.left = a4;
        a3.right = a5;
        System.out.println(new Solution124().maxPathSum(a1));
    }

    private static void test3() {
        TreeNode a1 = new TreeNode(5);

        TreeNode a2 = new TreeNode(4);
        TreeNode a3 = new TreeNode(8);

        TreeNode a4 = new TreeNode(11);
        TreeNode a5 = new TreeNode(13);
        TreeNode a6 = new TreeNode(4);

        TreeNode a7 = new TreeNode(7);
        TreeNode a8 = new TreeNode(2);
        TreeNode a9 = new TreeNode(1);

        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a3.left = a5;
        a3.right = a6;
        a4.left = a7;
        a4.right = a8;
        a6.right = a9;

        System.out.println(new Solution124().maxPathSum(a1));
    }


}
