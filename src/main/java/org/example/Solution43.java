package org.example;

/**
 * 字符串相乘
 *
 * @author xiaojie.huang
 * @date 2024-01-24
 */
public class Solution43 {
    /**
     * 123 * 456
     * 123 * 456 = 123 * 6 + 123 * 5 * 10 + 123 * 4 * 100
     * 123 * 6 = 6 * 3 + 6 * 2 * 10 + 6 * 1 * 100 = 18 + 120 + 600 = 738
     */
    public String multiply(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();

        int[] result = new int[num1.length() + num2.length()];
        for (int i = 0; i < chars1.length; i++) {
            int mul1 = chars1.length - i - 1;
            for (int j = 0; j < chars2.length; j++) {
                int mul2 = chars2.length - j - 1;
                int cur = (chars1[i] - '0') * (chars2[j] - '0');
                result[result.length - mul1 - mul2 - 1] += cur;
            }
        }

        // 对超出位数的进1
        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] >= 10) {
                result[i - 1] = result[i - 1] + result[i] / 10;
                result[i] = result[i] % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (result[i] > 0) {
                for (int j = i; j < result.length; j++) {
                    sb.append(result[j]);
                }
                break;
            }
        }
        return sb.length() > 0 ? sb.toString() : "0";
    }

    public static void main(String[] args) {
//        System.out.println(new Solution43().multiply("123", "456"));
//        System.out.println(new Solution43().multiply("0", "0"));;
        System.out.println(new Solution43().multiply("5", "12"));;
    }

}
