package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和
 *
 * @author xiaojie.huang
 * @date 2024-01-04
 */
public class Solution39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrace(new ArrayList<>(), candidates, 0, target, res);
        return res;
    }

    private void backtrace(List<Integer> choise, int[] nums, int start, int target, List<List<Integer>> res) {
        if (0 == target) {
            res.add(new ArrayList<>(choise));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) {
                return;
            }
            choise.add(nums[i]);
            backtrace(choise, nums, i, target - nums[i], res);
            choise.remove(choise.size() - 1);
        }
    }


    public static void main(String[] args) {
//        System.out.println(new Solution39().combinationSum(new int[]{1, 2, 3}, 6));
//        System.out.println(new Solution39().combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(new Solution39().combinationSum(new int[]{8, 7, 4, 3}, 11));
    }


}
