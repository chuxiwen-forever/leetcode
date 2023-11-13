package com.liu.week4.day5.p2678;

/***
 * @description: <a href="https://leetcode.cn/problems/number-of-senior-citizens/">leetcode p2678 老人的数目</a>。
 * @auther: chuxiwen
 * @date: 2023/10/23 09:12
 * @version 1.0
 */

class Solve {

    public int countSeniors(String[] details) {
        int cnt = 0;
        for (String detail : details) {
            int parsed = Integer.parseInt(detail.charAt(11) + "" + detail.charAt(12));
            if (parsed > 60) cnt++;
        }
        return cnt;
    }
}
