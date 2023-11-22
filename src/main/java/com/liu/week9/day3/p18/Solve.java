package com.liu.week9.day3.p18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * @description: <a href="https://leetcode.cn/problems/4sum/">leetcode p18. 四数之和</a>。
 * @auther: chuxiwen
 * @date: 2023/11/22 14:09
 * @version 1.0
 */


class Solve {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);

        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 连续三个相加就大于target，后面更大，更不可能存在满足条件的数
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if ((long) nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if ((long) nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) continue;

                int left = j + 1, right = n - 1;
                while (left < right) {
                    long num = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (target == num) {
                        res.add(List.of(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) left++;
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        right--;
                    } else if (target < num) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
