package com.liu.week2.day1.p23;

import java.util.PriorityQueue;

/***
 * @description: <a href="https://leetcode.cn/problems/merge-k-sorted-lists/description/">leetcode p23 合并 K 个升序链表 </a>。
 * @auther: chuxiwen
 * @date: 2023/9/24 18:10
 * @version 1.0
 */

public class Solve {

    // 最优解 优先队列
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }
        while (!queue.isEmpty()) {
            ListNode listNode = queue.poll();
            temp.next = listNode;
            temp = temp.next;
            if (listNode.next != null) {
                queue.offer(listNode.next);
            }
        }
        return head.next;
    }
}