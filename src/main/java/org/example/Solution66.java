package org.example;

import java.util.Arrays;

/**
 * 加一
 *
 * @author xiaojie.huang
 * @date 2024-01-16
 */
public class Solution66 {

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        ++digits[n - 1];
        for (int i = n - 1; i > 0; i--) {
            if (digits[i] == 10) {
                digits[i] = 0;
                ++digits[i - 1];
            } else {
                break;
            }
        }
        if (digits[0] == 10) {
            int[] res = new int[n + 1];
            res[0] = 1;
            return res;
        } else {
            return digits;
        }

    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution66().plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(new Solution66().plusOne(new int[]{9, 9, 9})));
        System.out.println(Arrays.toString(new Solution66().plusOne(new int[]{8, 9, 9})));
    }

}
