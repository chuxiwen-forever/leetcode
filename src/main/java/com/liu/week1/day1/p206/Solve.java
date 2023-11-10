package com.liu.week1.day1.p206;

import java.util.ArrayList;
import java.util.List;

/***
 * @description: leetcode p206 反转链表
 * @auther: chuxiwen
 * @date: 2023/9/18 15:22
 * @version 1.0
 */

public class Solve {
    // 将整个链表数据存放到数组中，然后倒着存一遍
    public ListNode reverseList1(ListNode head) {
        ListNode pHead = head;
        List<Integer> list = new ArrayList<>();
        for (; pHead != null; pHead = pHead.next) {
            list.add(pHead.val);
        }
        if (list.isEmpty()) {
            return null;
        }
        int last = list.size() - 1;
        pHead = new ListNode(list.get(last), null);
        ListNode h = pHead;
        for (int i = last - 1; i >= 0; i--) {
            pHead.next = new ListNode(list.get(i), null);
            pHead = pHead.next;
        }
        return h;
    }

    // 将每一个节点的指针都指向他前面的节点
    public ListNode reverseList2(ListNode listNode) {
        ListNode curr = listNode;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}