package org.example;

/**
 * 二进制求和
 *
 * @author xiaojie.huang
 * @date 2024-01-25
 */
public class Solution67 {

    public String addBinary(String a, String b) {
        int max = Math.max(a.length(), b.length());
        int[] result = new int[max];

        char[] aAry = a.toCharArray();
        char[] bAry = b.toCharArray();
        for (int i = 0; i < max; i++) {
            if (a.length() > i) {
                result[i] += aAry[aAry.length - i - 1] - '0';
            }
            if (b.length() > i) {
                result[i] += bAry[bAry.length - i - 1] - '0';
            }
        }

        for (int i = 0; i < result.length - 1; i++) {
            if (result[i] > 1) {
                result[i] = result[i] % 2;
                ++result[i + 1];
            }
        }
        StringBuilder sb = new StringBuilder();
        if (result[result.length - 1] > 2) {
            sb.append("11");
        } else if (result[result.length - 1] > 1) {
            sb.append("10");
        } else if (result[result.length - 1] > 0) {
            sb.append("1");
        } else {
            return "0";
        }
        for (int i = result.length - 2; i >= 0; i--) {
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(new Solution67().addBinary("11", "1"));
//        System.out.println(new Solution67().addBinary("1010", "1011"));
//        System.out.println(new Solution67().addBinary("0", "0"));
        System.out.println(new Solution67().addBinary("1111", "1111"));
    }

}
