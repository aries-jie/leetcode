package org.example;

import java.util.Arrays;

/**
 * 滑动窗口最大值
 *
 * @author xiaojie.huang
 * @date 2024-01-13
 */
public class Solution239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[] res = new int[length - k + 1];

        int maxIndex = findMaxIndex(nums, 0, k);
        for (int i = 0; i <= length - k; i++) {
            int lastIndex = i + k - 1;
            if (nums[lastIndex] >= nums[maxIndex]) {
                // 当前新加入的值大于之前的最大值
                maxIndex = lastIndex;
            } else if (i > maxIndex) {
                // 之前的最大值已经超出窗口外，则重新计算
                maxIndex = findMaxIndex(nums, i, k);
            }
            res[i] = nums[maxIndex];
        }
        return res;
    }

    private int findMaxIndex(int[] nums, int start, int k) {
        int maxIndex = start;
        for (int i = start + 1; i < start + k; i++) {
            if (nums[i] >= nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        // [3,3,5,5,6,7]
        System.out.println(Arrays.toString(new Solution239().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        // [1]
        System.out.println(Arrays.toString(new Solution239().maxSlidingWindow(new int[]{1}, 1)));
        // [7,4]
        System.out.println(Arrays.toString(new Solution239().maxSlidingWindow(new int[]{7,2,4}, 2)));
    }

}
