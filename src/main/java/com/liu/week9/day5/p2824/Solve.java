package com.liu.week9.day5.p2824;

import java.util.Collections;
import java.util.List;

/***
 * @description: <a href="https://leetcode.cn/problems/count-pairs-whose-sum-is-less-than-target/">leetcode p2824. 统计和小于目标的下标对数目</a>。
 * @auther: chuxiwen
 * @date: 2023/11/24 09:13
 * @version 1.0
 */

class Solve {

    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int l = 0, r = nums.size() - 1;
        int num = 0;
        while (l < r) {
            // 排序后，查询 nums[l] + nums[(l + 1 -> r)] <= target 数量
            while (l < r && nums.get(l) + nums.get(r) >= target) r--;
            // 数量为 r - l
            num += r - l;
            // l++ 后计算 nums[l + 1] + nums[(l + 1 + 1 -> r)] <= target 数量
            l++;
        }
        return num;
    }
}
