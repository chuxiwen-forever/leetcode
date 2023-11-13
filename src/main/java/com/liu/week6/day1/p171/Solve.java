package com.liu.week6.day1.p171;


/***
 * @description: <a href="https://leetcode.cn/problems/excel-sheet-column-number/">leetcode p171 Excel 表列序号</a>。
 * @auther: chuxiwen
 * @date: 2023/10/31 16:14
 * @version 1.0
 */

class Solve {

    public int titleToNumber(String columnTitle) {
        int ans = 0;
        char[] charArray = columnTitle.toCharArray();
        for (char c : charArray) {
            ans = ans * 26 + (c - 'A') + 1;
        }
        return ans;
    }
}
