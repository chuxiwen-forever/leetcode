package com.liu.week2.day2.p697;

import java.util.HashMap;
import java.util.Map;

/***
 * @description: <a href="https://leetcode.cn/problems/degree-of-an-array/">leetcode 697 数组的度</a>。
 * @auther: chuxiwen
 * @date: 2023/10/5 21:46
 * @version 1.0
 */

class Solve {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, D> ds = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int temp = nums[i];
            if (ds.containsKey(temp)) {
                D curD = ds.get(temp);
                curD.end = i;
                curD.value++;
            } else {
                ds.put(nums[i], new D(1, i, i));
            }
        }

        int max = 0, min = 0;
        for (Map.Entry<Integer, D> entry : ds.entrySet()) {
            D d = entry.getValue();
            if (max < d.value) {
                max = d.value;
                min = d.end - d.begin + 1;
            } else if (max == d.value) {
                int temp = d.end - d.begin + 1;
                if (min > temp) {
                    min = temp;
                }
            }
        }
        return min;
    }

    class D {
        public D() {
        }

        public D(int value, int begin, int end) {
            this.value = value;
            this.begin = begin;
            this.end = end;
        }

        // 字数出现次数
        public int value;
        // 开始的位置
        public int begin;
        //结束的位置
        public int end;
    }
}