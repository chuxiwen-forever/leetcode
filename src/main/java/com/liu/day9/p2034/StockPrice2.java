package com.liu.day9.p2034;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/***
 * @description: <a href="https://leetcode.cn/problems/stock-price-fluctuation/">leetcode p2034 股票价格波动 </a>。
 * @auther: chuxiwen
 * @date: 2023/10/8 13:28
 * @version 1.0
 */

// 使用两个优先队列
public class StockPrice2 {

    public int lastTime = 0;
    public Map<Integer, Integer> timeMap = new HashMap<>();
    public PriorityQueue<int[]> min = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
    public PriorityQueue<int[]> max = new PriorityQueue<>(((o1, o2) -> o2[1] - o1[1]));

    public StockPrice2() {
    }

    public void update(int timestamp, int price) {
        if (timestamp == 0 && price == 0) {
            return;
        }
        lastTime = Math.max(lastTime, timestamp);
        timeMap.put(timestamp, price);
        min.add(new int[]{timestamp, price});
        max.add(new int[]{timestamp, price});
    }

    public int current() {
        return timeMap.get(lastTime);
    }

    public int maximum() {
        while (!max.isEmpty()) {
            int[] peek = max.peek();
            if (timeMap.getOrDefault(peek[0], 0) == peek[1]) {
                return peek[1];
            }
            max.poll();
        }
        return 0;
    }

    public int minimum() {
        while (!min.isEmpty()) {
            int[] peek = min.peek();
            if (timeMap.getOrDefault(peek[0], 0) == peek[1]) {
                return peek[1];
            }
            min.poll();
        }
        return 0;
    }

}
