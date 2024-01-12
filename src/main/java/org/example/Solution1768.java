package org.example;

/**
 * 交替合并字符串
 *
 * @author xiaojie.huang
 * @date 2024-01-12
 */
public class Solution1768 {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int min = Math.min(word1.length(), word2.length());
        int i = 0;
        while (i < min) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
            i++;
        }
        sb.append(word1.substring(min));
        sb.append(word2.substring(min));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution1768().mergeAlternately("abc", "pqr"));
        System.out.println(new Solution1768().mergeAlternately("", "pqr"));
        System.out.println(new Solution1768().mergeAlternately("abc", ""));
    }

}
