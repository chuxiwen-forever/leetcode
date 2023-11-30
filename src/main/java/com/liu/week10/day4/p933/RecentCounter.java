package com.liu.week10.day4.p933;

import java.util.LinkedList;
import java.util.Queue;

/***
 * @description: <a href="https://leetcode.cn/problems/number-of-recent-calls/">leetcode p933. 最近的请求次数</a>。
 * @auther: chuxiwen
 * @date: 2023/11/30 15:33
 * @version 1.0
 */

class RecentCounter {

    private final Queue<Integer> queue = new LinkedList<>();

    public RecentCounter() {
    }

    public int ping(int t) {
        queue.offer(t);
        while (!queue.isEmpty() && t - queue.peek() > 3000) {
            queue.poll();
        }
        return queue.size();
    }
}

