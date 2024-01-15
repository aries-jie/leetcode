package org.example;

/**
 * 重复的子字符串
 *
 * @author xiaojie.huang
 * @date 2024-01-15
 */
public class Solution459 {

    public boolean repeatedSubstringPattern(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            int n = i + 1;
            if (s.length() % n == 0) {
                boolean flag = true;
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j % n) != s.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution459().repeatedSubstringPattern("abab"));
//        System.out.println(new Solution459().repeatedSubstringPattern("ababab"));
//        System.out.println(new Solution459().repeatedSubstringPattern("aba"));
//        System.out.println(new Solution459().repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(new Solution459().repeatedSubstringPattern("aabaaba"));
    }

}
