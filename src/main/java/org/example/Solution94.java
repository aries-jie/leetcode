package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * @author xiaojie.huang
 * @since 2023-12-19
 */
public class Solution94 {

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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        fds(root, result);
        return result;
    }

    public void fds(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        fds(node.left, result);
        result.add(node.val);
        fds(node.right, result);
    }



    public static void main(String[] args) {

    }

}
