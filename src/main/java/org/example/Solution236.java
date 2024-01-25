package org.example;

import java.util.*;

/**
 * 二叉树的最近公共祖先
 *
 * @author xiaojie.huang
 * @date 2024-01-25
 */
public class Solution236 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<List<TreeNode>> resultList = new ArrayList<>();
    List<TreeNode> tempList = new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        foundNode(root, p, q);
        if (resultList.size() == 2) {
            for (int i = resultList.get(0).size() - 1; i >= 0; i--) {
                if (resultList.get(1).contains(resultList.get(0).get(i))) {
                    return resultList.get(0).get(i);
                }
            }
        }
        return null;
    }

    private void foundNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return;
        }
        tempList.add(root);
        if (root.val == p.val || root.val == q.val) {
            resultList.add(new ArrayList<>(tempList));
            if (resultList.size() == 2) {
                return;
            }
        }
        foundNode(root.left, p, q);
        foundNode(root.right, p, q);
        tempList.remove(tempList.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(3);
        TreeNode a2 = new TreeNode(5);
        TreeNode a3 = new TreeNode(1);
        TreeNode a4 = new TreeNode(6);
        TreeNode a5 = new TreeNode(2);
        TreeNode a6 = new TreeNode(0);
        TreeNode a7 = new TreeNode(8);
        TreeNode a8 = new TreeNode(7);
        TreeNode a9 = new TreeNode(4);
        a1.left = a2;
        a1.right = a3;

        a2.left = a4;
        a2.right = a5;

        a3.left = a6;
        a3.right = a7;

        a5.left = a8;
        a5.right = a9;

        TreeNode treeNode = new Solution236().lowestCommonAncestor(a1, a2, a3);
        if (treeNode != null) {
            System.out.println(treeNode.val);
        }
    }

}
