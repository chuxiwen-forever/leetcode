package com.liu.day5.p485;

/***
 * @description: <a href="https://leetcode.cn/problems/max-consecutive-ones/">leetcode p485 最大连续 1 的个数 </a>。
 * @auther: chuxiwen
 * @date: 2023/9/22 17:43
 * @version 1.0
 */

public class Solve {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int ans = 0;

        for (int num : nums) {
            if (num != 0) {
                ans++;
            } else {
                res = Math.max(res, ans);
                ans = 0;
            }
        }
        res = Math.max(res, ans);
        return res;
    }
}