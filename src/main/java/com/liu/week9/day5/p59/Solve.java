package com.liu.week9.day5.p59;

/***
 * @description: <a href="https://leetcode.cn/problems/spiral-matrix-ii/">leetcode p59. 螺旋矩阵 II</a>。
 * @auther: chuxiwen
 * @date: 2023/11/24 09:30
 * @version 1.0
 */


class Solve {

    public int[][] generateMatrix(int n) {
        int last = n * n, num = 1;
        int[][] res = new int[n][n];
        int l = 0, r = n - 1, t = 0, b = n - 1;
        while (num <= last) {
            for (int i = l; i <= r; i++) res[t][i] = num++;
            t++;
            for (int i = t; i <= b; i++) res[i][r] = num++;
            r--;
            for (int i = r; i >= l; i--) res[b][i] = num++;
            b--;
            for (int i = b; i >= t; i--) res[i][l] = num++;
            l++;
        }
        return res;
    }
}
