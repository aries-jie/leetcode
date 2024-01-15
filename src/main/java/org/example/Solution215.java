package org.example;

import java.util.*;

/**
 * 数组中的第K个最大元素
 *
 * @author xiaojie.huang
 * @date 2024-01-15
 */
public class Solution215 {


    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > queue.peek()) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.peek();

    }

    public static void main(String[] args) {
//        System.out.println(new Solution215().findKthLargest(new int[] {3,2,1,5,6,4}, 2));
        System.out.println(new Solution215().findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));
    }

}
