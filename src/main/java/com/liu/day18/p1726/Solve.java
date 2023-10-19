package com.liu.day18.p1726;


import java.util.HashMap;
import java.util.Map;

/***
 * @description: <a href="https://leetcode.cn/problems/tuple-with-same-product/">leetcode p1726 同积元组</a>。
 * @auther: chuxiwen
 * @date: 2023/10/19 11:28
 * @version 1.0
 */

public class Solve {

    // 将所有两两相乘，得到的数存入map中，遍历map取value，求C(2n)组合数，相加得到结果
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int num = nums[i] * nums[j];
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int v = entry.getValue();
            sum += v * (v - 1) * 4;
        }
        return sum;
    }
}
