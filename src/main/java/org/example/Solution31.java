package org.example;


import java.util.Arrays;

/**
 * 下一个排列
 *
 * @author xiaojie.huang
 * @date 2024-01-05
 */
public class Solution31 {

    /**
     * 1 2 3 4
     * 1                                          2                                        3               4
     * 12             13           14             21           23             24
     * 123    124     132  134     142  143       213  214     231     234    241  243
     * 1234   1243    1324 1342    1423 1432      2134 2143    2314    2341   2413 2431
     *         ^^
     *         4 大于 2，把 2 后面的大于 2 的最小值跟 2 交换，剩下的从小到大排列
     */
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int changeIndex = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                changeIndex = i;
                break;
            }
        }
        // 全交换
        if (changeIndex == -1) {
            Arrays.sort(nums);
            return;
        }
        // 在 changeIndex 后面找到下一个比 num[changeIndex] 大的值，剩下的全部重新排序
        int[] copy = Arrays.copyOfRange(nums, changeIndex, nums.length);
        Arrays.sort(copy);

        // 把比 num[changeIndex] 大的值放到第一位
        int changeNum = nums[changeIndex];
        for (int i = 0; i < copy.length; i++) {
            if (copy[i] > changeNum) {
                int temp = copy[i];
                for (int j = i; j > 0; j--) {
                    copy[j] = copy[j - 1];
                }
                copy[0] = temp;
                break;
            }
        }

        // 把排好序的替换回原数组
        for (int i = changeIndex; i < nums.length; i++) {
            nums[i] = copy[i - changeIndex];
        }
    }

    public static void main(String[] args) {
//        int[] nums = {3, 2, 1};
//        int[] nums = {2, 3, 1};
//        int[] nums = {1, 2, 4, 3};
//        int[] nums = {1, 3, 4, 2};
        int[] nums = {2, 3, 4, 1};
        new Solution31().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

}
