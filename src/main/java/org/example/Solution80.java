package org.example;


/**
 * 删除有序数组中的重复项 II
 *
 * @author xiaojie.huang
 * @date 2024-02-07
 */
public class Solution80 {
    public int removeDuplicates(int[] nums) {
        int lastIndex = 0;
        int lastCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[lastIndex] || lastCount < 2) {
                nums[++lastIndex] = nums[i];
            }
            if (nums[i] == nums[lastIndex - 1]) {
                ++lastCount;
            } else {
                lastCount = 1;
            }
        }
        return lastIndex + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int i = new Solution80().removeDuplicates(nums);
    }

}
