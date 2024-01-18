package org.example;

import java.util.*;

/**
 * 二叉树的右视图
 *
 * @author xiaojie.huang
 * @date 2024-01-18
 */
public class Solution199 {

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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root, 0);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode node, int index) {
        if (node == null) {
            return;
        }
        if (res.size() < index + 1) {
            res.add(node.val);
        } else {
            res.set(index, node.val);
        }
        dfs(res, node.left, index + 1);
        dfs(res, node.right, index + 1);
    }

    public static void main(String[] args) {
    }

}
