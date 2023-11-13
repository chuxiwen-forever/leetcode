package com.liu.week2.day1.p645;

import java.util.HashMap;
import java.util.Map;

/***
 * @description: <a href="https://leetcode.cn/problems/set-mismatch/description/">leetcode p645 错误的集合</a>。
 * @auther: chuxiwen
 * @date: 2023/9/24 17:53
 * @version 1.0
 */

class Solve {

    // 哈希表
    public int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        // 重复的数字
        int x = 0;
        // 漏掉的数字
        int y = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 1; i <= length; i++) {
            if (x != 0 && y != 0) {
                break;
            }
            Integer count = map.getOrDefault(i, 0);
            if (count == 0) {
                y = i;
            }
            if (count == 2) {
                x = i;
            }
        }
        return new int[]{x, y};
    }
}