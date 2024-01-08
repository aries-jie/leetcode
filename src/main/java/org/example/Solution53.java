package org.example;


/**
 * 最大子数组和
 *
 * @author xiaojie.huang
 * @date 2024-01-08
 */
public class Solution53 {

    /**
     * -2 1 -3 4 -1 2 1 -5 4
     *
     *       .         .
     *       .         .
     *       .   .     .
     *   .   .   . .   .
     * ------------------------------
     * .   .   .     .
     * .   .         .
     *     .         .
     *               .
     *               .
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int count = nums[0];
        int target = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i] + count) {
                count = nums[i];
                target = Math.max(target, count);
            } else {
                count += nums[i];
                target = Math.max(target, count);
            }
        }
        return target;
    }

    public static void main(String[] args) {
        System.out.println(new Solution53().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new Solution53().maxSubArray(new int[]{5, 4, -1, 7, 8}));
        System.out.println(new Solution53().maxSubArray(new int[]{-1}));
        System.out.println(new Solution53().maxSubArray(new int[]{-1, -2, 3}));
        System.out.println(new Solution53().maxSubArray(new int[]{-2, -1}));
    }

}
