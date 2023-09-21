package com.liu.day4.p328;

/***
 * @description: leetcode p328 奇偶链表
 * @auther: Liu.
 * @date: 2023/9/21 16:19
 * @version 1.0
 */

public class Solve {

    // 将奇链表结合起来，将偶链表结合起来，记录一下偶链表的头节点，然后将奇节点的尾指针指向偶节点的头指针
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}