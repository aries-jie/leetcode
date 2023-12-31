package org.example;

/**
 * 颜色分类
 *
 * @author xiaojie.huang
 * @date 2023-12-31
 */
public class Solution75 {

    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;
        int i = 0, count = 0;
        while (count < nums.length) {
            count++;
            if (nums[i] == 0) {
                nums[red] = 0;
                ++red;
                ++i;
            } else if (nums[i] == 1) {
                ++white;
                ++i;
            } else {
                int last = nums.length - blue - 1;
                int temp = nums[last];
                nums[last] = nums[i];
                nums[i] = temp;

                ++blue;
            }
        }
        while (white > 0) {
            nums[red + --white] = 1;
        }
    }

    public static void main(String[] args) {
//        new Solution75().sortColors(new int[] {2,0,2,1,1,0});
//        new Solution75().sortColors(new int[] {2,0,1});
        new Solution75().sortColors(new int[] {1,0,1});
    }

}
