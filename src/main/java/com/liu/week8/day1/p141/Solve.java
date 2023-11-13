package com.liu.week8.day1.p141;


import java.util.HashSet;
import java.util.Set;

/***
 * @description: <a href="https://leetcode.cn/problems/linked-list-cycle/">leetcode p141. 环形链表</a>。
 * @auther: chuxiwen
 * @date: 2023/11/13 11:28
 * @version 1.0
 */

class Solve {

    // 哈希set
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    // 快慢指针
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
