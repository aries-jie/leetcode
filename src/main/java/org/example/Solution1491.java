package org.example;

/**
 * 去掉最低工资和最高工资后的工资平均值
 *
 * @author xiaojie.huang
 * @date 2024-01-23
 */
public class Solution1491 {
    public double average(int[] salary) {
        int max = salary[0];
        int min = salary[0];
        int total = 0;
        for (int item : salary) {
            total += item;
            max = Math.max(item, max);
            min = Math.min(item, min);
        }
        return (double) (total - max - min) / (double) (salary.length - 2);
    }

    public static void main(String[] args) {
    }

}
