package com.liu.week10.day3.p461;

/***
 * @description: <a href="https://leetcode.cn/problems/hamming-distance/">leetcode p461. 汉明距离</a>。
 * @auther: chuxiwen
 * @date: 2023/11/29 14:55
 * @version 1.0
 */

class Solve {
    // 不断右移动判断最右边是不是1
    public int hammingDistance(int x, int y) {
        int a = x ^ y;
        int res = 0;
        while (a != 0) {
            if ((a & 1) == 1) res++;
            a >>= 1;

        }
        return res;
    }

    // jdk自带
    public int hammingDistance1(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    // Brian Kernighan 算法

    /**
     * a             1 1 0 0 1 0
     * a - 1         1 1 0 0 0 1
     * a & (a - 1)   1 1 0 0 0 0
     *
     * a &= a - 1 就可以使 a 少一个 1, 直到a 为 0
     */
    public int hammingDistance2(int x, int y) {
        int a = x ^ y;
        int res = 0;
        while (a != 0) {
            a &= a - 1;
            res++;
        }
        return res;
    }

}
