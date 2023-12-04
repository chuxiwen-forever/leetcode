package com.liu.week11.day1.p202;

/***
 * @description: <a href="https://leetcode.cn/problems/happy-number/">leetcode p202. 快乐数</a>。
 * @auther: chuxiwen
 * @date: 2023/12/04 09:31
 * @version 1.0
 */

class Solve {

    // 快满指针
    public boolean isHappy(int n) {
        int f = getNextNum(n), s = n;
        while (s != 1 && f != s) {
            f = getNextNum(getNextNum(f));
            s = getNextNum(s);
        }
        return f == 1;
    }

    private int getNextNum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (int) Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }
}
