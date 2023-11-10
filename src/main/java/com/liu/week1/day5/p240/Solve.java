package com.liu.week1.day5.p240;

/***
 * @description: <a href="https://leetcode.cn/problems/search-a-2d-matrix-ii/description/">leetcode p240 搜索二维矩阵 II </a>。
 * @auther: chuxiwen
 * @date: 2023/9/22 22:13
 * @version 1.0
 */

public class Solve {

    // 暴力查找 n^2
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        for (int[] matrixM : matrix) {
            for (int j = 0; j < n; j++) {
                if (matrixM[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // 二分 n*log n
    public boolean searchMatrix2(int[][] matrix, int target) {
        for (int[] matrixM : matrix) {
            boolean search = searchInLine(matrixM, target);
            if (search) {
                return true;
            }
        }
        return false;
    }

    private boolean searchInLine(int[] line, int target) {
        int right = line.length - 1;
        int left = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (line[mid] == target) {
                return true;
            }
            if (line[mid] > target) {
                right = mid - 1;
            }
            if (line[mid] < target) {
                left = mid + 1;
            }
        }
        return false;
    }

    // 官方解法，z字遍历， m+n
    // 从右上角开始，往下是变大，往左是变小
    public boolean searchMatrix3(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}