package org.example;

/**
 * 数组元素积的符号
 *
 * @author xiaojie.huang
 * @date 2024-01-16
 */
public class Solution1822 {

    public int arraySign(int[] nums) {
        int val = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return 0;
            }
            val = nums[i] < 0 ? -val : val;
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1822().arraySign(new int[] {2, 3}));
    }


}
