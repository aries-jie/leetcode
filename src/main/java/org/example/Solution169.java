package org.example;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * @author xiaojie.huang
 * @since 2023-12-11
 */
public class Solution169 {
    /**
     * 我的第一次解法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
     * Boyer-Moore 投票算法
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int count = 0;
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (count == 0) {
                res = nums[i];
                count++;
            } else if (res == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }

    /**
     * 排序算法
     * @param nums
     * @return
     */
    public int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    public static void main(String[] args) {
        System.out.println(new Solution169().majorityElement(new int[]{ 3, 2, 3 }));;
        System.out.println(new Solution169().majorityElement(new int[]{ 2, 2, 1, 1, 1, 2, 2 }));

        System.out.println(new Solution169().majorityElement2(new int[]{ 3, 2, 3 }));;
        System.out.println(new Solution169().majorityElement2(new int[]{ 2, 2, 1, 1, 1, 2, 2 }));

        System.out.println(new Solution169().majorityElement3(new int[]{ 3, 2, 3 }));;
        System.out.println(new Solution169().majorityElement3(new int[]{ 2, 2, 1, 1, 1, 2, 2 }));
    }

}
