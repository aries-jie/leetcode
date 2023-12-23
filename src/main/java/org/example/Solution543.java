package org.example;


/**
 * 二叉树的直径
 * @author xiaojie.huang
 * @since 2023-12-22
 */
public class Solution543 {

    public class TreeNode {
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

    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return ans;
    }
    public int maxDepth(TreeNode root){
        if(root==null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        ans = Math.max(ans,left+right);
        return Math.max(left,right)+1;

    }

    public static void main(String[] args) {
    }

}
