package org.example;

/**
 * 找出井字棋的获胜者
 *
 * @author xiaojie.huang
 * @date 2024-01-21
 */
public class Solution1275 {

    /**
     * X
     *  X
     * OOX
     */
    public String tictactoe(int[][] moves) {
        // 初始化棋盘
        int[][] plate = new int[3][3];
        for (int i = 0; i < moves.length; i += 2) {
            plate[moves[i][0]][moves[i][1]] = 1;
        }
        for (int i = 1; i < moves.length; i += 2) {
            plate[moves[i][0]][moves[i][1]] = 2;
        }

        // 先判断有没有获胜
        int winner = 0;
        for (int x = 0; x < 3; x++) {
            if (plate[x][0] == plate[x][1] && plate[x][0] == plate[x][2]) {
                winner = plate[x][0];
            } else if (plate[0][x] == plate[1][x] && plate[0][x] == plate[2][x]) {
                winner = plate[0][x];
            }
        }
        if (plate[0][0] == plate[1][1] && plate[1][1] == plate[2][2]) {
            winner = plate[1][1];
        }
        if (plate[0][2] == plate[1][1] && plate[1][1] == plate[2][0]) {
            winner = plate[1][1];
        }
        if (winner > 0) {
            return winner == 1 ? "A" : "B";
        }

        // 再判断还能不能继续游戏，不能返回 Draw
        if (moves.length == 9) {
            return "Draw";
        }

        // 游戏继续
        return "Pending";
    }

    public static void main(String[] args) {
    }

}
