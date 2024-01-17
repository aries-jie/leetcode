package org.example;

/**
 * 单调数列
 *
 * @author xiaojie.huang
 * @date 2024-01-17
 */
public class Solution896 {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        if (n > 2) {
            int more = 0;
            int less = 0;
            for (int i = 1; i < n; i++) {
                if (nums[i] > nums[i - 1]) {
                    ++more;
                } else if (nums[i] < nums[i - 1]) {
                    ++less;
                }
                if (more > 0 && less > 0) {
                    return false;
                }
            }
            return more == 0 || less == 0;
        }
        return true;
    }

    public static void main(String[] args) {
    }

}
