package org.example;

/**
 * 最后一个单词的长度
 *
 * @author xiaojie.huang
 * @date 2024-01-18
 */
public class Solution58 {

    public int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (length > 0) {
                    break;
                }
            } else {
                ++length;
            }
        }
        return length;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution58().lengthOfLastWord("Hello World"));
//        System.out.println(new Solution58().lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(new Solution58().lengthOfLastWord("luffy is still joyboy"));
    }

}
