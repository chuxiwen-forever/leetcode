package com.liu.week10.day2.p78;

import java.util.ArrayList;
import java.util.List;

/***
 * @description: <a href="https://leetcode.cn/problems/subsets/">leetcode p78. 子集</a>。
 * @auther: chuxiwen
 * @date: 2023/11/28 10:57
 * @version 1.0
 */

class Solve {

    private int[] nums;
    private final List<Integer> n = new ArrayList<>();
    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] _nums) {
        nums = _nums;
        dfs(0);
        return res;
    }

    private void dfs(int length) {
        if (length == nums.length) {
            res.add(new ArrayList<>(n));
            return;
        }
        n.add(nums[length]);
        dfs(length + 1);
        n.remove(n.size() - 1);
        dfs(length + 1);
    }
}
