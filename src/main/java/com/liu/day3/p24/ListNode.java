package com.liu.day3.p24;

/***
 * @description:
 * @auther: chuxiwen
 * @date: 2023/9/20 16:31
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