package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 螺旋矩阵
 *
 * @author xiaojie.huang
 * @date 2024-01-12
 */
public class Solution54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;

        // 定义每次需要调转的方向
        int direction = 0; // 定义：0 向右 1 向下 2 向左 3 向右
        int[] directionX = {0, 1, 0, -1};
        int[] directionY = {1, 0, -1, 0};

        // 存放已经遍历的数据
        boolean[][] visited = new boolean[x][y];
        int visitedCount = 0;

        List<Integer> res = new ArrayList<>();
        // 将起点定义在原点的左边
        int i = 0;
        int j = -1;
        while (visitedCount < x * y) {
            // 根据方向，当前需要遍历的位置
            i += directionX[direction];
            j += directionY[direction];

            // 如果下一个越界了或者已经遍历了，则需要向右转向继续遍历
            if (i == x || j == y || j < 0 || visited[i][j]) {
                // 退回
                i -= directionX[direction];
                j -= directionY[direction];
                // 下一次的方向
                direction = (direction + 1) % 4;
                continue;
            }
            visitedCount++;
            visited[i][j] = true;
            res.add(matrix[i][j]);
        }
        return res;
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
        System.out.println(new Solution54().spiralOrder(matrix));
    }

    private static void test2() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(new Solution54().spiralOrder(matrix));
    }

}
