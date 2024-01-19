package org.example;

import java.util.Arrays;

/**
 * 棒球比赛
 *
 * @author xiaojie.huang
 * @date 2024-01-19
 */
public class Solution682 {
    public int calPoints(String[] operations) {
        int[] record = new int[operations.length];
        int i = -1;
        for (int j = 0; j < operations.length; j++) {
            switch (operations[j]) {
                case "+":
                    record[i + 1] = record[i] + record[i - 1];
                    ++i;
                    continue;
                case "D":
                    record[i + 1] = record[i] * 2;
                    ++i;
                    continue;
                case "C":
                    record[i] = 0;
                    --i;
                    continue;
                default:
                    record[i + 1] = new Integer(operations[j]);
                    ++i;
            }
        }
        return Arrays.stream(record).sum();
    }

    public static void main(String[] args) {
        System.out.println(new Solution682().calPoints(new String[]{"5", "2", "C", "D", "+"}));;
        System.out.println(new Solution682().calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));;
    }

}
