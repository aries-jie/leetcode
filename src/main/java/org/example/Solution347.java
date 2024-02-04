package org.example;

import java.util.*;

/**
 * 前 K 个高频元素
 *
 * @author xiaojie.huang
 * @date 2024-02-03
 */
public class Solution347 {


    public static class Item {
        private Integer num;
        private Integer count;

        public Item(Integer num, Integer count) {
            this.num = num;
            this.count = count;
        }

        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

    }

    /**
     *
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (Integer num : map.keySet()) {
            if (queue.size() < k) {
                queue.offer(num);
            } else if (map.get(num) > map.get(queue.peek())) {
                queue.remove();
                queue.offer(num);
            }
        }

        int[] result = new int[k];
        int j = 0;
        while (!queue.isEmpty()) {
            result[j++] = queue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution347().topKFrequent(new int[]{1, 1, 1, 2, 2,2,2,2,2,2,2,2, 3,3,3,3,3,3}, 2)));
//        System.out.println(Arrays.toString(new Solution347().topKFrequent(new int[]{1}, 1)));
        System.out.println(Arrays.toString(new Solution347().topKFrequent(new int[]{-1, -1}, 1)));
    }

}
