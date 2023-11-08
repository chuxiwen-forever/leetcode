package com.liu.day32.p2609;

/***
 * @description: <a href="https://leetcode.cn/problems/find-the-longest-balanced-substring-of-a-binary-string/">leetcode p2609 最长平衡子字符串</a>。
 * @auther: chuxiwen
 * @date: 2023/11/08 09:24
 * @version 1.0
 */

public class Solve {

    public int findTheLongestBalancedSubstring(String s) {
        int[] count = new int[2];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count[1]++;
                res = Math.max(res, 2 * Math.min(count[1], count[0]));
            } else if (i == 0 || s.charAt(i - 1) == '1') {
                count[1] = 0;
                count[0] = 1;
            } else {
                count[0]++;
            }
        }
        return res;
    }
}
