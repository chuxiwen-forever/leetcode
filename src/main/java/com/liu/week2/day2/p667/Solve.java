package com.liu.week2.day2.p667;

/***
 * @description: <a href="https://leetcode.cn/problems/beautiful-arrangement-ii/description/">leetcode 667 优美的排列 II </a>。
 * @auther: chuxiwen
 * @date: 2023/10/5 21:02
 * @version 1.0
 */

public class Solve {

    /**
     * 数学问题，交换两个数可以添加两个k
     */
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) res[i] = i + 1;

        for (int i = 1; i < k; i++) {
            reverse(res, i);
        }
        return res;
    }

    private void reverse(int[] res, int i) {
        int left = i;
        int right = res.length - 1;
        while (left < right) {
            int temp = res[left];
            res[left] = res[right];
            res[right] = temp;
            left++;
            right--;
        }
    }

    public int[] constructArray1(int n, int k) {
        int[] answer = new int[n];
        int idx = 0;
        for (int i = 1; i < n - k; ++i) {
            answer[idx++] = i;
        }
        for (int i = n - k, j = n; i <= j; ++i, --j) {
            answer[idx++] = i;
            if (i != j) {
                answer[idx++] = j;
            }
        }
        return answer;
    }
}