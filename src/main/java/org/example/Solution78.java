package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 *
 * @author xiaojie.huang
 * @date 2024-01-04
 */
public class Solution78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrace(new ArrayList<>(), nums, 0, res);
        return res;
    }

    private void backtrace(List<Integer> choise, int[] nums, int start, List<List<Integer>> res) {
        res.add(new ArrayList<>(choise));
        for (int i = start; i < nums.length; i++) {
            if (choise.contains(nums[i])) {
                break;
            }
            choise.add(nums[i]);
            backtrace(choise, nums, start + 1, res);
            choise.remove(choise.size() - 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution78().subsets(new int[]{1, 2, 3}));
    }


}
