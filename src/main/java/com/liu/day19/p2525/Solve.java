package com.liu.day19.p2525;

/***
 * @description: <a href="https://leetcode.cn/problems/categorize-box-according-to-criteria/">leetcode p2525 根据规则将箱子分类</a>。
 * @auther: chuxiwen
 * @date: 2023/10/20 16:25
 * @version 1.0
 */

public class Solve {
    public String categorizeBox(int length, int width, int height, int mass) {
        // 体积判断
        boolean vCheck = (long) length * width * height >= 1000000000L;
        // 纬度判断
        boolean aCheck = length >= 10000 || width >= 10000 || height >= 10000;
        boolean check = vCheck || aCheck;
        boolean wCheck = mass >= 100;
        if (check && wCheck) {
            return "Both";
        } else if (check) {
            return "Bulky";
        } else if (wCheck) {
            return "Heavy";
        } else {
            return "Neither";
        }
    }
}
