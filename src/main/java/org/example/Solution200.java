package org.example;

/**
 * 岛屿数量
 *
 * @author xiaojie.huang
 * @date 2023-12-28
 */
public class Solution200 {
    /**
     * 1 1 1
     * 0 1 0
     * 1 1 1
     */
    int x, y;
    int[][] marked;
    public int numIslands(char[][] grid) {
        x = grid.length;
        y = grid[0].length;
        marked = new int[x][y];

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && marked[i][j] == 0) {
                    marked[i][j] = 1;
                    count++;
                    markLink(grid, i, j);
                }
            }
        }
        return count;
    }

    // 标记当前的相邻节点是同一片岛屿
    private void markLink(char[][] grid, int i, int j) {
        // 标记左边的节点
        if (i > 0) {
            if (grid[i - 1][j] == '1' && marked[i - 1][j] == 0) {
                marked[i - 1][j] = 1;
                markLink(grid, i - 1, j);
            }
        }
        // 标记右边的节点
        if (i < x - 1) {
            if (grid[i + 1][j] == '1' && marked[i + 1][j] == 0) {
                marked[i + 1][j] = 1;
                markLink(grid, i + 1, j);
            }
        }
        // 标记上边的节点
        if (j > 0) {
            if (grid[i][j - 1] == '1' && marked[i][j - 1] == 0) {
                marked[i][j - 1] = 1;
                markLink(grid, i, j - 1);
            }
        }
        // 标记下边的节点
        if (j < y - 1) {
            if (grid[i][j + 1] == '1' && marked[i][j + 1] == 0) {
                marked[i][j + 1] = 1;
                markLink(grid, i, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        char[][] a = {
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'},
        };
        System.out.println(new Solution200().numIslands(a));;
    }

}
