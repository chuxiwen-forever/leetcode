package com.liu.week8.day3.p2582;

/***
 * @description: <a href="https://leetcode.cn/problems/pass-the-pillow/">leetcode p2582. 递枕头</a>。
 * @auther: chuxiwen
 * @date: 2023/11/15 09:07
 * @version 1.0
 */


class Solve {
    public int passThePillow(int n, int time) {
        // 求一次完整循环需要的时间
        // 举例n = 4时
        // 1 -> 2 -> 3 -> 4 -> 3 -> 2 -> 1，可知一次完整循环需要6s
        // 即 2 * (n - 1)
        time %= 2 * (n - 1); // 在一次完整循环走到哪了
        // 当time >= n时，数值开始减小
        // 先算出多出单次长度多少time - n
        // 再用n - (time - n) - 1
        // 最后化简为
        return time = time < n ? time + 1 : 2 * n - time - 1;
    }
}
