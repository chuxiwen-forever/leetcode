package com.liu.week5.day4.p1465;

import java.util.Arrays;

/***
 * @description: <a href="https://leetcode.cn/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/">leetcode p1465 切割后面积最大的蛋糕</a>。
 * @auther: chuxiwen
 * @date: 2023/10/27 14:21
 * @version 1.0
 */

class Solve {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        return (int) ((long) getMaxLength(horizontalCuts, h) * getMaxLength(verticalCuts, w) % 1000000007);
    }

    private int getMaxLength(int[] arr, int l) {
        // 0 -> 第一条分割线  最后一条分割线 -> 矩形底部
        int max = Math.max(arr[0], l - arr[arr.length - 1]);
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(arr[i] - arr[i - 1], max);
        }
        return max;
    }
}
