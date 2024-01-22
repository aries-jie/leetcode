package org.example;

/**
 * 在区间范围内统计奇数数目
 *
 * @author xiaojie.huang
 * @date 2024-01-22
 */
public class Solution1523 {

    /**
     * 1 - 7  -> 1 3 5 7   6/2 + 1
     * 1 - 8  -> 1 3 5 7   7/2 + 1
     * 2 - 7  -> 3 5 7     5/2 + 1
     * 1 - 6  -> 1 3 5     5/2 + 1
     * 2 - 6  -> 3 5       4/2
     *
     * （high - low） / 2
     */
    public int countOdds(int low, int high) {
        return (high - low) / 2 + (low % 2 == 1 || high % 2 == 1 ? 1 : 0);
    }

    public static void main(String[] args) {

    }

}
