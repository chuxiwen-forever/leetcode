package com.liu.week9.day2.p1;


import java.util.HashMap;
import java.util.Map;

/***
 * @description: <a href="https://leetcode.cn/problems/two-sum/">leetcode p1. 两数之和</a>。
 * @auther: chuxiwen
 * @date: 2023/11/21 11:25
 * @version 1.0
 */

class Solve {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) return new int[]{map.get(target - nums[i]), i};

            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
