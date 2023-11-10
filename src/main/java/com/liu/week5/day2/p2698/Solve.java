package com.liu.week5.day2.p2698;


/***
 * @description: <a href="https://leetcode.cn/problems/find-the-punishment-number-of-an-integer/">leetcode p2698 求一个整数的惩罚数</a>。
 * @auther: chuxiwen
 * @date: 2023/10/25 09:02
 * @version 1.0
 */

public class Solve {

    // 遍历所有可能，然后进行dfs遍历所有可能
    public int punishmentNumber(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            String s = i * i + "";
            if (dfs(s, 0, 0, i)) {
                res += i * i;
            }
        }
        return res;
    }

    // s: 字符串 index: 第几个数 curr: 当前和 target: 目标值
    private boolean dfs(String s, int index, int curr, int target) {
        // 如果到最后一个字母，返回是否等于目标值
        if (index == s.length()) return curr == target;

        int sum = 0;
        for (int i = index; i < s.length(); i++) {
            sum = sum * 10 + (s.charAt(i) - '0');
            if (sum + curr > target) break;
            if (dfs(s, i + 1, sum + curr, target)) return true;
        }
        return false;
    }

    // 因为数据量不大，可以将所有情况进行遍历然后找到不大于n最大的数
    public int punishmentNumber1(int n) {
        int[] all = new int[]{1, 9, 10, 36, 45, 55, 82, 91, 99, 100, 235, 297, 369, 370, 379, 414, 657, 675, 703, 756, 792, 909, 918, 945, 964, 990, 991, 999, 1000};
        int res = 0;
        for (int i : all) {
            if (i <= n) res += i * i;
        }
        return res;
    }
}
