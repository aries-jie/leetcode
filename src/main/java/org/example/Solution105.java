package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * @author xiaojie.huang
 * @date 2024-01-23
 */
public class Solution105 {
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        TreeNode root = dfs(preorder, inorderMap, 0, 0, preorder.length - 1);
        return root;
    }

    TreeNode dfs(int[] preorder, Map<Integer, Integer> inorderMap, int i, int l, int r) {
        if (r < l) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[i]);

        int m = inorderMap.get(preorder[i]);

        root.left = dfs(preorder, inorderMap, i + 1, l, m - 1);
        root.right = dfs(preorder, inorderMap, i + 1 + m - l, m + 1, r);

        return root;
    }

    public static void main(String[] args) {
    }

}
