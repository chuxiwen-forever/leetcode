package com.liu.day14.p1488;

import java.util.*;

/***
 * @description: <a href="https://leetcode.cn/problems/avoid-flood-in-the-city/">leetcode p1488 避免洪水泛滥</a>。
 * @auther: chuxiwen
 * @date: 2023/10/13 09:03
 * @version 1.0
 */

public class Solve {
    // 将每一次晴天存起来，用到最需要晴天的时候 (贪心)
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        // 记录可以排干水的日期  这个日期可以排干在这之前满的湖泊
        TreeSet<Integer> sunSet = new TreeSet<>();
        // 记录下雨 k: 涨满湖泊 v: 下雨天数
        Map<Integer, Integer> rainMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                sunSet.add(i);
            } else {
                ans[i] = -1;
                if (rainMap.containsKey(rains[i])) {
                    Integer lastRainDay = rainMap.get(rains[i]);
                    // 找到大于下雨天中最近的一天排水日
                    Integer canExecDay = sunSet.ceiling(lastRainDay);
                    if (canExecDay == null) {
                        return new int[0];
                    }
                    ans[canExecDay] = rains[i];
                    sunSet.remove(canExecDay);
                }
                rainMap.put(rains[i], i);
            }
        }
        return ans;
    }
}
