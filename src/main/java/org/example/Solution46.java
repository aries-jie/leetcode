package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 *
 * @author xiaojie.huang
 * @date 2024-01-03
 */
public class Solution46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrace(new ArrayList<>(), nums, new boolean[nums.length], res);
        return res;
    }

    private void backtrace(List<Integer> choise, int[] nums, boolean[] selected, List<List<Integer>> res) {
        if (choise.size() == nums.length) {
            res.add(new ArrayList<>(choise));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!selected[i]) {
                choise.add(nums[i]);
                selected[i] = true;

                backtrace(choise, nums, selected, res);

                choise.remove(choise.size() - 1);
                selected[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution46().permute(new int[]{1, 2, 3}));
    }


}
