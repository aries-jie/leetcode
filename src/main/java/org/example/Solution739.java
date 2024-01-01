package org.example;

import java.util.*;

/**
 * 每日温度
 *
 * @author xiaojie.huang
 * @date 2024-01-01
 */
class Solution739 {

    /**
     * 73 74 75 71 69 72 76 73
     * 1  1  4  2  1  1  0  0
     *                   .
     *       .
     *    .
     * .                     .
     *                .
     *          .
     *             .
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        for (int i = length - 1; i >= 0; --i) {
            int warmerIndex = Integer.MAX_VALUE;
            for (int t = temperatures[i] + 1; t <= 100; ++t) {
                if (next[t] < warmerIndex) {
                    warmerIndex = next[t];
                }
            }
            if (warmerIndex < Integer.MAX_VALUE) {
                ans[i] = warmerIndex - i;
            }
            next[temperatures[i]] = i;
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution739().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
//        System.out.println(Arrays.toString(new Solution739().dailyTemperatures(new int[]{30, 40, 50, 60})));
//        System.out.println(Arrays.toString(new Solution739().dailyTemperatures(new int[]{30, 60, 90})));
//        System.out.println(Arrays.toString(new Solution739().dailyTemperatures(new int[]{99, 99, 99, 99, 99, 99, 99, 100})));
    }
}