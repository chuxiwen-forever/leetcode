package com.liu.week5.day5.p275;

/***
 * @description: <a href="https://leetcode.cn/problems/h-index-ii/">leetcode p275 H 指数 II</a>。
 * @auther: chuxiwen
 * @date: 2023/10/30 09:58
 * @version 1.0
 */

class Solve {

    public int hIndex(int[] citations) {
        int n = citations.length, left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (citations[mid] >= n - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - left;
    }
}
