package com.liu.week7.day3.p2258;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/***
 * @description: <a href="https://leetcode.cn/problems/escape-the-spreading-fire">leetcode p2258 逃离火灾</a>。
 * @auther: chuxiwen
 * @date: 2023/11/09 09:34
 * @version 1.0
 */


public class Solve {

    private static final int INF = 1000000000;
    private static final int[][] t = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maximumMinutes(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] fireTime = new int[n][m];
        // 初始化着火时间
        for (int i = 0; i < n; i++) Arrays.fill(fireTime[i], INF);
        // 求出每一个格子着火的时间
        bfs(grid, fireTime);

        int arriveTime = getArriveTime(grid, fireTime, 0);
        // 走不到安全区
        if (arriveTime < 0) return -1;
        // 说明火焰走不到安全区
        if (fireTime[n - 1][m - 1] == INF) return INF;

        // 特判情况，使用火焰到达终点时间减去自己到达终点时间，就是可以停留时间
        int ans = fireTime[n - 1][m - 1] - arriveTime;
        // 将边界情况进行检测，如果可以通过，就使用ans，如果不可以通过，就早走一秒
        return getArriveTime(grid, fireTime, ans) >= 0 ? ans : ans - 1;
    }

    private int getArriveTime(int[][] grid, int[][] fireTime, int stayTime) {
        int n = grid.length, m = grid[0].length;
        boolean[][] v = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, stayTime});
        v[0][0] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int px = poll[0], py = poll[1], time = poll[2];
            for (int i = 0; i < 4; i++) {
                int nx = px + t[i][0], ny = py + t[i][1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    //已经走过或者是墙，就不用需要走了
                    if (v[nx][ny] || grid[nx][ny] == 2) continue;
                    // 如果可以走到最后，就返回下一步的时间
                    if (n - 1 == nx && ny == m - 1) return time + 1;
                    // 在着火之前的下一步走到相应的格子
                    if (fireTime[nx][ny] > time + 1) {
                        v[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, time + 1});
                    }
                }
            }
        }
        return -1;
    }

    private void bfs(int[][] grid, int[][] fireTime) {
        Queue<int[]> queue = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
        // 初始化队列，把一开始就有的着火点都推入队列
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    fireTime[i][j] = 0;
                }
            }

        // 记录什么时间会着火
        int time = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int px = poll[0], py = poll[1];
                // 遍历四个不同的方向
                for (int j = 0; j < 4; j++) {
                    int nx = px + t[j][0], ny = py + t[j][1];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                        // 将着火时间已经确定的和有墙的进行排除，其他都推入队列
                        if (!(fireTime[nx][ny] != INF || grid[nx][ny] == 2)) {
                            queue.offer(new int[]{nx, ny});
                            fireTime[nx][ny] = time;
                        }
                    }
                }
            }
            // 更新着火时间点
            time++;
        }
    }
}
