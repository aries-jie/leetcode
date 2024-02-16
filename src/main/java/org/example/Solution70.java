package org.example;


import java.util.HashMap;
import java.util.Map;

/**
 * 爬楼梯
 *
 * @author xiaojie.huang
 * @date 2024-02-16
 */
public class Solution70 {

    /**
     * f(n) = f(n-1) + f(n-2)
     * f(3) = f(2) + f(1) = 2 + 1 = 3
     * f(2) = f(1) + 1 = 2
     * f(1) = 1
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        } else {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(1, 1);
            map.put(2, 2);
            for (int i = 3; i <= n; i++) {
                map.put(i, map.get(i - 1) + map.get(i - 2));
            }
            return map.get(n);
        }
    }

    public static void main(String[] args) {
    }

}
