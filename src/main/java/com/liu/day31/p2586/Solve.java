package com.liu.day31.p2586;

import java.util.Set;

/***
 * @description: <a href="https://leetcode.cn/problems/count-the-number-of-vowel-strings-in-range/">leetcode p2586 统计范围内的元音字符串数</a>。
 * @auther: chuxiwen
 * @date: 2023/11/07 09:40
 * @version 1.0
 */

public class Solve {

    Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');

    // 遍历
    public int vowelStrings(String[] words, int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            String temp = words[i];
            if (set.contains(temp.charAt(0)) && set.contains(temp.charAt(temp.length() - 1))) res++;
        }
        return res;
    }
}
