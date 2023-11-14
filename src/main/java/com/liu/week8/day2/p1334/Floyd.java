package com.liu.week8.day2.p1334;

import java.util.Arrays;

/***
 * @description: <a href="https://leetcode.cn/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/">leetcode p1334. 阈值距离内邻居最少的城市</a>。
 * @auther: chuxiwen
 * @date: 2023/11/14 09:12
 * @version 1.0
 */

// 使用floyd解决多源汇问题
class Floyd {

    private static final int INF = 1000000;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], INF);

        for (int[] temp : edges) {
            int x = temp[0], y = temp[1], weight = temp[2];
            dist[x][y] = dist[y][x] = weight;
        }

        for (int z = 0; z < n; z++) {
            dist[z][z] = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][z] + dist[z][j]);
                }
            }
        }

        int[] ans = new int[]{INF, -1};
        for (int i = 0; i < n; i++) {
            int num = 0;
            for (int j = 0; j < n; j++) if (dist[i][j] <= distanceThreshold) num++;
            if (ans[0] >= num) {
                ans[1] = i;
                ans[0] = num;
            }
        }
        return ans[1];
    }
}
