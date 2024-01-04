package org.example;

/**
 * 搜索二维矩阵
 *
 * @author xiaojie.huang
 * @date 2024-01-04
 */
public class Solution74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int total = matrix.length * matrix[0].length;
        int start = 0;
        int end = total;
        while (start < end) {
            if (start == end - 1) {
                return getIndexNum(matrix, start) == target || (total > end && getIndexNum(matrix, end) == target);
            }
            int mid = (start + end) / 2;
            int curNum = getIndexNum(matrix, mid);
            if (curNum > target) {
                end = mid;
            } else if (curNum < target) {
                start = mid;
            } else {
                return true;
            }
        }
        return false;
    }

    private static int getIndexNum(int[][] matrix, int index) {
        int row = index / matrix[0].length;
        int column = index % matrix[0].length;
        return matrix[row][column];
    }

    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 60}
//        };
//        System.out.println(new Solution74().searchMatrix(matrix, 3));
//        System.out.println(new Solution74().searchMatrix(matrix, 13));

        int[][] matrix = {
                {1}
        };
        System.out.println(new Solution74().searchMatrix(matrix, 0));
    }


}
