package org.example;


import java.util.Arrays;

/**
 * 轮转数组
 *
 * @author xiaojie.huang
 * @date 2024-01-09
 */
public class Solution189 {

    /**
     * 解法 2：原地替换
     * 向右轮转 2
     * 1      2      3      4      5      6      7
     * 6      7      1      2      3      4      5
     * 0-2+7  1-2+7  2-2+7  3-2+7  4-2+7  5-2+7  6-2+7    %7
     * 开始交换：每次都把当前值给别的位置，然后循环
     * 1      2      3      4      5      6      7
     * 1-------------^
     * 1      2      1      4      5      6      7
     *               3-------------^
     * 1      2      1      4      3      6      7
     *                             5-------------^
     * 1      2      1      4      3      6      5
     *        ^----------------------------------7
     *                             5-------------^
     * 1      7      1      4      3      6      5
     *        2-------------^
     * 1      7      1      2      3      6      5
     *                      4-------------^
     * 1      7      1      2      3      4      5
     * ^----------------------------------6
     * 6      7      1      2      3      4      5
     */
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        if (k == 0) {
            return;
        }

        int count = 0;
        int round = 0;
        int startIndex = 0;
        int startNum = nums[startIndex];
        while (count < length) {
            int nextIndex = (startIndex+k)%length;

            int tempNum = nums[nextIndex];
            nums[nextIndex] = startNum;

            startIndex = nextIndex;
            startNum = tempNum;
            count++;

            if (startIndex == round) {
                round += 1;
                startIndex = round;
                startNum = nums[startIndex];
            }
        }
    }

    /**
     * 解法 1：多一份存储
     * 向右轮转 2
     * 1      2      3      4      5      6      7
     * 6      7      1      2      3      4      5
     * 0-2+7  1-2+7  2-2+7  3-2+7  4-2+7  5-2+7  6-2+7    %7
     */
    public void rotate1(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        int[] copy = Arrays.copyOf(nums, length);
        for (int i = 0; i < length; i++) {
            nums[i] = copy[(i-k+length)%length];
        }
    }

    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test1() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new Solution189().rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

    private static void test2() {
        int[] nums = {1, 2, 3, 4};
        new Solution189().rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

}
