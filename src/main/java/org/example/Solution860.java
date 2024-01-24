package org.example;

/**
 * 柠檬水找零
 *
 * @author xiaojie.huang
 * @date 2024-01-24
 */
public class Solution860 {
    public boolean lemonadeChange(int[] bills) {
        int[] money = new int[2];
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    ++money[0];
                    break;
                case 10:
                    if (money[0] > 0) {
                        --money[0];
                        ++money[1];
                    } else {
                        return false;
                    }
                    break;
                case 20:
                    if (money[1] > 0 && money[0] > 0) {
                        --money[0];
                        --money[1];
                    } else if (money[0] >= 3) {
                        money[0] -= 3;
                    } else {
                        return false;
                    }
                    break;
                default:
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }

}
