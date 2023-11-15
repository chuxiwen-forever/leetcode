package com.liu.week8.day3.p2656;

/***
 * @description: <a href="https://leetcode.cn/problems/maximum-sum-with-exactly-k-elements/">leetcode p2656. K 个元素的最大和</a>。
 * @auther: chuxiwen
 * @date: 2023/11/15 09:02
 * @version 1.0
 */

class Solve {

    public int maximizeSum(int[] nums, int k) {
        int max = 0;
        for (int num : nums) max = Math.max(max, num);
        return k * (max + max + k - 1) / 2;
    }
}
