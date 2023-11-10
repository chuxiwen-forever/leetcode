package com.liu.week1.day4.p725;

import java.util.ArrayList;
import java.util.List;

/***
 * @description: leetcode p725 分隔链表
 * @auther: chuxiwen
 * @date: 2023/9/21 12:31
 * @version 1.0
 */

public class Solve {

    // 直接操作链表，省空间
    public ListNode[] splitListToParts1(ListNode head, int k) {
        int headLength = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            headLength++;
        }
        int m = headLength / k, n = headLength % k;
        ListNode[] listNodes = new ListNode[k];
        for (int i = 0; i < k; i++) {
            if (head == null) {
                listNodes[i] = null;
                continue;
            }
            listNodes[i] = head;
            int groupNum = m + (i < n ? 1 : 0);
            // 提前将下一个头节点准备好
            for (int j = 1; j < groupNum; j++) {
                head = head.next;
            }
            temp = head.next;
            head.next = null;
            head = temp;
            // 个人感觉下面这种更容易理解，到相应组才开始准备头节点
//            for (int j = 0; j < groupNum; j++) {
//                temp = head;
//                head = head.next;
//            }
//            temp.next = null;
        }
        return listNodes;
    }

    // 将链表的数据存储到数组中，在数组层面进行处理
    public ListNode[] splitListToParts(ListNode head, int k) {
        List<Integer> list = new ArrayList<>();
        ListNode[] listNodes = new ListNode[k];
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        // 例如: 1->2->3->4  分成 5 组
        // n 为 0 ， m 为 4
        // 每组 0 个元素，但是其中四组是 0 + 1 = 1 个元素

        // 例如: 2->3->4->5 分成 3 组
        // n 为 1 ， m 为 1
        // 每组 1 个元素，但是其中一组是 1 + 1 = 2 个元素

        // n 代表每组多少个元素
        int n = list.size() / k;
        // m 代表有几组会多出来一个元素,
        int m = list.size() % k;

        int group = 0;
        int j = 0;
        for (int i = 0; i < k; i++) {
            ListNode ans = new ListNode(0);
            ListNode temp = ans;
            int groupNum = n;
            if (group < m) {
                groupNum++;
            }
            int curGroupNum = 0;
            while (j < list.size() && curGroupNum < groupNum) {
                temp.next = new ListNode(list.get(j));
                temp = temp.next;
                j++;
                curGroupNum++;
            }
            group++;
            listNodes[i] = ans.next;
        }
        return listNodes;
    }
}