package com.liu.week9.day1.p77;

import java.util.ArrayList;
import java.util.List;

/***
 * @description: <a href="https://leetcode.cn/problems/combinations/">leetcode p77. 组合</a>。
 * @auther: chuxiwen
 * @date: 2023/11/20 11:24
 * @version 1.0
 */

class Solve {

    private int n;
    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int _n, int _k) {
        n = _n;
        dfs(_k, 1, new ArrayList<>());
        return res;
    }

    private void dfs(int k, int start, ArrayList<Integer> cur) {
        if (k == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i <= n - k + 1; i++) {
            cur.add(i);
            dfs(k - 1, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
