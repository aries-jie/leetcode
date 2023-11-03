package org.example;

/**
 * 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 * @author xiaojie.huang
 * @date 2023-11-01
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        boolean[][] db = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            db[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    db[i][j] = false;
                } else {
                    if (j - i < 3) {
                        db[i][j] = true;
                    } else {
                        db[i][j] = db[i + 1][j - 1];
                    }
                }
                if (db[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }


        return s.substring(begin, begin + maxLen);
    }
}
