package org.example;


import java.util.Arrays;

/**
 * 只出现一次的数字
 * 给你一个 非空 整数数组 `nums`, 除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 *
 * @author xiaojie.huang
 * @date 2023-12-11
 */
public class Solution136 {
    /**
     * 我的第一次解法
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i+=2) {
            if (nums[i - 1] != nums[i]) {
                return nums[i - 1];
            }
        }
        if (nums.length > 1) {
            return nums[nums.length - 1];
        } else {
            return nums[0];
        }
    }

    /**
     * 大神解法
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution136().singleNumber(new int[]{ 2, 2, 1 }));;
        System.out.println(new Solution136().singleNumber(new int[]{ 4, 1, 2, 1, 2 }));;
        System.out.println(new Solution136().singleNumber(new int[]{ 1 }));;
        System.out.println(new Solution136().singleNumber(new int[]{ -336,513,-560,-481,-174,101,-997,40,-527,-784,-283,-336,513,-560,-481,-174,101,-997,40,-527,-784,-283,354 }));;
    }

}
