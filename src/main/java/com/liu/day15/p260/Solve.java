package com.liu.day15.p260;

import java.util.HashMap;
import java.util.Map;

/***
 * @description: <a href="https://leetcode.cn/problems/single-number-iii/">leetcode p260 只出现一次的数字 III</a>。
 * @auther: chuxiwen
 * @date: 2023/10/16 08:58
 * @version 1.0
 */

public class Solve {

    // 哈希表 空间：O(n) 时间：O(n)
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] ans = new int[2];
        int length = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                ans[length++] = entry.getKey();
                if (length == 2) {
                    break;
                }
            }
        }
        return ans;
    }

    // 位运算 空间：O(1) 时间：O(n)
    public int[] singleNumber1(int[] nums) {
        int check = 0;
        for (int j : nums) {
            check ^= j;
        }

        int res1 = 0, res2 = 0;
        // 找到不同位，使用不同位将数分为两类，因为相同的数^后为0，所以筛选到最后就是答案
        check = check & (-check);
        for (int num : nums) {
            if ((check & num) == 0) {
                res1 ^= num;
            } else {
                res2 ^= num;
            }
        }
        return new int[]{res1, res2};
    }

}
