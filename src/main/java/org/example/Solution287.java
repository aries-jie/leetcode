package org.example;

/**
 * 寻找重复数
 *
 * @author xiaojie.huang
 * @date 2024-01-02
 */
public class Solution287 {

    public int findDuplicate(int[] nums) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (temp[nums[i]] > 0) {
                return nums[i];
            } else {
                temp[nums[i]] = 1;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(new Solution287().findDuplicate(new int[]{1,3,4,2,2}));
    }


}
