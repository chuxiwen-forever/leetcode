package com.liu.week2.day5.p232;

import java.util.Stack;

/***
 * @description: <a href="https://leetcode.cn/problems/implement-queue-using-stacks/">leetcode p232 用栈实现队列 </a>。
 * @auther: chuxiwen
 * @date: 2023/10/9 16:18
 * @version 1.0
 */
class MyQueue {

    public Stack<Integer> inStack = new Stack<>();
    public Stack<Integer> outStack = new Stack<>();

    public MyQueue() {
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.empty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.empty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        return outStack.empty() && inStack.empty();
    }
}
