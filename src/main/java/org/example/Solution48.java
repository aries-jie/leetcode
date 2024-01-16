package org.example;

import java.util.Arrays;

/**
 * 旋转图像
 *
 * @author xiaojie.huang
 * @date 2024-01-16
 */
public class Solution48 {

    /**
     * 0,0  0,1  0,2  0,3
     * 1,0  1,1  1,2  1,3
     * 2,0  2,1  2,2  2,3
     * 3,0  3,1  3,2  3,3
     *
     * 4 * 4 的矩阵
     * 0,0  0,1
     * 0,3  1,3
     * 3,3  3,2
     * 3,0  2,0
     *
     * 1,1
     * 1,2
     * 2,2
     * 2,1
     *
     * 0,0  0,1  0,2
     * 1,0  1,1  1,2
     * 2,0  2,1  2,2
     *
     * 0,1
     * 1,2
     * 2,1
     * 1,0
     *
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int round = (n + 1) / 2;

        int[][] dir = new int[4][2];
        for (int i = 0; i < round; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                fillDir(dir, i, j, n);

                int temp = matrix[dir[0][0]][dir[0][1]];
                matrix[dir[0][0]][dir[0][1]] = matrix[dir[3][0]][dir[3][1]];
                matrix[dir[3][0]][dir[3][1]] = matrix[dir[2][0]][dir[2][1]];
                matrix[dir[2][0]][dir[2][1]] = matrix[dir[1][0]][dir[1][1]];
                matrix[dir[1][0]][dir[1][1]] = temp;
            }
        }
    }

    private void fillDir(int[][] dir, int x, int y, int n) {
        dir[0][0] = x;
        dir[0][1] = y;

        dir[1][0] = y;
        dir[1][1] = n - 1 - x;

        dir[2][0] = n - 1 - x;
        dir[2][1] = n - 1 - y;

        dir[3][0] = n - 1 - y;
        dir[3][1] = x;
    }


    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test1() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        new Solution48().rotate(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static void test2() {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        new Solution48().rotate(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

}
