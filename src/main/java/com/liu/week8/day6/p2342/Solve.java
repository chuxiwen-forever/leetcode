package com.liu.week8.day6.p2342;

import java.util.*;

/***
 * @description: <a href="https://leetcode.cn/problems/max-sum-of-a-pair-with-equal-sum-of-digits/">leetcode p2342. 数位和相等数对的最大和</a>。
 * @auther: chuxiwen
 * @date: 2023/11/18 09:09
 * @version 1.0
 */


class Solve {

    // 预先处理好位数的关系，将位数一样（每一位相加等于某一个值）的维护在不同的数组中，
    // 然后取后两位就是每一个位数最大的数值
    public int maximumSum(int[] nums) {
        int n = nums.length;
        int[] array = new int[n];

        for (int i = 0; i < n; i++) array[i] = getBitCount(nums[i]);

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int cur = array[i];
            if (map.containsKey(cur)) {
                List<Integer> list = map.get(cur);
                list.add(nums[i]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                map.put(cur, list);
            }
        }

        int max = -1;
        for (List<Integer> value : map.values()) {
            Collections.sort(value);
            int size = value.size();
            if (size > 1) {
                max = Math.max(max, value.get(size - 1) + value.get(size - 2));
            }
        }

        return max;
    }

    private int getBitCount(int num) {
        int ans = 0;
        while (num > 0) {
            ans += num % 10;
            num /= 10;
        }
        return ans;
    }

    // leetcode看到的解法，因为9位数，所以每位相加的和是0 ~ 9 * 9
    public int maximumSum1(int[] nums) {
        int[] cnt = new int[82];
        int max = -1;
        for (int num : nums) {
            int bitCount = getBitCount(num);
            if (cnt[bitCount] > 0) {
                max = Math.max(max, cnt[bitCount] + num);
            }
            // 将位数更新为最大的数
            cnt[bitCount] = Math.max(cnt[bitCount], num);
        }
        return max;
    }

}
