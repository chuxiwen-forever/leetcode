package com.liu.week6.day2.lcr103;

import java.util.Arrays;

/***
 * @description: <a href="https://leetcode.cn/problems/gaM7Ch/">leetcode LCR 103 零钱兑换</a>。
 * @auther: chuxiwen
 * @date: 2023/11/01 11:20
 * @version 1.0
 */


class Solve {

    // 0 - 1 背包
    public int coinChange(int[] coins, int amount) {
        int n = amount + 1;
        int[] dp = new int[n];
        Arrays.fill(dp, n);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
