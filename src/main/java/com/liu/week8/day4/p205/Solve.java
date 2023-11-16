package com.liu.week8.day4.p205;

import java.util.HashMap;
import java.util.Map;

/***
 * @description: <a href="https://leetcode.cn/problems/isomorphic-strings/">leetcode p205. 同构字符串</a>。
 * @auther: chuxiwen
 * @date: 2023/11/16 09:40
 * @version 1.0
 */

class Solve {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> stoT = new HashMap<>();
        Map<Character, Character> ttoS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if (stoT.containsKey(sc) && stoT.get(sc) != tc || ttoS.containsKey(tc) && ttoS.get(tc) != sc) return false;
            stoT.put(sc, tc);
            ttoS.put(tc, sc);
        }
        return true;
    }
}
