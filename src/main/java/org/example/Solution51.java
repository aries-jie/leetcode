package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N 皇后
 *
 * @author xiaojie.huang
 * @date 2024-02-01
 */
public class Solution51 {

    /**
     * 以一个 4 行 4 列为例
     * 00 01 02 03
     * 10 11 12 13
     * 20 21 22 23
     * 30 31 32 33
     * <p>
     * 左上角视图长度=2*4-1
     * int i=y-x+n-1
     * 右上角视图长度=2*4-1
     * int j=x+y
     */
    boolean[] leftTop;
    boolean[] rightTop;
    boolean[] column;
    List<List<String>> result = new ArrayList<>();
    char[] row;
    public List<List<String>> solveNQueens(int n) {
        leftTop = new boolean[2 * n - 1];
        rightTop = new boolean[2 * n - 1];
        column = new boolean[n];
        row = new char[n];
        Arrays.fill(row, '.');

        backTrack(n, 0, new ArrayList<>());
        return result;
    }

    private void backTrack(int n, int x, List<String> tempResult) {
        if (n == x) {
            result.add(new ArrayList<>(tempResult));
            return;
        }
        // 尝试每一列
        for (int y = 0; y < n; y++) {
            if (!column[y] && !leftTop[y-x+n-1] && !rightTop[x+y]) {
                column[y] = true;
                leftTop[y-x+n-1] = true;
                rightTop[x+y] = true;
                tempResult.add(newRow(n, y));

                backTrack(n, x + 1, tempResult);

                column[y] = false;
                leftTop[y-x+n-1] = false;
                rightTop[x+y] = false;
                tempResult.remove(tempResult.size() - 1);
            }
        }
    }

    private String newRow(int n, int col) {
        row[col] = 'Q';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(row[i]);
        }
        row[col] = '.';
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution51().solveNQueens(4));
    }

}
