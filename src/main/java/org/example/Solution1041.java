package org.example;

/**
 * 困于环中的机器人
 *
 * @author xiaojie.huang
 * @date 2024-01-22
 */
public class Solution1041 {
    public boolean isRobotBounded(String instructions) {
        // 方位对应的xy加减
        int[] xDir = {0, 1, 0, -1};
        int[] yDir = {1, 0, -1, 0};
        // 起点以及方向
        int x = 0;
        int y = 0;
        int direction = 0;

        char[] chars = instructions.toCharArray();
        for (char c : chars) {
            switch (c) {
                case 'L':
                    direction = (direction + 3) % 4;
                    break;
                case 'R':
                    direction = (direction + 1) % 4;
                    break;
                default:
                    x += xDir[direction];
                    y += yDir[direction];
            }
        }
        return (x == 0 && y == 0) || direction != 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1041().isRobotBounded("GGLLGG"));
        System.out.println(new Solution1041().isRobotBounded("GG"));
        System.out.println(new Solution1041().isRobotBounded("GL"));
    }

}
