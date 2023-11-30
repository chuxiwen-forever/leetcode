package com.liu.week10.day4.p1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * @description: <a href="https://leetcode.cn/problems/minimum-absolute-difference/">leetcode p1200. 最小绝对差</a>。
 * @auther: chuxiwen
 * @date: 2023/11/30 15:43
 * @version 1.0
 */

class Solve {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);

        int bet = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = arr[i + 1] - arr[i];
            if (temp < bet) {
                bet = temp;
                res.clear();
                res.add(List.of(arr[i], arr[i + 1]));
            } else if (temp == bet) {
                res.add(List.of(arr[i], arr[i + 1]));
            }
        }
        return res;
    }
}
