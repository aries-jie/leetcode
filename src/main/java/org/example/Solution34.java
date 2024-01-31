package org.example;

import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author xiaojie.huang
 * @date 2024-01-31
 */
public class Solution34 {

    /**
     * 5 7 7 8 8 10    8
     * 0 5 mid=2
     * 2 5 mid=3
     *
     * 5 7 7 8 8 10    6
     * 0 5 mid=2
     * 0 2 mid=1
     * 0 1 mid=0
     *
     *
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        Arrays.fill(result, -1);

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // 找到了，就去找到真实的位置
                result[0] = mid;
                result[1] = mid;
                while (result[0] >= 0 && nums[result[0]] == target) {
                    result[0]--;
                }
                result[0]++;

                while (result[1] < nums.length && nums[result[1]] == target) {
                    result[1]++;
                }
                result[1]--;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution34().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
//        System.out.println(Arrays.toString(new Solution34().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(new Solution34().searchRange(new int[]{}, 0)));
    }

}
