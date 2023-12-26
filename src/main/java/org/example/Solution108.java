package org.example;


/**
 * 将有序数组转换为二叉搜索树
 *
 * @author xiaojie.huang
 * @date 2023-12-26
 */
public class Solution108 {

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

    public TreeNode sortedArrayToBST(int[] nums) {
        return getNode(nums, 0, nums.length);
    }

    /**
     * 1   2   3   4   5   6   7   8
     *                mid(4)              -> 0,4 | 5,8
     *                        mid(6)      -> 5,6 | 7,8
     *                            mid(7)  -> 7,7 | 8,8
     *                    mid(5)          -> 5,5 | 6,6
     *        mid(2)                      -> 0,2 | 3,4
     *    mid(1)                          -> 0,1 | 2,2
     * mid(0)                             -> 0,0 | 1,1
     */
    public TreeNode getNode(int[] nums, int start, int end) {
        if (start == end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = getNode(nums, start, mid);
        root.right = getNode(nums, mid + 1, end);
        return root;
    }


    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode treeNode = new Solution108().sortedArrayToBST(nums);
        System.out.println(treeNode);
    }

}
