package org.example;

import java.util.Arrays;

/**
 * 矩阵置零
 *
 * @author xiaojie.huang
 * @date 2024-01-12
 */
public class Solution73 {

    public void setZeroes(int[][] matrix) {
        // 记录需要置换为0的行和列
        int x = matrix.length;
        int y = matrix[0].length;
        boolean[] zeroX = new boolean[x];
        boolean[] zeroY = new boolean[y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] == 0) {
                    zeroX[i] = true;
                    zeroY[j] = true;
                }
            }
        }
        // 把行标记为0
        for (int i = 0; i < x; i++) {
            if (zeroX[i]) {
                for (int j = 0; j < y; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 把列标记为0
        for (int i = 0; i < y; i++) {
            if (zeroY[i]) {
                for (int j = 0; j < x; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test1() {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        new Solution73().setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    private static void test2() {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        new Solution73().setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

}
