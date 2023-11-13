package com.liu.week7.day4.p2300;

import java.util.Arrays;

/***
 * @description: <a href="https://leetcode.cn/problems/successful-pairs-of-spells-and-potions/">leetcode p2300 咒语和药水的成功对数</a>。
 * @auther: chuxiwen
 * @date: 2023/11/10 09:41
 * @version 1.0
 */

class Solve {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        Arrays.sort(potions);
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            double ans = success * 1.0 / spells[i];

            int left = 0, right = potions.length - 1;
            while (left < right) {
                int mid = left + ((right - left) >> 1);
                if (potions[mid] >= ans) right = mid;
                else left = mid + 1;
            }
            if ((long) potions[left] * spells[i] >= success) res[i] = potions.length - left;
        }
        return res;
    }
}
