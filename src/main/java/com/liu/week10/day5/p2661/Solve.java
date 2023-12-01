package com.liu.week10.day5.p2661;

import java.util.HashMap;
import java.util.Map;

/***
 * @description: <a href="https://leetcode.cn/problems/first-completely-painted-row-or-column/">leetcode p2661. 找出叠涂元素</a>。
 * @auther: chuxiwen
 * @date: 2023/12/01 09:09
 * @version 1.0
 */

class Solve {

    // 模拟题，将每一行都记录一下，等到有一行或者一列满足条件
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, int[]> map = new HashMap<>();
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) map.put(mat[i][j], new int[]{i, j});

        int[] nCount = new int[n];
        int[] mCount = new int[m];

        for (int i = 0; i < arr.length; i++) {
            int[] t = map.get(arr[i]);
            nCount[t[0]]++;
            if (nCount[t[0]] == m) return i;
            mCount[t[1]]++;
            if (mCount[t[1]] == n) return i;
        }
        return -1;
    }
}
