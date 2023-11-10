package com.liu.week1.day3.lcp6;

/***
 * @description: leetcode lcp6 拿硬币
 * @auther: chuxiwen
 * @date: 2023/9/20 16:13
 * @version 1.0
 */

public class Solve {

    // 每次都按两个的拿，最后一次拿一个，轮巡把每一堆拿完
    public int minCount(int[] coins) {
        int num = 0;
        for (int coinNum : coins) {
            num += (coinNum + 1) / 2;
        }
        return num;
    }
}