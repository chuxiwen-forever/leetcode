package com.liu.week2.day1.p378;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/***
 * @description: <a href="https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/">leetcode p378 有序矩阵中第 K 小的元素 </a>。
 * @auther: chuxiwen
 * @date: 2023/9/24 16:18
 * @version 1.0
 */

public class Solve {

    // 暴力处理方法，存到一个数组中，排序找到
    public int kthSmallest(int[][] matrix, int k) {
        List<Integer> a = new ArrayList<>();
        for (int[] line : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                a.add(line[j]);
            }
        }
        Collections.sort(a);
        return a.get(k - 1);
    }

    // 使用优先队列 使用小根堆，先将所有的数组第一个数字存到队列中
    // 因为每一行都是顺序的，小根堆用来维护最小的，直到弹出第k小的数
    public int kthSmallest1(int[][] matrix, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            // 第一个参数是数组中的值，后面两个是坐标
            queue.add(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] curr = queue.poll();
            // 不能超出数组范围
            if (curr[2] != n - 1) {
                queue.add(new int[]{matrix[curr[1]][curr[2] + 1], curr[1], curr[2] + 1});
            }
        }
        return queue.poll()[0];
    }

    // 二分 因为比较小的都在左上角，比较大的都在右下角，所以不断靠近左上角，直到左上角只有k个数为止
    // 看见不会系列
    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length - 1;
        int left = matrix[0][0];
        int right = matrix[n][n];

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n;
        int j = 0;
        int num = 0;
        // 统计左上角有多少元素
        while (i >= 0 && j <= n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }
}