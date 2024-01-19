package org.example;

import java.util.Arrays;

/**
 * 移动零
 *
 * @author xiaojie.huang
 * @date 2024-01-19
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        int unZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[unZeroIndex++] = nums[i];
            }
        }
        for (int i = unZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Solution283().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
