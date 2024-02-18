package org.example;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 柱状图中最大的矩形
 *
 * @author xiaojie.huang
 * @date 2024-02-18
 */
public class Solution84 {

    /**
     * 单调栈
     */
    public int largestRectangleArea(int[] heights) {
        int[] newHeights = new int[heights.length + 2];
        for (int i = 0; i < heights.length; i++) {
            newHeights[i + 1] = heights[i];
        }
        int area = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.addLast(0);
        for (int i = 1; i < newHeights.length; i++) {
            while (newHeights[stack.peekLast()] > newHeights[i]) {
                int height = newHeights[stack.pollLast()];
                int width = i - stack.peekLast() - 1;
                area = Math.max(area, height * width);
            }
            stack.addLast(i);
        }
        return area;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution84().largestRectangleArea(new int[]{2, 1, 2}));
        System.out.println(new Solution84().largestRectangleArea(new int[]{2, 1, 5,6,2,3}));
//        System.out.println(new Solution84().largestRectangleArea(new int[]{4,2,0,3,2,5}));
//        System.out.println(new Solution84().largestRectangleArea(new int[]{4,2,0,3,2,4,3,4}));
    }

}
