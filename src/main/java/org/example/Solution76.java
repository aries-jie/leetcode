package org.example;

import java.util.*;

/**
 * 最小覆盖子串
 *
 * @author xiaojie.huang
 * @date 2024-01-14
 */
public class Solution76 {


    /**
     *  ADOBECODEBANC   ABC
     *  ^  ^ ^
     *  ADOBECODEBANC
     *     ^ ^    ^
     *  ADOBECODEBANC
     *       ^   ^^
     *  ADOBECODEBANC
     *           ^^ ^
     *
     *  先找出所有匹配的字符串的位置
     *  A B C B A  C
     *  0 3 5 9 10 12
     *
     *  能解决问题，但是最后几个用例超时了
     */
    public String minWindow(String s, String t) {
        // 初始化需要匹配的字符串
        int[] record = new int['z' - 'A' + 1];
        for (int i = 0; i < t.length(); i++) {
            ++record[t.charAt(i) - 'A'];
        }

        // 先找出所有匹配的字符串的位置
        List<Character> list = new ArrayList<>();
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (record[s.charAt(i) - 'A'] > 0) {
                list.add(s.charAt(i));
                index.add(i);
            }
        }

        // 找出符合要求的最小窗口
        int minLength = Integer.MAX_VALUE;
        int minIndex = -1;
        int maxIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            int[] copyRecord = Arrays.copyOf(record, record.length);
            int count = 0;
            int j = i;
            while (count < t.length() && j < list.size()) {
                if (copyRecord[list.get(j) - 'A'] > 0) {
                    --copyRecord[list.get(j) - 'A'];
                    count++;
                }
                j++;
            }
            if (count == t.length()) {
                int min = index.get(j - 1) - index.get(i) + 1;
                if (min < minLength) {
                    minLength = min;
                    minIndex = i;
                    maxIndex = j - 1;
                }
            }
        }

        if (minIndex >= 0) {
            return s.substring(index.get(minIndex), index.get(maxIndex) + 1);
        }
        return "";
    }


    /**
     * 利用左右两个指针
     * 刚开始，左指针固定，移动右指针，直到找到合适的边界，这个时候移动左指针，缩减范围，直到最短；以此类推找答案
     */
    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();
    public String minWindow2(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution76().minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println(new Solution76().minWindow("a", "a"));
//        System.out.println(new Solution76().minWindow("a", "aa"));
        System.out.println(new Solution76().minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd")); // abbbbbcdd
//        System.out.println(new Solution76().minWindow("aaabbbcdd", "abcdd")); // abbbcdd
    }

}
