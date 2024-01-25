package org.example;

/**
 * 缀点成线
 *
 * @author xiaojie.huang
 * @date 2024-01-25
 */
public class Solution1232 {
    /**
     *
     * 1,2
     * 2,3
     * 3,4
     *
     * ax + b = y
     * a + b = 2;
     * 2a + b = 3;
     * 2a - a = 3 - 2;
     * a = 1
     *
     *
     * a + b = 2;
     * 3a + b = 4;
     *
     */
    public boolean checkStraightLine(int[][] coordinates) {
        // 找斜率 和 偏移量
        int y = coordinates[1][1] - coordinates[0][1];
        int x = coordinates[1][0] - coordinates[0][0];
        double a = x == 0 ? 0 : (double) y / x;
        double b = coordinates[0][1] - a * coordinates[0][0];

        boolean flag = true;
        boolean xLine = true;
        boolean yLine = true;
        x = coordinates[0][0];
        y = coordinates[0][1];
        for (int[] coordinate : coordinates) {
            if (flag && coordinate[0] * a + b != coordinate[1]) {
                flag = false;
            }
            if (coordinate[0] != x) {
                xLine = false;
            }
            if (coordinate[1] != y) {
                yLine = false;
            }
            if (!flag && !xLine && !yLine) {
                break;
            }
        }
        return flag || xLine || yLine;
    }

    public static void main(String[] args) {
        int[][] coordinates = {
                {0, 0},
                {0, 1},
                {0, -1}
        };
        System.out.println(new Solution1232().checkStraightLine(coordinates));
    }

}
