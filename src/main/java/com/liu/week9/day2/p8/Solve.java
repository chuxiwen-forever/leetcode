package com.liu.week9.day2.p8;

/***
 * @description: <a href="https://leetcode.cn/problems/string-to-integer-atoi/">leetcode p8. 字符串转换整数 (atoi)</a>。
 * @auther: chuxiwen
 * @date: 2023/11/21 09:59
 * @version 1.0
 */


class Solve {

    public int myAtoi(String s) {
        boolean isPos;
        int start;
        s = s.trim();
        if (s.isEmpty()) return 0;
        int res = 0, check = Integer.MAX_VALUE / 10;
        if (s.charAt(0) == '-') {
            isPos = false;
            start = 1;
        } else {
            isPos = true;
            start = 0;
        }

        if (s.charAt(0) == '+') start = 1;

        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') break;
            if (res > check || (res == check && s.charAt(i) > '7'))
                return isPos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (s.charAt(i) - '0');
        }

        return res * (isPos ? 1 : -1);
    }
}
