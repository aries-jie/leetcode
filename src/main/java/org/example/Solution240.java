package org.example;

/**
 * 搜索二维矩阵 II
 *
 * @author xiaojie.huang
 * @date 2024-01-21
 */
public class Solution240 {


    /**
     * Z 字形查找:目标值 13
     * 1  4  7  11  15
     *              ^
     * 2  5  8  12  19
     * 3  6  9  16  22
     * 10 13 14 17  24
     *
     * 1  4  7  11  15
     *          ^
     * 2  5  8  12  19
     * 3  6  9  16  22
     * 10 13 14 17  24
     *
     * 1  4  7  11  15
     * 2  5  8  12  19
     *          ^
     * 3  6  9  16  22
     * 10 13 14 17  24
     *
     * 1  4  7  11  15
     * 2  5  8  12  19
     * 3  6  9  16  22
     *          ^
     * 10 13 14 17  24
     *
     * 1  4  7  11  15
     * 2  5  8  12  19
     * 3  6  9  16  22
     *       ^
     * 10 13 14 17  24
     *
     * 1  4  7  11  15
     * 2  5  8  12  19
     * 3  6  9  16  22
     * 10 13 14 17  24
     *       ^
     *
     * 1  4  7  11  15
     * 2  5  8  12  19
     * 3  6  9  16  22
     * 10 13 14 17  24
     *    ^
     *
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24}
        };
        System.out.println(new Solution240().searchMatrix(matrix, 13));
    }

}
