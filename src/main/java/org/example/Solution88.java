package org.example;

import java.util.Arrays;

/**
 * 合并两个有序数组
 *
 * @author xiaojie.huang
 * @date 2024-01-30
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] num1Copy = Arrays.copyOf(nums1, m);
        int i = 0;
        int j = 0;
        while (i < m || j < n) {
            if (i == m) {
                nums1[i + j] = nums2[j];
                j++;
            } else if (j == n) {
                nums1[i + j] = num1Copy[i];
                i++;
            } else {
                if (num1Copy[i] > nums2[j]) {
                    nums1[i + j] = nums2[j];
                    j++;
                } else {
                    nums1[i + j] = num1Copy[i];
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        new Solution88().merge(nums1, 3, new int[] {2, 5, 6}, 3);
        System.out.println(Arrays.toString(nums1));
    }

}
