package com.liu.week2.day5.p2578;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/***
 * @description: <a href="https://leetcode.cn/problems/split-with-minimum-sum/">leetcode p2578 最小和分割 </a>。
 * @auther: chuxiwen
 * @date: 2023/10/9 14:22
 * @version 1.0
 */


public class Solve {

    public int splitNum(int num) {
        String string = String.valueOf(num);
        char[] charArray = string.toCharArray();
        return getNum(charArray);
    }

    // 少了排序的时间，当num特别大时，可以省时，但是因为int数值就那么大，所以和下面方法没什么区别
    private int getNum(char[] chars) {
        Map<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                map.put(aChar, map.get(aChar) + 1);
            } else {
                map.put(aChar, 1);
            }
        }
        char[] c = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        StringBuilder i1 = new StringBuilder();
        StringBuilder i2 = new StringBuilder();
        boolean f = true;

        for (int i = 0; i < c.length; ) {
            if (map.containsKey(c[i])) {
                Integer num = map.get(c[i]);
                if (f) {
                    i1.append(c[i]);
                    f = false;
                } else {
                    i2.append(c[i]);
                    f = true;
                }
                if (num - 1 == 0) {
                    map.remove(c[i]);
                    i++;
                } else {
                    map.put(c[i], num - 1);
                }
            } else {
                i++;
            }
        }

        int num1 = 0;
        int num2 = 0;

        if (!"".contentEquals(i1)) {
            num1 = Integer.parseInt(i1.toString());
        }
        if (!"".contentEquals(i2)) {
            num2 = Integer.parseInt(i2.toString());
        }
        return num1 + num2;
    }

    // 使用char之间的运算进行处理
    public int splitNum1(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        Arrays.sort(chars);
        int num1 = 0, num2 = 0;
        for (int i = 0; i < chars.length; ++i) {
            if (i % 2 == 0) {
                num1 = num1 * 10 + (chars[i] - '0');
            } else {
                num2 = num2 * 10 + (chars[i] - '0');
            }
        }
        return num1 + num2;
    }
}
