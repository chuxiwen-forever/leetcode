package com.liu.day25.p274;


/***
 * @description: <a href="https://leetcode.cn/problems/h-index/">leetcode p274 H 指数</a>。
 * @auther: chuxiwen
 * @date: 2023/10/30 11:17
 * @version 1.0
 */

public class Solve {

    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] counter = new int[n + 1];
        // 记录每一种 h 有多少个
        for (int i : citations) counter[Math.min(i, n)]++;
        int sum = 0;
        for (int i = n; i >= 0; i--) {
            // 记录满足 h(一个界限) 的数, 满足大于8, 一定满足大于6, 所有累加
            sum += counter[i];
            // 当 sum 满足大于等于当前索引，就找到最大的符合情况
            if (sum >= i) return i;
        }
        return -1;
    }
}
