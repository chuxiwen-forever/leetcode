package com.liu.week5.day3.p2520;

/***
 * @description: <a href="https://leetcode.cn/problems/count-the-digits-that-divide-a-number/">leetcode p2520 统计能整除数字的位数</a>。
 * @auther: chuxiwen
 * @date: 2023/10/26 09:20
 * @version 1.0
 */

class Solve {

    public int countDigits(int num) {
        // 先找到10以内可以整除num的数, 进行记录
        int[] arr = new int[10];
        for (int i = 1; i < 10; i++) {
            if (num % i == 0) arr[i] = 1;
        }
        int cnt = 0;
        String string = String.valueOf(num);
        // 查看记录数组情况，如果为一就说明可以整除
        for (char c : string.toCharArray()) {
            if (arr[c - '0'] == 1) cnt++;
        }
        return cnt;
    }

    // 直接取值，一位一位判断
    public int countDigits1(int num) {
        int temp = num;
        int cnt = 0;

        while (temp > 0) {
            int i = temp % 10;
            if (num % i == 0) cnt++;
            temp /= 10;
        }
        return cnt;
    }
}
