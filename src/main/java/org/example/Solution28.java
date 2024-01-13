package org.example;

/**
 * 找出字符串中第一个匹配项的下标
 *
 * @author xiaojie.huang
 * @date 2024-01-13
 */
public class Solution28 {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        char c = needle.charAt(0);
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == c) {
                boolean flag = true;
                for (int j = 1; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution28().strStr("sadbutsad", "sad"));
//        System.out.println(new Solution28().strStr("leetcode", "leeto"));
        System.out.println(new Solution28().strStr("a", "a"));
    }
}
