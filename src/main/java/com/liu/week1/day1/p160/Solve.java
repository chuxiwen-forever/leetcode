package com.liu.week1.day1.p160;

/***
 * @description: leetcode p160 相交链表
 * @auther: chuxiwen
 * @date: 2023/9/18 14:58
 * @version 1.0
 */

public class Solve {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}