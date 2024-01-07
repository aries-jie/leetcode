package org.example;


/**
 * 买卖股票的最佳时机
 *
 * @author xiaojie.huang
 * @since 2024-01-07
 */
public class Solution121 {
    /**
     *                  .
     *   .             .  .
     *  .   .         .
     * .      .     .
     *         . . .
     */
    public int maxProfit(int[] prices) {
        int bottom = prices[0];
        int top = prices[0];
        int target = 0;
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (price > top) {
                top = price;
                if (top - bottom > target) {
                    target = top - bottom;
                }
            }
            if (price < bottom) {
                bottom = price;
                top = price;
            }
        }
        return target;
    }

    public static void main(String[] args) {
        System.out.println(new Solution121().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new Solution121().maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(new Solution121().maxProfit(new int[]{5, 6, 5, 3, 2, 1}));
    }

}
