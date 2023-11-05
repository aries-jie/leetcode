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


    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis2(int n) {
        if(n <= 0){
            return res;
        }
        getParenthesis("",n,n);
        return res;
    }

    private void getParenthesis(String str,int left, int right) {
        if(left == 0 && right == 0 ){
            res.add(str);
            return;
        }
        if(left == right){
            //剩余左右括号数相等，下一个只能用左括号
            getParenthesis(str+"(",left-1,right);
        }else if(left < right){
            //剩余左括号小于右括号，下一个可以用左括号也可以用右括号
            if(left > 0){
                getParenthesis(str+"(",left-1,right);
            }
            getParenthesis(str+")",left,right-1);
        }
    }

}
