package com.liu.day4.p79;

/***
 * @description: leetcode p79 单词搜索
 * @auther: Liu.
 * @date: 2023/9/21 11:24
 * @version 1.0
 */

public class Solve {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] st = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = dfs(board, st, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] st, int i, int j, String word, int cur) {
        if (word.charAt(cur) != board[i][j]) {
            return false;
        }
        if (word.length() - 1 == cur) {
            return true;
        }
        // 将该格子标记为已经走过
        st[i][j] = true;
        // 记住四个方位，在矩阵中遍历四个方向
        int[][] pointer = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean result = false;
        for (int[] next : pointer) {
            int nextI = i + next[0], nextJ = j + next[1];
            // 处理边界，防止出现指针越界的情况
            if (nextI >= 0 && nextI < board.length && nextJ >= 0 && nextJ < board[0].length) {
                // 如果没有走，走一遍
                if (!st[nextI][nextJ]) {
                    result = dfs(board, st, nextI, nextJ, word, cur + 1);
                    if (result) {
                        break;
                    }
                }
            }
        }
        // 初始化格子
        st[i][j] = false;
        return result;
    }
}