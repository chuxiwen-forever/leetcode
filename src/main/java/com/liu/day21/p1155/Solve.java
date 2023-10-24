package com.liu.day21.p1155;


/***
 * @description: <a href="https://leetcode.cn/problems/number-of-dice-rolls-with-target-sum/">leetcode p1155 掷骰子等于目标和的方法数</a>。
 * @auther: chuxiwen
 * @date: 2023/10/24 09:03
 * @version 1.0
 */

public class Solve {

    private static final int MOD = 1000000007;

    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                for (int l = 1; l <= k; l++) {
                    if (j - l >= 0) {
                        dp[i][j] = (dp[i - 1][j - l] + dp[i][j]) % MOD;
                    }
                }
            }
        }
        return dp[n][target];
    }
}
