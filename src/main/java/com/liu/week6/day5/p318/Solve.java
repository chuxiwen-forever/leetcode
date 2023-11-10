package com.liu.week6.day5.p318;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/***
 * @description: <a href="https://leetcode.cn/problems/maximum-product-of-word-lengths/">leetcode p318 最大单词长度乘积</a>。
 * @auther: chuxiwen
 * @date: 2023/11/06 09:13
 * @version 1.0
 */


public class Solve {

    // 位运算表示每一位数据
    public int maxProduct(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int mark = 0;
            int length = word.length();
            for (int i = 0; i < length; i++) {
                mark |= 1 << (word.charAt(i) - 'a');
            }
            if (length > map.getOrDefault(mark, 0)) {
                map.put(mark, length);
            }
        }

        int res = 0;

        Set<Integer> keySet = map.keySet();
        for (Integer mark1 : keySet) {
            Integer wordLength = map.get(mark1);
            for (Integer mark2 : keySet) {
                if ((mark1 & mark2) == 0) {
                    res = Math.max(res, wordLength * map.getOrDefault(mark2, 0));
                }
            }
        }

        return res;
    }
}
