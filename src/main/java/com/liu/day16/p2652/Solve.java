package com.liu.day16.p2652;


/***
 * @description: <a href="https://leetcode.cn/problems/sum-multiples/">leetcode p2652 倍数求和</a>。
 * @auther: chuxiwen
 * @date: 2023/10/17 13:34
 * @version 1.0
 */
public class Solve {

    // 遍历
    public int sumOfMultiples(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if ((i % 3 == 0) || (i % 5 == 0) || (i % 7 == 0)) {
                sum += i;
            }
        }
        return sum;
    }

    // 容斥原理
    public int sumOfMultiples1(int n) {
        return f(n, 3) + f(n, 5) + f(n, 7) - f(n, 3 * 5) - f(n, 3 * 7) - f(n, 5 * 7) + f(n, 3 * 5 * 7);
    }

    private int f(int n, int m) {
        return (m + n / m * m) * (n / m) / 2;
    }
}
