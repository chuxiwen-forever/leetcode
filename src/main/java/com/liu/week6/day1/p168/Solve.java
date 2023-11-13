package com.liu.week6.day1.p168;

/***
 * @description: <a href="https://leetcode.cn/problems/excel-sheet-column-title/">leetcode p168 Excel表列名称</a>。
 * @auther: chuxiwen
 * @date: 2023/10/31 16:21
 * @version 1.0
 */

class Solve {

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber--;
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
