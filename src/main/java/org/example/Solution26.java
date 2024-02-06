package org.example;


/**
 * 删除有序数组中的重复项
 *
 * @author xiaojie.huang
 * @date 2024-02-06
 */
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int lastIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[lastIndex]) {
                nums[++lastIndex] = nums[i];
            }
        }
        return lastIndex + 1;
    }

    public static void main(String[] args) {
    }

}
