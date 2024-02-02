package org.example;

/**
 * 搜索旋转排序数组
 *
 * @author xiaojie.huang
 * @date 2024-02-02
 */
public class Solution33 {

    /**
     * 4 5 6 7 0 1 2 3
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[right] > nums[mid]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution33().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(new Solution33().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
//        System.out.println(new Solution33().search(new int[]{5, 1, 3}, 5));
    }

}
