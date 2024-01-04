package org.example;

/**
 * 搜索插入位置
 *
 * @author xiaojie.huang
 * @date 2024-01-04
 */
public class Solution35 {

    public int searchInsert(int[] nums, int target) {
        return search(nums, target, 0, nums.length);
    }

    public int search(int[] nums, int target, int start, int end) {
        if (start + 1 == end || start == end) {
            if (nums[start] >= target) {
                return start;
            }
            return end;
        }
        int mid = (start + end) / 2;
        if (nums[mid] < target) {
            return search(nums, target, mid, end);
        } else if (nums[mid] > target) {
            return search(nums, target, start, mid);
        } else {
            return mid;
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution35().searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(new Solution35().searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(new Solution35().searchInsert(new int[]{1, 3, 5, 6}, 7));
    }


}
