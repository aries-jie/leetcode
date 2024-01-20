package org.example;

import java.util.Arrays;

/**
 * 除自身以外数组的乘积
 *
 * @author xiaojie.huang
 * @date 2024-01-20
 */
public class Solution238 {

    /**
     * 输入
     *      1   2   3   4
     * 前缀积
     *      1   1   2   6
     * 后缀积
     *      24  12  4   1
     * 答案
     *      24  12  8   6
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        // 前缀积
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }
        // 计算后缀积同时计算答案
        int k = 1;
        for (int i = n - 2; i >= 0; i--) {
            k *= nums[i + 1];
            answer[i] *= k;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution238().productExceptSelf(new int[]{1, 2, 3, 4})));
    }

}
