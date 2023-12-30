package org.example;

import java.util.*;

/**
 * 课程表
 *
 * @author xiaojie.huang
 * @date 2023-12-30
 */
public class Solution207 {

    // index 表示前置课程，value 表示后置课程
    List<List<Integer>> edge;
    int[] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 初始化
        visited = new int[numCourses];
        edge = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edge.add(new ArrayList<>());
        }
        for (int[] item : prerequisites) {
            edge.get(item[1]).add(item[0]);
        }

        // 深度遍历
        for (int c = 0; c < numCourses && valid; c++) {
            if (visited[c] == 0) {
                dfs(c);
            }
        }
        return valid;
    }

    private void dfs(int c) {
        visited[c] = 1;
        for (int i : edge.get(c)) {
            if (visited[i] == 0) {
                dfs(i);
                if (!valid) {
                    return;
                }
            } else if (visited[i] == 1) { // 死循环直接终止
                valid = false;
                return;
            }
        }
        visited[c] = 2;
    }

    public static void main(String[] args) {
        System.out.println(new Solution207().canFinish(2, new int[][]{{1, 0}}));
        System.out.println(new Solution207().canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(new Solution207().canFinish(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}));
    }

}
