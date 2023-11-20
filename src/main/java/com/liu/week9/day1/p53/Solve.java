package com.liu.week9.day1.p53;

/***
 * @description: <a href="https://leetcode.cn/problems/maximum-subarray/">leetcode p53. 最大子数组和</a>。
 * @auther: chuxiwen
 * @date: 2023/11/20 09:04
 * @version 1.0
 */

class Solve {

    // 贪心算法
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, ans = 0;
        int n = nums.length;
        for (int num : nums) {
            ans += num;
            if (max < ans) max = ans;
            // 如果前面累加小于0，就把累加数量置为0
            // ans + (num < 0) 一定小于 ans, 所以不如给ans变成0，下次累加
            if (ans < 0) ans = 0;
        }
        return max;
    }

    // 动态规划
    public int maxSubArray1(int[] nums) {
        int n = nums.length, max = Integer.MIN_VALUE;
        int[] dp = new int[n];
        dp[0] = nums[0];
        max = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

}
