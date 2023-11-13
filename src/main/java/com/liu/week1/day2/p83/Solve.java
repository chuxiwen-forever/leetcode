package com.liu.week1.day2.p83;

/***
 * @description: leetcode p83 删除排序链表中的重复元素
 * @auther: chuxiwen
 * @date: 2023/9/19 15:33
 * @version 1.0
 */

class Solve {

    // 在原来的链表上进行操作
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }


    // 创建一个新的链表
    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode(-101);
        ListNode temp = result;
        while (head != null) {
            if (head.val != temp.val) {
                temp.next = new ListNode(head.val, null);
                temp = temp.next;
            }
            head = head.next;
        }
        return result.next;
    }
}