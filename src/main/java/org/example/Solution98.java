package org.example;


/**
 * 验证二叉搜索树
 *
 * @author xiaojie.huang
 * @date 2023-12-27
 */
public class Solution98 {

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

    public boolean isValidBST(TreeNode root) {
        return validNode(root.left, null, root.val) && validNode(root.right, root.val, null);
    }

    public boolean validNode(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        boolean result = false;
        if (min == null) {
            result = root.val < max;
        } else if (max == null) {
            result = root.val > min;
        } else {
            result = root.val > min && root.val < max;
        }
        return result && validNode(root.left, min, root.val) && validNode(root.right, root.val, max);
    }

    public static void main(String[] args) {

    }

}
