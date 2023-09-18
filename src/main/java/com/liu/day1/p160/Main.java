package com.liu.day1.p160;

/***
 * @description: leetcode p160 相交链表
 * @auther: Liu.
 * @date: 2023/9/18 14:58
 * @version 1.0
 */

public class Main {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode intersectionNode = getIntersectionNode(a, b);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

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