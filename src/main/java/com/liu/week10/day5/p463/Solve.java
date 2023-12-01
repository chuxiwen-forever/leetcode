package com.liu.week10.day5.p463;

/***
 * @description: <a href="https://leetcode.cn/problems/island-perimeter/">leetcode p463. 岛屿的周长</a>。
 * @auther: chuxiwen
 * @date: 2023/12/01 10:22
 * @version 1.0
 */


class Solve {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    private int n;
    private int m;

    private int[][] grid;

    public int islandPerimeter(int[][] _grid) {
        grid = _grid;
        m = grid[0].length;
        n = grid.length;
        int res = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) if (grid[i][j] == 1) res += dfs(i, j);
        return res;
    }

    private int dfs(int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == 2) {
            return 0;
        }
        grid[i][j] = 2;
        int res = 0;
        for (int k = 0; k < 4; k++) {
            int tx = i + dx[k];
            int ty = j + dy[k];
            res += dfs(tx, ty);
        }
        return res;
    }
}
