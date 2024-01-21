package org.example;

import java.util.Arrays;

/**
 * 最富有客户的资产总量
 *
 * @author xiaojie.huang
 * @date 2024-01-21
 */
public class Solution1672 {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            max = Math.max(max, Arrays.stream(account).sum());
        }
        return max;
    }

    public static void main(String[] args) {
    }

}
