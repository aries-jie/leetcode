package org.example;


/**
 * 单词搜索
 *
 * @author xiaojie.huang
 * @date 2024-01-06
 */
class Solution79 {

    boolean found = false;
    int rowLength;
    int colLength;
    int[] row = {-1, 0, 0, 1};
    int[] col = {0, 1, -1, 0};
    public boolean exist(char[][] board, String word) {
        rowLength = board.length;
        colLength = board[0].length;
        char[] wordChar = word.toCharArray();
        boolean[][] visited = new boolean[rowLength][colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (board[i][j] == wordChar[0]) {
                    backTrace(board, wordChar, 0, visited, i, j);
                }
                if (found) {
                    return found;
                }
            }
        }
        return false;
    }

    private void backTrace(char[][] board, char[] wordChar, int nextWord, boolean[][] visited, int x, int y) {
        if (wordChar.length == nextWord + 1) {
            found = true;
            return;
        }
        // 记录本次的匹配记录
        visited[x][y] = true;
        // 从上下左右查找
        for (int i = 0; i < 4; i++) {
            int nextX = x + row[i];
            int nextY = y + col[i];
            if (nextX >= 0 && nextX < rowLength && nextY >= 0 && nextY < colLength && !visited[nextX][nextY]
                    && nextWord + 1 < wordChar.length && board[nextX][nextY] == wordChar[nextWord + 1]) {
                backTrace(board, wordChar, nextWord + 1, visited, nextX, nextY);
            }
        }
        // 回退记录
        visited[x][y] = false;
    }


    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String work = "ABCCED"; // true

//        char[][] board = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        };
//        String work = "SEE";// true

//        char[][] board = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        };
//        String work = "ABCB"; // false

//        char[][] board = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'E', 'S'},
//                {'A', 'D', 'E', 'E'}
//        };
//        String work = "ABCESEEEFS"; // true

//        char[][] board = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        };
//        String work = "ABCB"; // false
        System.out.println(new Solution79().exist(board, work));
    }
}