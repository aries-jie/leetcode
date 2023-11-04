package org.example;


import java.util.*;

/**
 * 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @author xiaojie.huang
 * @date 2023-11-04
 */
public class Solution17 {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        Map<Character, char[]> numMap = new HashMap<>();
        numMap.put('2', new char[]{'a', 'b', 'c'});
        numMap.put('3', new char[]{'d', 'e', 'f'});
        numMap.put('4', new char[]{'g', 'h', 'i'});
        numMap.put('5', new char[]{'j', 'k', 'l'});
        numMap.put('6', new char[]{'m', 'n', 'o'});
        numMap.put('7', new char[]{'p', 'q', 'r', 's'});
        numMap.put('8', new char[]{'t', 'u', 'v'});
        numMap.put('9', new char[]{'w', 'x', 'y', 'z'});

        Set<String> everyKindOfStr = new HashSet<>();

        char[] chars = digits.toCharArray();
        for (char c : chars) {
            mergeString(everyKindOfStr, numMap.get(c));
        }
        return new ArrayList<>(everyKindOfStr);
    }

    private void mergeString(Set<String> set, char[] ary) {
        Set<String> temp = new HashSet<>();
        if (set.size() == 0) {
            for (char c : ary) {
                temp.add(String.valueOf(c));
            }
        } else {
            for (String exist : set) {
                for (char c : ary) {
                    temp.add(exist + c);
                }
            }
        }
        set.clear();
        set.addAll(temp);
    }

}
