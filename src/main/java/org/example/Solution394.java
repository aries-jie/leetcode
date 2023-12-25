package org.example;


import java.util.*;

/**
 * 字符串解码
 * @author xiaojie.huang
 * @since 2023-12-25
 */
public class Solution394 {

    int index = 0;
    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();

        while (index < s.length()) {
            char cur = s.charAt(index);
            if (Character.isDigit(cur)) {
                // 获取一个数字并进栈
                stack.addLast(getDigits(s));
            } else if (Character.isLetter(cur) || cur == '[') {
                index++;
                stack.add(String.valueOf(cur));
            } else {
                index++;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stack.peekLast())) {
                    sub.addLast(stack.removeLast());
                }
                Collections.reverse(sub);

                // 左括号
                stack.removeLast();

                // 数字
                int repTime = Integer.parseInt(stack.removeLast());
                StringBuilder t = new StringBuilder();
                String o = getString(sub);
                // 构造字符串
                while (repTime-- > 0) {
                    t.append(o);
                }
                // 将构造好的字符串入栈
                stack.addLast(t.toString());
            }
        }

        return getString(stack);
    }

    public String getDigits(String s) {
        StringBuilder ret = new StringBuilder();
        while (Character.isDigit(s.charAt(index))) {
            ret.append(s.charAt(index++));
        }
        return ret.toString();
    }

    public String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }


    public static void main(String[] args) {

    }

}
