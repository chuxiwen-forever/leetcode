package com.liu.day26.p169;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/***
 * @description: <a href="https://leetcode.cn/problems/majority-element/">leetcode p169 多数元素</a>。
 * @auther: chuxiwen
 * @date: 2023/10/31 17:10
 * @version 1.0
 */

public class Solve {

    // 哈希表
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = -1;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (integerIntegerEntry.getValue() >= n){
                result =  integerIntegerEntry.getKey();
            }
        }
        return result;
    }

    // 排序取中间数就可以了
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
