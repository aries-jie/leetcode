package org.example;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口最大值
 *
 * @author xiaojie.huang
 * @date 2024-01-13
 */
public class Solution239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[] res = new int[length - k + 1];

        int maxIndex = findMaxIndex(nums, 0, k);
        for (int i = 0; i <= length - k; i++) {
            int lastIndex = i + k - 1;
            if (nums[lastIndex] >= nums[maxIndex]) {
                // 当前新加入的值大于之前的最大值
                maxIndex = lastIndex;
            } else if (i > maxIndex) {
                // 之前的最大值已经超出窗口外，则重新计算
                maxIndex = findMaxIndex(nums, i, k);
            }
            res[i] = nums[maxIndex];
        }
        return res;
    }

    private int findMaxIndex(int[] nums, int start, int k) {
        int maxIndex = start;
        for (int i = start + 1; i < start + k; i++) {
            if (nums[i] >= nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * 单调队列（按索引对应的值从大到小存放）
     *
     * 1  3  -1  -3  5  3  6  7
     * 初始化(i=0~2)：1  3  -1
     * 队列：0
     * 队列：1
     * 队列：1 2
     * 答案：[3]
     *
     * 下一个窗口（i=3）：3  -1  -3
     * 队列：1 2 3
     * 答案：[3, 3]
     *
     * 下一个窗口（i=4）：-1  -3  5
     * 队列：1 2
     * 队列：1
     * 队列：
     * 队列：4
     * 答案：[3, 3, 5]
     *
     * 下一个窗口（i=5）：-3  5  3
     * 队列：4, 5
     * 答案：[3, 3, 5, 5]
     *
     * 下一个窗口（i=6）：5  3  6
     * 队列：4
     * 队列：
     * 队列：6
     * 答案：[3, 3, 5, 5, 6]
     *
     * 下一个窗口（i=7）：3  6  7
     * 队列：
     * 队列：7
     * 答案：[3, 3, 5, 5, 6, 7]
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
//        test();
        test1();
    }

    private static void test() {
        // [3,3,5,5,6,7]
        System.out.println(Arrays.toString(new Solution239().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        // [1]
        System.out.println(Arrays.toString(new Solution239().maxSlidingWindow(new int[]{1}, 1)));
        // [7,4]
        System.out.println(Arrays.toString(new Solution239().maxSlidingWindow(new int[]{7,2,4}, 2)));
    }

    private static void test1() {
        // [3,3,5,5,6,7]
        System.out.println(Arrays.toString(new Solution239().maxSlidingWindow2(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        // [1]
//        System.out.println(Arrays.toString(new Solution239().maxSlidingWindow(new int[]{1}, 1)));
        // [7,4]
//        System.out.println(Arrays.toString(new Solution239().maxSlidingWindow(new int[]{7,2,4}, 2)));
    }

}
