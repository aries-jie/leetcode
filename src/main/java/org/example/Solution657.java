package org.example;

/**
 * 机器人能否返回原点
 *
 * @author xiaojie.huang
 * @date 2024-01-20
 */
public class Solution657 {
    public boolean judgeCircle(String moves) {
        if(moves.length() % 2 == 1) {
            return false;
        }
        int[] direction = new int['Z'];
        for (char c : moves.toCharArray()) {
            ++direction[c];
        }
        return direction['U'] == direction['D'] && direction['L'] == direction['R'];
    }

    public static void main(String[] args) {
        System.out.println(new Solution657().judgeCircle("UD"));
        System.out.println(new Solution657().judgeCircle("LL"));
    }

}
