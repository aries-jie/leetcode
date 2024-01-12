package org.example;

/**
 * 找不同
 *
 * @author xiaojie.huang
 * @date 2024-01-12
 */
public class Solution389 {

    public char findTheDifference(String s, String t) {
        char count = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            count += t.charAt(i);
            count -= s.charAt(i);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution389().findTheDifference("abc", "abcd"));
    }

}
