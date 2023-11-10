package com.liu.week2.day4.p2034;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/***
 * @description: <a href="https://leetcode.cn/problems/stock-price-fluctuation/">leetcode p2034 股票价格波动 </a>。
 * @auther: chuxiwen
 * @date: 2023/10/8 11:10
 * @version 1.0
 */

// 使用有序数组进行处理
public class StockPrice1 {

    public Map<Integer, Integer> timeMap = new HashMap<>();
    public TreeMap<Integer, Integer> prices = new TreeMap<>();
    public int lastTime = 0;


    public StockPrice1() {
    }

    public void update(int timestamp, int price) {
        lastTime = Math.max(timestamp, lastTime);
        int curPrice = timeMap.getOrDefault(timestamp, 0);
        timeMap.put(timestamp, price);
        if (curPrice != 0) {
            prices.put(curPrice, prices.get(curPrice) - 1);
            if (prices.get(curPrice) == 0) {
                prices.remove(curPrice);
            }
        }
        prices.put(price, prices.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return timeMap.get(lastTime);
    }

    public int maximum() {
        return prices.lastKey();
    }

    public int minimum() {
        return prices.firstKey();
    }
}
