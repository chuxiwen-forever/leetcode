package com.liu.week9.day2.p2216;

/***
 * @description: <a href="https://leetcode.cn/problems/minimum-deletions-to-make-array-beautiful/">leetcode p2216. 美化数组的最少删除数</a>。
 * @auther: chuxiwen
 * @date: 2023/11/21 09:29
 * @version 1.0
 */

class Solve {

    public int minDeletion(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        // (i - cnt) % 2 == 0 是因为每一次删除元素，数组都会往前移动
        for (int i = 0; i < n; i++) if ((i - cnt) % 2 == 0 && i + 1 < n && nums[i] == nums[i + 1]) cnt++;

        return (n - cnt) % 2 != 0 ? cnt + 1 : cnt;
    }
}
