package com.liu.day2.p19;

import java.util.Stack;

/***
 * @description: leetcode p19 删除倒数第数个链表的数据
 * @auther: chuxiwen
 * @date: 2023/9/19 15:56
 * @version 1.0
 */

public class Solve {
    // 进阶，遍历一次，遍历一次，但是需要开额外的空间
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode res = new ListNode(0, head), save = res;
        Stack<ListNode> listNodeStack = new Stack<>();
        while (res != null) {
            listNodeStack.push(res);
            res = res.next;
        }

        for (int i = 1; i <= n; i++) {
            listNodeStack.pop();
        }
        ListNode listNode = listNodeStack.peek();
        listNode.next = listNode.next.next;
        return save.next;
    }

    // 遍历两次
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = new ListNode(-1, head), save = result;
        int number = 0;
        while (result != null) {
            result = result.next;
            number++;
        }
        if (number == 1) {
            return null;
        }
        n = number - n;
        int temp = 1;
        result = save;
        while (result != null) {
            if (temp == n) {
                if (result.next != null) {
                    result.next = result.next.next;
                }
                break;
            }
            result = result.next;
            temp++;
        }
        return save.next;
    }
}