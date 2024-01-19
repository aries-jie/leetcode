package org.example;


/**
 * 转换成小写字母
 *
 * @author xiaojie.huang
 * @date 2024-01-19
 */
public class Solution709 {

    public String toLowerCase(String s) {
        char[] res = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                res[i] = (char) (s.charAt(i) - 'A' + 'a');
            } else {
                res[i] = s.charAt(i);
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        System.out.println((int)'A');
        System.out.println((int)'Z');
        System.out.println((int)'a');
        System.out.println((int)'z');
        System.out.println(new Solution709().toLowerCase("Hello"));
        System.out.println(new Solution709().toLowerCase("here"));
        System.out.println(new Solution709().toLowerCase("LOVELY"));

    }

}
