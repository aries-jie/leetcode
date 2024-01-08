package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 *
 * @author xiaojie.huang
 * @date 2024-01-08
 */
public class Solution56 {

    /**
     * ---
     *  -----
     *        ---
     *               ----
     * ------ ---    ---- line, 用 1 表示左边界，用 2 表示区间里面的值，3表示右边界，4表示重复值，如 [1, 1],就记录 1 的位置等于 4
     *
     * ----
     *     --
     * ------
     * 执行用时 2 ms
     */
    public int[][] merge(int[][] intervals) {
        // 找出最大值
        int max = 0;
        for (int[] item : intervals) {
            max = Math.max(item[1], max);
        }
        max += 1;

        // 映射区间值
        int[] line = new int[max];
        for (int[] item : intervals) {
            if (item[0] == item[1]) {
                if (line[item[0]] == 0) {
                    line[item[0]] = 4;
                }
            } else {
                // 处理左边界
                if (line[item[0]] == 0 || line[item[0]] == 4) {
                    line[item[0]] = 1;
                } else if (line[item[0]] == 3) {
                    line[item[0]] = 2;
                }

                // 处理右边界
                if (line[item[1]] == 0 || line[item[1]] == 4) {
                    line[item[1]] = 3;
                } else if (line[item[1]] == 1) {
                    line[item[1]] = 2;
                }

                // 处理区间
                for (int i = item[0] + 1; i < item[1]; i++) {
                    line[i] = 2;
                }
            }
        }

        // 根据虚拟的线的区间值来获取结果
        int[] record = new int[max * 2];
        int index = 0;
        for (int i = 0; i < line.length; i++) {
            // 记录新的区间
            if (line[i] == 4) {
                record[index++] = i;
                record[index++] = i;
            }
            else if (line[i] >= 1) {
                for (int j = i + 1; j < line.length; j++) {
                    if (line[j] == 3) {
                        record[index++] = i;
                        record[index++] = j;
                        i = j;
                        break;
                    }
                }
            }
        }
        int[][] target = new int[index / 2][2];
        for (int i = 0; i < index; i += 2) {
            target[i / 2][0] = record[i];
            target[i / 2][1] = record[i + 1];
        }
        return target;
    }

    /**
     * 官方解法，执行用时 9 ms
     */
    public int[][] merge2(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }


    public static void main(String[] args) {
        test1(); // [[1, 6], [8, 10], [15, 18]]
        test2(); // [[1, 5]]
        test3(); // [[1, 4]]
        test4(); // [[1, 4], [5, 6]]
        test5(); // [[0, 4]]
        test6(); // [[0, 0], [1, 4]]
        test7(); // [[2, 2], [3, 3], [4, 4], [5, 6]]
    }

    private static void test1() {
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        System.out.println(Arrays.deepToString(new Solution56().merge(intervals)));
    }

    private static void test2() {
        int[][] intervals = {
                {1, 4},
                {4, 5}
        };
        System.out.println(Arrays.deepToString(new Solution56().merge(intervals)));
    }

    private static void test3() {
        int[][] intervals = {
                {1, 4}
        };
        System.out.println(Arrays.deepToString(new Solution56().merge(intervals)));
    }

    private static void test4() {
        int[][] intervals = {
                {1, 4},
                {5, 6}
        };
        System.out.println(Arrays.deepToString(new Solution56().merge(intervals)));
    }

    private static void test5() {
        int[][] intervals = {
                {1, 4},
                {0, 4}
        };
        System.out.println(Arrays.deepToString(new Solution56().merge(intervals)));
    }

    private static void test6() {
        int[][] intervals = {
                {1, 4},
                {0, 0}
        };
        System.out.println(Arrays.deepToString(new Solution56().merge(intervals)));
    }

    private static void test7() {
        int[][] intervals = {
                {5, 6},
                {4, 4},
                {3, 3},
                {2, 2},
                {5, 5}
        };
        System.out.println(Arrays.deepToString(new Solution56().merge(intervals)));
    }

}
