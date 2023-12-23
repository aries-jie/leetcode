package org.example;


import java.util.HashMap;
import java.util.Map;

/**
 * 距离原点最远的点
 * @author xiaojie.huang
 * @since 2023-12-23
 */
public class Solution2833 {
    public int furthestDistanceFromOrigin(String moves) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : moves.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Integer r = map.getOrDefault('R', 0);
        Integer l = map.getOrDefault('L', 0);
        Integer a = map.getOrDefault('_', 0);
        return Math.abs(r - l) + a;
    }
    public int furthestDistanceFromOrigin2(String moves) {
        int index=0;
        int num=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='L'){
                index++;
            }else if(moves.charAt(i)=='R'){
                index--;
            }else{
                num++;
            }
        }
        return Math.abs(index) + num;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2833().furthestDistanceFromOrigin2("L_RL__R"));
        System.out.println(new Solution2833().furthestDistanceFromOrigin2("_R__LL_"));
        System.out.println(new Solution2833().furthestDistanceFromOrigin2("_______"));
    }

}
