package org.example;

import java.util.Arrays;

/**
 * 缺失的第一个正数
 *
 * @author xiaojie.huang
 * @date 2024-01-10
 */
public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);

        // 找 1 所在的索引
        int length = nums.length;
        int left = 0;
        int right = length;
        int firstIndex = -1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == 1) {
                firstIndex = mid;
                break;
            } else if (nums[mid] > 1) {
                if (right == mid) {
                    break;
                }
                right = mid;
            } else {
                if (left == mid) {
                    break;
                }
                left = mid;
            }
        }

        // 找不到 1，就返回 1
        if (firstIndex == -1) {
            return 1;
        }

        // 找到 1，就从 1 的位置开始找最小值
        int target = 1;
        int lastNum = 1;
        for (int j = firstIndex + 1; j < nums.length; j++) {
            if (nums[j] == lastNum) {
                continue;
            }
            lastNum = nums[j];

            if (nums[j] == target + 1) {
                target = target + 1;
                continue;
            }
            return target + 1;
        }
        return target + 1;
    }


    public static void main(String[] args) {
//        System.out.println(new Solution41().firstMissingPositive(new int[]{1, 2, 0}));
//        System.out.println(new Solution41().firstMissingPositive(new int[]{3, 4, -1, 1}));
//        System.out.println(new Solution41().firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
//        System.out.println(new Solution41().firstMissingPositive(new int[]{0, 2, 2, 1, 1}));
//        System.out.println(new Solution41().firstMissingPositive(new int[]{0, 2, 2, 1, 1, 3, 3}));
        System.out.println(new Solution41().firstMissingPositive(new int[]{0}));
    }

}
