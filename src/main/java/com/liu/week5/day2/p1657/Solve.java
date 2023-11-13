package com.liu.week5.day2.p1657;


import java.util.Arrays;

/***
 * @description: <a href="https://leetcode.cn/problems/determine-if-two-strings-are-close">leetcode p1657 确定两个字符串是否接近</a>。
 * @auther: chuxiwen
 * @date: 2023/10/25 15:00
 * @version 1.0
 */

class Solve {

    public boolean closeStrings(String word1, String word2) {
        int[] i1 = new int[26];
        int[] i2 = new int[26];

        char[] word1CharArray = word1.toCharArray();
        char[] word2CharArray = word2.toCharArray();

        for (char c : word1CharArray) i1[c - 'a']++;
        for (char c : word2CharArray) i2[c - 'a']++;

        // 题目要求只能交换已有的字符，所以如果字符只在一个字符串中出现了，就不可能可以替换或者交换
        for (int i = 0; i < 26; i++) {
            // 如果两个字符串都没有该字符，就没问题
            if (i1[i] == 0 && i2[i] == 0) continue;
            // 如果只有一个字符串有该字符，就不可以替换了
            if (i1[i] == 0 || i2[i] == 0) return false;
        }

        Arrays.sort(i1);
        Arrays.sort(i2);
        for (int i = 0; i < 26; i++) {
            if (i1[i] != i2[i]) return false;
        }
        return true;
    }

}
