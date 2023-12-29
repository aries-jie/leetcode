package org.example;

/**
 * 腐烂的橘子
 *
 * @author xiaojie.huang
 * @date 2023-12-29
 */
public class Solution994 {

    /**
     * 2 1 1
     * 0 1 1
     * 1 0 1
     */
    int count, x, y;
    public int orangesRotting(int[][] grid) {
        x = grid.length;
        y = grid[0].length;
        rotting(grid);
        return count;
    }

    private void rotting(int[][] grid) {
        // 当前腐烂个数
        int rotBefore = calTargetCount(grid, 2);

        // 执行腐烂
        doRotting(grid);

        // 腐烂一次后的个数
        int rotAfter = calTargetCount(grid, 2);

        if (rotBefore == rotAfter) {
            // 如果个数不变则没办法继续侵蚀了，这个时候如果有 1 则表明有橘子永远不会腐烂
            if (calTargetCount(grid, 1) > 0) {
                count = -1;
            }
        } else {
            count++;
            // 继续下一次侵蚀
            rotting(grid);
        }
    }

    /**
     * 对 grid 进行侵蚀
     */
    private void doRotting(int[][] grid) {
        // 拿到腐烂的橘子
        int[][] record = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == 2) {
                    record[i][j] = 2;
                }
            }
        }

        // 侵蚀
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (record[i][j] == 2) {
                    // 标记左边的节点
                    if (i > 0 && grid[i - 1][j] == 1) grid[i - 1][j] = 2;
                    // 标记右边的节点
                    if (i < x - 1 && grid[i + 1][j] == 1) grid[i + 1][j] = 2;
                    // 标记上边的节点
                    if (j > 0 && grid[i][j - 1] == 1) grid[i][j - 1] = 2;
                    // 标记下边的节点
                    if (j < y - 1 && grid[i][j + 1] == 1) grid[i][j + 1] = 2;
                }
            }
        }
    }

    /**
     * 计算 grid 有多少个 val
     */
    private int calTargetCount(int[][] grid, int val) {
        int res = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == val) {
                    ++res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[][] a = {
//                {2,1,1},
//                {1,1,0},
//                {0,1,1},
//        };
//        int[][] a = {
//                {2,1,1},
//                {0,1,1},
//                {1,0,1},
//        };
        int[][] a = {
                {0, 2}
        };
        System.out.println(new Solution994().orangesRotting(a));;
    }

}
