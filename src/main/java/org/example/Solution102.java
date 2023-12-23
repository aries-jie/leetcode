package org.example;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 * @author xiaojie.huang
 * @since 2023-12-23
 */
public class Solution102 {

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    public void dfs(TreeNode root, int index, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        // 添加该层的节点
        if (result.size() <= index) {
            result.add(new ArrayList<>());
        }
        result.get(index).add(root.val);

        // 继续添加孩子节点
        dfs(root.left, index + 1, result);
        dfs(root.right, index + 1, result);
    }

    public void bfs(TreeNode root, List<List<Integer>> result) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                // 当前层的数据出队
                TreeNode node = queue.poll();
                list.add(node.val);
                // 如果有孩子节点，入队
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(list);
        }
    }

}
