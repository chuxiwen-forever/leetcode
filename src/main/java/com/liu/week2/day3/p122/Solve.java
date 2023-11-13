package com.liu.week2.day3.p122;

/***
 * @description: <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/">leetcode p122 买卖股票的最佳时机 II </a>。
 * @auther: chuxiwen
 * @date: 2023/10/6 21:34
 * @version 1.0
 */

class Solve {
    // 动态规划，状态为持有股票，持有现金，最后的状态一定是持有现金
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        // hold 持有股票  cash 持有现金
        int hold = -prices[0], cash = 0;
        int curHold = hold, curCash = cash;

        for (int i = 1; i < n; i++) {
            cash = Math.max(curCash, curHold + prices[i]);
            hold = Math.max(curHold, curCash - prices[i]);

            curHold = hold;
            curCash = cash;
        }

        return cash;
    }

    // 贪心算法
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            res += Math.max(prices[i] - prices[i - 1], 0);
        }
        return res;
    }

}