package org.example;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 * @author xiaojie.huang
 * @date 2023-11-05
 */
public class Solution20 {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pre = stack.pop();
                if (!(pre == '{' && c == '}') && !(pre == '(' && c == ')') && !(pre == '[' && c == ']')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
