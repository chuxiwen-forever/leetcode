package com.liu.week2.day2.p766;

/***
 * @description: <a href="https://leetcode.cn/problems/toeplitz-matrix/">leetcode p766 托普利茨矩阵 </a>。
 * @auther: chuxiwen
 * @date: 2023/10/5 22:24
 * @version 1.0
 */

public class Solve {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 和左上角比较
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}