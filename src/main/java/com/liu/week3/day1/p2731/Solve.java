package com.liu.week3.day1.p2731;


import java.util.Arrays;

/***
 * @description: <a href="https://leetcode.cn/problems/movement-of-robots/">leetcode p2731 移动机器人 </a>。
 * @auther: chuxiwen
 * @date: 2023/10/10 11:48
 * @version 1.0
 */

public class Solve {

    public static final int MOD = 1000000007;

    // 首先，因为机器人位置(i,j) 和(j,i)一致，所以不需要考虑相撞问题，考虑为穿过
    // 这个问题就可以简化为，每个机器人走到指定位置，两两之间距离之和
    public int sumDistance(int[] nums, String s, int d) {
        int n = nums.length;
        long[] rs = new long[n];
        for (int i = 0; i < n; i++) rs[i] = s.charAt(i) == 'L' ? (long) nums[i] - d : (long) nums[i] + d;
        Arrays.sort(rs);
        long sum = 0, cnt = 0;
        // 只考虑 i 点和前面点的距离，到 n 就可以包含所有之间的距离
        //   rs[i] - rs[i - 1] + rs[i] - rs[i - 2] + rs[i] - rs[i - 3] + ... +rs[i] - rs[0]
        // = rs[i] * i - (rs[i - 1] + rs[i - 2] + ... + rs[0])
        // sum 记录前面相加和
        for (int i = 0; i < n; i++) {
            cnt = (cnt + rs[i] * i - sum) % MOD;
            sum += rs[i];
        }
        return (int) cnt;
    }
}
