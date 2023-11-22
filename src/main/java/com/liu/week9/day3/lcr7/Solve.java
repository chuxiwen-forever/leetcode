package com.liu.week9.day3.lcr7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * @description: <a href="https://leetcode.cn/problems/1fGaJU/">leetcode LCR 007. 三数之和</a>。
 * @auther: chuxiwen
 * @date: 2023/11/22 09:17
 * @version 1.0
 */


class Solve {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            int target = -nums[first];
            int third = n - 1;
            for (int second = first + 1; second < n; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) continue;

                while (second < third && nums[second] + nums[third] > target) third--;

                if (second == third) break;

                if (nums[third] + nums[second] == target) res.add(List.of(nums[first], nums[second], nums[third]));
            }
        }
        return res;
    }

}
