package com.liu.day28.p2103;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/***
 * @description: <a href="https://leetcode.cn/problems/rings-and-rods/">leetcode p2103 环和杆</a>。
 * @auther: chuxiwen
 * @date: 2023/11/02 09:49
 * @version 1.0
 */

public class Solve {

    // 使用数据进行模拟
    public int countPoints(String rings) {
        Map<Integer, Color> map = new HashMap<>();
        char[] charArray = rings.toCharArray();
        for (int i = 0; i < charArray.length; i += 2) {
            char color = charArray[i];
            int num = charArray[i + 1] - '0';
            if (map.containsKey(num)) {
                Color temp = map.get(num);
                if (color == 'R') temp.R = true;
                else if (color == 'G') temp.G = true;
                else temp.B = true;
            } else {
                Color temp = new Color();
                if (color == 'R') temp.R = true;
                else if (color == 'G') temp.G = true;
                else temp.B = true;
                map.put(num, temp);
            }
        }

        int res = 0;
        for (Color value : map.values()) {
            if (value.B && value.G && value.R) res++;
        }
        return res;
    }

    class Color {

        public boolean R;
        public boolean G;
        public boolean B;
    }


    // 状态压缩
    public int countPoints1(String rings) {
        int[] st = new int[10];
        for (int i = 0; i < rings.length(); i += 2) {
            int num = rings.charAt(i + 1) - '0';
            char color = rings.charAt(i);

            // | 的运算 有一取一，不影响其他位
            /*
             *   3  二进制是 0011   4 二进制是 0100
             *   3 ｜= 4   运算          7 ｜= 4 运算
             *   0 0 1 1                0 1 1 1
             *   0 1 0 0                0 1 0 0
             *   --------               ---------
             *   0 1 1 1 = 7            0 1 1 1 = 7
             *
             *  无论RGB出现多少次，都在相应位置上改变一次1，所以满足当前题
             */
            if (color == 'R') st[num] |= 1;
            else if (color == 'G') st[num] |= 2;
            else st[num] |= 4;
        }
        return (int) Arrays.stream(st)
                .filter(j -> j == 7)
                .count();
    }
}
