package com.liu.day12.LCR147;

import java.util.PriorityQueue;
import java.util.Stack;

/***
 * @description: <a href="https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof/">leetcode LCR 147 最小栈</a>。
 * @auther: chuxiwen
 * @date: 2023/10/11 17.32
 * @version 1.0
 */

public class MinStack {

    public PriorityQueue<Integer> queue = new PriorityQueue<>();
    public Stack<Integer> stack = new Stack<>();

    public MinStack() {
    }

    public void push(int x) {
        stack.push(x);
        queue.add(x);
    }

    // 元素从栈中移除，并且队列中删除
    public void pop() {
        queue.remove(stack.pop());
    }

    // 栈顶元素
    public int top() {
        return stack.peek();
    }

    // 优先队列返回栈顶数值
    public int getMin() {
        return queue.peek();
    }
}
