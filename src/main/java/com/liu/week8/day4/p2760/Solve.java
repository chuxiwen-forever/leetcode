package com.liu.week8.day4.p2760;

/***
 * @description: <a href="https://leetcode.cn/problems/longest-even-odd-subarray-with-threshold/">leetcode p2760. 最长奇偶子数组</a>。
 * @auther: chuxiwen
 * @date: 2023/11/16 09:16
 * @version 1.0
 */

public class Solve {

    // 遍历
    public int longestAlternatingSubarray1(int[] nums, int threshold) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > threshold || nums[i] % 2 != 0) {
                continue;
            }
            int r = i + 1;
            while (r < n && nums[r - 1] % 2 != nums[r] % 2 && nums[r] <= threshold) {
                r++;
            }
            ans = Math.max(ans, r - i);
        }
        return ans;
    }

    // 分组循环
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        int i = 0;
        int ans = 0;
        while (i < n) {
            if (nums[i] > threshold || nums[i] % 2 != 0) {
                i++;
                continue;
            }
            int start = i;
            i++;
            while (i < n && nums[i] % 2 != nums[i - 1] % 2 && nums[i] <= threshold) {
                i++;
            }
            ans = Math.max(ans, i - start);
        }
        return ans;
    }
}
