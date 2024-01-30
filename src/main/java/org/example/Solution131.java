package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 分割回文串
 *
 * @author xiaojie.huang
 * @date 2024-01-30
 */
public class Solution131 {
    boolean[][] f;
    List<List<String>> ret = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        backTrace(s, 0);
        return ret;
    }

    private void backTrace(String s, int start) {
        if (start == n) {
            ret.add(new ArrayList<>(ans));
        }
        for (int i = start; i < n; i++) {
            // 是回文串
            if (f[start][i]) {
                ans.add(s.substring(start, i + 1));
                backTrace(s, i + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution131().partition("abcde"));
    }

}
