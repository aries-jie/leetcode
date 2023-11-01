package org.example;

/**
 * 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * @author xiaojie.huang
 * @date 2023-11-01
 */
public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int mid = length / 2;

        int i = 0;
        int j = 0;
        int left = 0, right = 0;
        for (int leftCount = 0; leftCount <= mid; leftCount++) {
            left = right;
            if (i < nums1.length && (j >= nums2.length || nums1[i] < nums2[j])) {
                right = nums1[i++];
            } else {
                right = nums2[j++];
            }

        }
        if (length % 2 == 1) {
            return right;
        } else {
            return (left + right) / 2.0;
        }
    }
}
