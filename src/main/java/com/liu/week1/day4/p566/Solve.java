package com.liu.week1.day4.p566;

/***
 * @description: <a href="https://leetcode.cn/problems/reshape-the-matrix/description/">leetcode p566 重塑矩阵 </a>。
 * @auther: chuxiwen
 * @date: 2023/9/21 17:19
 * @version 1.0
 */

public class Solve {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;

        if (m * n != r * c) {
            return mat;
        }

        int[][] res = new int[r][c];

        for (int i = 0; i < m * n; i++) {
            res[i / c][i % c] = mat[i / n][i % n];
        }
        return res;
    }
}