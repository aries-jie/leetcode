package org.example;


import java.util.*;

/**
 * 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * @author xiaojie.huang
 * @date 2023-11-05
 */
public class Solution22 {
    public List<String> generateParenthesis(int n) {
        Set<String> ans = new HashSet<>();
        Set<String> tempAns = new HashSet<>();
        for (int i = 0; i < n * 2; i++) {
            if (ans.size() == 0) {
                ans.add("(");
            } else {
                tempAns.clear();
                for (String s : ans) {
                    tempAns.addAll(getMayBeSet(s, n));
                }
                ans.clear();
                ans.addAll(tempAns);
            }
        }

        return new ArrayList<>(ans);
    }

    private Set<String> getMayBeSet(String s, int n) {
        int left = 0;
        int right = 0;

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                left++;
            } else {
                right++;
            }
        }

        Set<String> ans = new HashSet<>();
        if (left == right) {
            ans.add(s + "(");
        } else if (left == n) {
            ans.add(s + ")");
        } else {
            ans.add(s + "(");
            ans.add(s + ")");
        }
        return ans;
    }

}
