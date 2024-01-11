package org.example;

/**
 * 寻找旋转排序数组中的最小值
 *
 * @author xiaojie.huang
 * @date 2024-01-11
 */
public class Solution153 {

    /**
     * 场景1
     * 14 15 1 2 3 4 5 6 7 8 9 10 11 12 13
     * .               ^                .
     * 14 > 6，在该区间继续找
     * 14 15 1 2 3 4 5 6
     * .         ^     .
     * 14 > 3，在该区间继续找
     * 14 15 1 2 3
     * .     ^   .
     * 14 > 1，在该区间继续找
     * 14 15 1
     * .  ^  .
     * 15 > 1，在该区间继续找
     * 结果 = 1
     *
     *
     * 场景2
     * 5 6 7 8 9 1 2 3 4
     * .       ^       .
     * 9 > 4，在该区间继续找
     * 9 1 2 3 4
     * .   ^   .
     * 9 > 2，在该区间继续找
     * 9 1 2
     * . ^ .
     * 9 > 1，在该区间继续找
     * 结果 = 1
     *
     *
     * 场景3
     * 0 1 2 3 4 5 6 7
     * .       ^     .
     * 找不到左边小于右边的值，直接返回最左边的位置
     *
     *
     * 场景4
     * 3 4 5 1 2
     * .   ^   .
     * 5 > 2
     * 5 1 2
     * . ^ .
     * 5 > 1
     * 结果 = 1
     *
     * 场景5
     * 3 4 1 2
     * .   ^ .
     *
     *
     */
    public int findMin(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.min(nums[0], nums[1]);
        }
        int left = 0;
        int right = length - 1;
        while (true) {
            int mid = (left + right) / 2;
            if (nums[left] > nums[mid]) {
                if (left + 1 == mid) {
                    return nums[mid];
                }
                right = mid;
            } else if (nums[mid] > nums[right]) {
                if (mid + 1 == right) {
                    return nums[right];
                }
                left = mid;
            } else {
                return nums[left];
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution153().findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(new Solution153().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(new Solution153().findMin(new int[]{11, 13, 15, 17}));
    }

}
