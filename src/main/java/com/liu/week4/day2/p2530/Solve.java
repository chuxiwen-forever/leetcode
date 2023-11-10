package com.liu.week4.day2.p2530;

import java.util.PriorityQueue;

/***
 * @description: <a href="https://leetcode.cn/problems/maximal-score-after-applying-k-operations/">leetcode p2530 执行 K 次操作后的最大分数</a>。
 * @auther: chuxiwen
 * @date: 2023/10/17 13:34
 * @version 1.0
 */
public class Solve {

    // 优先队列取最大数
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int num : nums) {
            queue.add(num);
        }
        long sum = 0;
        for (int i = 1; i <= k; i++) {
            int temp = queue.poll();
            sum += temp;
            queue.add(temp % 3 == 0 ? temp / 3 : temp / 3 + 1);
        }
        return sum;
    }
}
