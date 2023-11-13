package com.liu.week2.day3.p121;

/***
 * @description: <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/">leetcode p121 买卖股票的最佳时机 </a>。
 * @auther: chuxiwen
 * @date: 2023/10/6 21:10
 * @version 1.0
 */

class Solve {

    // 暴力解法 (超时)
    public int maxProfit(int[] prices) {
        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int ans = prices[j] - prices[i];
                if (ans > max) max = ans;
            }
        }

        return max;
    }

    // 一次遍历 (寻找最小值，根据时间过程走，后面值减前面找到的最小值)
    public int maxProfit1(int[] prices) {
        // max 是最佳售卖的值
        // min 是最小值，不断更替，找当前最小值
        int max = 0, min = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < min) {
                // 更换最小值
                min = price;
            } else if (price - min > max) {
                // 后面减去前面找到的这个最小值，当前最大值进行比较
                max = price - min;
            }
        }

        return max;
    }

}