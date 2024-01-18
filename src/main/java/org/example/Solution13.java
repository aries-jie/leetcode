package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 *
 * @author xiaojie.huang
 * @date 2024-01-18
 */
public class Solution13 {

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int val = 0;
        int i = 0;
        while (i < s.length() - 1) {
            String two = s.substring(i, i + 2);
            if (map.containsKey(two)) {
                val += map.get(two);
                ++i;
            } else {
                val += map.get(s.substring(i, i + 1));
            }
            ++i;
        }
        if (i == s.length() - 1) {
            val += map.get(s.substring(s.length() - 1));
        }
        return val;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution13().romanToInt("I"));
//        System.out.println(new Solution13().romanToInt("II"));
//        System.out.println(new Solution13().romanToInt("III"));
//        System.out.println(new Solution13().romanToInt("IV"));
//        System.out.println(new Solution13().romanToInt("IX"));
//        System.out.println(new Solution13().romanToInt("LVIII"));
        System.out.println(new Solution13().romanToInt("MMMXLV"));
    }

}
