package org.example;


/**
 * 打家劫舍
 *
 * @author xiaojie.huang
 * @date 2024-02-19
 */
public class Solution198 {

    /**
     * nums = 1 2 3 1
     * 推导出公式：dp[i] = max(nums[i] + dp[i - 2], dp[i - 1])
     * dp[0] = 1;
     * dp[1] = max(nums[0], nums[1]);
     * dp[2] = max(3 + 1, 2) = 4;
     * dp[3] = max(1 + 2, 4) = 4;
     *
     */
    public int rob(int[] nums) {
        int l = nums.length;
        if (l == 1) {
            return nums[0];
        }
        if (l == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[l];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < l; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[l - 1];
        /*
        // 使用 O(1) 空间
        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);
        for (int i = 2; i < l; i++) {
            int c = Math.max(nums[i] + a, b);
            a = b;
            b = c;
        }
        return b;*/
    }


    public static void main(String[] args) {
    }

}
