package com.liu.week5.day2.p1624;

import java.util.HashMap;
import java.util.Map;

/***
 * @description: <a href="https://leetcode.cn/problems/largest-substring-between-two-equal-characters/">leetcode p1624 两个相同字符之间的最长子字符串</a>。
 * @auther: chuxiwen
 * @date: 2023/10/25 14:44
 * @version 1.0
 */

public class Solve {

    // Map记录第一次出现的位置，后面的位置减去当前的位置
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = -1;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (map.containsKey(charArray[i])) {
                max = Math.max(max, i - map.get(charArray[i]) - 1);
            } else {
                map.put(charArray[i], i);
            }
        }
        return max;
    }
}
