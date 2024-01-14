package org.example;

/**
 * 有效的字母异位词
 *
 * @author xiaojie.huang
 * @date 2024-01-14
 */
public class Solution242 {

    static final char FIRST = 'a';
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] source = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ++source[s.charAt(i) - FIRST];
        }
        for (int i = 0; i < t.length(); i++) {
            --source[t.charAt(i) - FIRST];
        }
        for (int i = 0; i < source.length; i++) {
            if (source[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution242().isAnagram("anagram", "nagarae"));
    }


}
