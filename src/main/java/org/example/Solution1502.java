package org.example;

import java.util.Arrays;

/**
 * 判断能否形成等差数列
 *
 * @author xiaojie.huang
 * @date 2024-01-17
 */
public class Solution1502 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length > 2) {
            Arrays.sort(arr);
            int dif = arr[1] - arr[0];
            for (int i = 2; i < arr.length; i++) {
                if (arr[i - 1] + dif != arr[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1502().canMakeArithmeticProgression(new int[]{1, 5, 3}));
        System.out.println(new Solution1502().canMakeArithmeticProgression(new int[]{1, 2, 4}));
    }
}
