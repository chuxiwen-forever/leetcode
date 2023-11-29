package com.liu.week10.day3.p2336;

import java.util.PriorityQueue;

/***
 * @description: <a href="https://leetcode.cn/problems/smallest-number-in-infinite-set/">leetcode p2336. 无限集中的最小数字</a>。
 * @auther: chuxiwen
 * @date: 2023/11/29 14:12
 * @version 1.0
 */

class SmallestInfiniteSet {

    private final PriorityQueue<Integer> queue = new PriorityQueue<>();
    private int i = 1;

    public SmallestInfiniteSet() {
    }

    public int popSmallest() {
        if (!queue.isEmpty()) return queue.poll();
        else return i++;
    }

    public void addBack(int num) {
        // 题目说明集合和队列中不能存在相同的数，所以，要判断队列中是否已经一样的数
        if (num < i && !queue.contains(num)) {
            queue.add(num);
        }
    }
}
