package com.liu.day2.p21;

/***
 * @description: leetcode p21 合并两个有序链表
 * @auther: Liu.
 * @date: 2023/9/19 14:53
 * @version 1.0
 */

public class Solve {

    // 将两个链表打碎，重新拼接
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(-1);
        ListNode result = res;
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                result.next = list2;
                list2 = list2.next;
            } else {
                result.next = list1;
                list1 = list1.next;
            }
            result = result.next;
        }
        result.next = list1 == null ? list2 : list1;
        return res.next;
    }

    // 创建一个新的链表
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(-1);
        ListNode result = res;
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                result.next = new ListNode(list2.val, null);
                list2 = list2.next;
            } else {
                result.next = new ListNode(list1.val, null);
                list1 = list1.next;
            }
            result = result.next;
        }
        while (list1 != null) {
            result.next = new ListNode(list1.val, null);
            list1 = list1.next;
            result = result.next;
        }

        while (list2 != null) {
            result.next = new ListNode(list2.val, null);
            list2 = list2.next;
            result = result.next;
        }
        return res.next;
    }

}