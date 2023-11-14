package com.liu.week8.day2.p1334;

import java.util.Arrays;

/***
 * @description: <a href="https://leetcode.cn/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/">leetcode p1334. 阈值距离内邻居最少的城市</a>。
 * @auther: chuxiwen
 * @date: 2023/11/14 10:10
 * @version 1.0
 */

// 使用Dijkstra算法
public class Dijkstra {

    private static final int INF = 10000000;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] map = new int[n][n];
        boolean[][] st = new boolean[n][n];
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            Arrays.fill(map[i], INF);
        }

        for (int[] edge : edges) {
            int form = edge[0], to = edge[1], w = edge[2];
            map[form][to] = map[to][form] = w;
        }

        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
            for (int j = 0; j < n; j++) {
                int t = -1;
                for (int k = 0; k < n; k++) {
                    if (!st[i][k] && (t == -1 || dist[i][k] < dist[i][t])) {
                        t = k;
                    }
                }
                for (int k = 0; k < n; k++) {
                    dist[i][k] = Math.min(dist[i][k], dist[i][t] + map[t][k]);
                }
                st[i][t] = true;
            }
        }

        int[] ans = new int[]{INF, -1};
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) if (dist[i][j] <= distanceThreshold) cnt++;
            if (cnt <= ans[0]) {
                ans[0] = cnt;
                ans[1] = i;
            }
        }
        return ans[1];
    }
}
