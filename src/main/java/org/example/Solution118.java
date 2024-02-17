package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *
 * @author xiaojie.huang
 * @date 2024-02-17
 */
public class Solution118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>(){{this.add(1);}});
        if (numRows == 1) {
            return result;
        }
        result.add(new ArrayList<Integer>(){{this.add(1);this.add(1);}});
        if (numRows == 2) {
            return result;
        }
        for (int i = 3; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i - 1; j++) {
                list.add(result.get(i - 2).get(j - 1) + result.get(i - 2).get(j));
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }



    public static void main(String[] args) {
        new Solution118().generate(5);
    }

}
