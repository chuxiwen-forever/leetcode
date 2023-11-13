package com.liu.week3.day3.p2562;

/***
 * @description: <a href="https://leetcode.cn/problems/find-the-array-concatenation-value/">leetcode p2562 找出数组的串联值</a>。
 * @auther: chuxiwen
 * @date: 2023/10/12 09:13
 * @version 1.0
 */


class Solve {
    // 特判数组为奇数情况
    public long findTheArrayConcVal(int[] nums) {
        long ans = 0;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            ans += Long.parseLong(String.valueOf(nums[l]) + nums[r]);
            l++;
            r--;
        }
        if (nums.length % 2 != 0) {
            ans += nums[nums.length / 2];
        }
        return ans;
    }
}
