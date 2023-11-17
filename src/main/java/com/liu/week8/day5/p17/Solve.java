package com.liu.week8.day5.p17;

import java.util.ArrayList;
import java.util.List;

/***
 * @description: <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/">leetcode p17. 电话号码的字母组合</a>。
 * @auther: chuxiwen
 * @date: 2023/11/17 09:58
 * @version 1.0
 */

class Solve {
    private final static String[] PHONE = new String[]{
            "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    private final List<String> combinations = new ArrayList<>();
    private int n;
    private String digits;

    public List<String> letterCombinations(String digits) {
        n = digits.length();
        if (n == 0) {
            return combinations;
        }
        this.digits = digits;
        dfs(0, new StringBuilder());
        return combinations;
    }

    private void dfs(int index, StringBuilder combination) {
        if (index == n) {
            combinations.add(combination.toString());
            return;
        }
        char c = digits.charAt(index);
        String num = PHONE[c - '1'];
        for (int i = 0; i < num.length(); i++) {
            combination.append(num.charAt(i));
            dfs(index + 1, combination);
            combination.deleteCharAt(index);
        }
    }
}
