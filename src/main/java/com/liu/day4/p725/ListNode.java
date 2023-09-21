package com.liu.day4.p725;

/***
 * @description:
 * @auther: Liu.
 * @date: 2023/9/21 12:32
 * @version 1.0
 */

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}