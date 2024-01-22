package org.example;

/**
 * 矩阵对角线元素的和
 *
 * @author xiaojie.huang
 * @date 2024-01-21
 */
public class Solution1572 {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int mid = n / 2;
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += mat[i][i];
            count += mat[i][n - i - 1];
        }
        if (n % 2 == 1) {
            count -= mat[mid][mid];
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1,2,3},{4,5,6},{7,8,9}
        };
        System.out.println(new Solution1572().diagonalSum(mat));
    }

}
