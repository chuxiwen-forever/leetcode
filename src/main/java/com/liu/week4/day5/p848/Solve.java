package com.liu.week4.day5.p848;


/***
 * @description: <a href="https://leetcode.cn/problems/shifting-letters/">leetcode p848 字母移位</a>。
 * @auther: chuxiwen
 * @date: 2023/10/23 09:42
 * @version 1.0
 */

class Solve {

    private final char[] chars = new char[]{
            'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'
    };


    public String shiftingLetters(String s, int[] shifts) {
        // 防止数据爆int
        for (int i = 0; i < shifts.length; i++) {
            shifts[i] %= 26;
        }
        // 前缀和
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] += shifts[i + 1];
        }
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            sb.append(shift(charArray[i], shifts[i]));
        }
        return sb.toString();
    }

    private char shift(char ch, int move) {
        // 防止数组越界
        move %= 26;
        return chars[ch - 'a' + move];
    }
}
