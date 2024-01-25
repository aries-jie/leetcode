package org.example;

import java.util.Arrays;

/**
 * 三角形的最大周长
 *
 * @author xiaojie.huang
 * @date 2024-01-25
 */
public class Solution976 {
    /**
     * 两条小的边相加大于最大的边即可组成
     */
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution976().largestPerimeter(new int[]{2, 1, 2}));
        System.out.println(new Solution976().largestPerimeter(new int[]{1, 2, 1, 10}));
    }

}
