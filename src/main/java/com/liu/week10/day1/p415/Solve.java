package com.liu.week10.day1.p415;

/***
 * @description: <a href="https://leetcode.cn/problems/add-strings/">leetcode p415. 字符串相加</a>。
 * @auther: chuxiwen
 * @date: 2023/11/27 14:08
 * @version 1.0
 */

class Solve {
    // 模拟题，从后往前算
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        return ans.reverse().toString();
    }
}
