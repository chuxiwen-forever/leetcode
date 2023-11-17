package com.liu.week8.day5.p12;

/***
 * @description: <a href="https://leetcode.cn/problems/integer-to-roman/">leetcode p12. 整数转罗马数字</a>。
 * @auther: chuxiwen
 * @date: 2023/11/17 09:43
 * @version 1.0
 */

class Solve {

    // 循环处理
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int n = values.length;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                sb.append(symbol);
                num -= value;
            }
            if (num == 0) break;
        }
        return sb.toString();
    }

    // 将每一位都最大程度上表示出来
    public String intToRoman1(int num) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return thousands[num / 1000] +
                hundreds[num % 1000 / 100] +
                tens[num % 100 / 10] +
                ones[num % 10];
    }
}
