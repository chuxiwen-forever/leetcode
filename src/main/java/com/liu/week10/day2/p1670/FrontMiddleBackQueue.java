package com.liu.week10.day2.p1670;

import java.util.ArrayList;
import java.util.List;

/***
 * @description: <a href="https://leetcode.cn/problems/design-front-middle-back-queue/">leetcode p1670. 设计前中后队列</a>。
 * @auther: chuxiwen
 * @date: 2023/11/28 09:04
 * @version 1.0
 */

class FrontMiddleBackQueue {

    private final List<Integer> list = new ArrayList<>();

    public FrontMiddleBackQueue() {
    }

    public void pushFront(int val) {
        list.add(0, val);
    }

    public void pushMiddle(int val) {
        list.add(list.size() / 2, val);
    }

    public void pushBack(int val) {
        list.add(val);
    }

    public int popFront() {
        return list.isEmpty() ? -1 : list.remove(0);
    }

    public int popMiddle() {
        return list.isEmpty() ? -1 : list.remove((list.size() - 1) / 2);
    }

    public int popBack() {
        return list.isEmpty() ? -1 : list.remove(list.size() - 1);
    }
}