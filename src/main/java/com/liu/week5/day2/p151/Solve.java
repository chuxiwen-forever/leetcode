package com.liu.week5.day2.p151;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/***
 * @description: <a href="https://leetcode.cn/problems/reverse-words-in-a-string/">leetcode p151 反转字符串中的单词</a>。
 * @auther: chuxiwen
 * @date: 2023/10/25 14:31
 * @version 1.0
 */

public class Solve {

    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        List<String> stringList = Arrays.stream(strings).filter(item -> !"".equals(item)).collect(Collectors.toList());
        if (stringList.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = stringList.size() - 1; i >= 1; i--) {
            sb.append(stringList.get(i)).append(" ");
        }
        sb.append(stringList.get(0));
        return sb.toString();
    }

    public String reverseWords1(String s) {
        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;
            res.append(s, i + 1, j + 1).append(" ");
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return res.toString().trim();
    }
}
