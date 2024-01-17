package org.example;

/**
 * 二叉搜索树中第K小的元素
 *
 * @author xiaojie.huang
 * @date 2024-01-17
 */
public class Solution230 {

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

    int count = 0;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        dfs(root.left, k);

        // 中序遍历
        ++count;
        // 拿到第 k 个值提前结束
        if (count == k) {
            res = root.val;
            return ;
        }

        dfs(root.right, k);
    }

    public static void main(String[] args) {
    }


}
