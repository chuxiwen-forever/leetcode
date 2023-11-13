package com.liu.week5.day5.p28;


/***
 * @description: <a href="https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/">leetcode p28 找出字符串中第一个匹配项的下标</a>。
 * @auther: chuxiwen
 * @date: 2023/10/30 11:35
 * @version 1.0
 */

class Solve {

    // 此题的最优解是kmp算法，但是不会，就暴力了
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i <= n - m; i++) {
            if (haystack.substring(i, i + m).equals(needle)) return i;
        }
        return -1;
    }
}
