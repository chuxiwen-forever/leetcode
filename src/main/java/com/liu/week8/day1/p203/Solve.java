package com.liu.week8.day1.p203;

/***
 * @description: <a href="https://leetcode.cn/problems/remove-linked-list-elements/">leetcode p203. 移除链表元素</a>。
 * @auther: chuxiwen
 * @date: 2023/11/13 10:53
 * @version 1.0
 */

class Solve {
    public ListNode removeElements(ListNode head, int val) {
        ListNode listNode = new ListNode(-1, head);
        ListNode ans = listNode;
        while (ans != null && ans.next != null) {
            if (ans.next.val == val) ans.next = ans.next.next;
            else ans = ans.next;
        }
        return listNode.next;
    }
}
