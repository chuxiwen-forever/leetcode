package com.liu.day10.p225;

import java.util.LinkedList;
import java.util.Queue;

/***
 * @description: <a href="https://leetcode.cn/problems/implement-stack-using-queues/">leetcode p225 用队列实现栈 </a>。
 * @auther: chuxiwen
 * @date: 2023/10/9 16:36
 * @version 1.0
 */

public class MyStack {
    public Queue<Integer> q1 = new LinkedList<>();
    public Queue<Integer> q2 = new LinkedList<>();

    public MyStack() {
    }

    public void push(int x) {
        if (q1.isEmpty()) {
            q2.add(x);
        } else {
            q1.add(x);
        }
    }

    public int pop() {
        int num = 0;
        int i = 0;
        if (q1.isEmpty()) {
            while (i < q2.size() - 1) {
                q1.add(q2.poll());
            }
            num = q2.poll();
        } else {
            while (i < q1.size() - 1) {
                q2.add(q1.poll());
            }
            num = q1.poll();
        }
        return num;
    }

    public int top() {
        int num = 0;
        int i = 0;
        if (q1.isEmpty()) {
            while (i < q2.size() - 1) {
                q1.add(q2.poll());
            }
            num = q2.peek();
            q1.add(q2.poll());
        } else {
            while (i < q1.size() - 1) {
                q2.add(q1.poll());
            }
            num = q1.peek();
            q2.add(q1.poll());
        }
        return num;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
