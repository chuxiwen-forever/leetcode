package com.liu.week1.day3.p24;

/***
 * @description: leetcode p24 两两交换链表中的节点
 * @auther: chuxiwen
 * @date: 2023/9/20 16:30
 * @version 1.0
 */

public class Solve {
    //     1        2       3
    // cur -> start -> end -> next 交换 1,2,3
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0, head);
        ListNode curr = pre;

        while (curr.next != null && curr.next.next != null) {
            ListNode start = curr.next;
            ListNode end = curr.next.next;
            // 将 1 指向 end
            curr.next = end;
            // 将 2 指向 next
            start.next = end.next;
            // 将 3 指向 start
            end.next = start;
            // 将curr指向下一个需要交换的节点
            curr = start;
        }
        return pre.next;
    }
}