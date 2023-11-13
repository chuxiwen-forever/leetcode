package com.liu.week1.day3.p445;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/***
 * @description: leetcode p445 两数相加 2
 * @auther: chuxiwen
 * @date: 2023/9/20 17:05
 * @version 1.0
 */

class Solve {

    // 也可以使用栈存储数据 可以节省很多内存 也不需要考虑数组越界
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        // 记录进位的数据
        int mount = 0;
        ListNode ans = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || mount != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int cur = a + b + mount;
            mount = cur / 10;
            cur %= 10;
            // 头插法插入链表
            ListNode curNode = new ListNode(cur);
            curNode.next = ans;
            ans = curNode;
        }
        return ans;
    }


    // 使用新的数组承接链表中的数据
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 将两个链表中的数字存储到数组中
        List<Integer> l1List = new ArrayList<>();
        List<Integer> l2List = new ArrayList<>();
        while (l1 != null) {
            l1List.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            l2List.add(l2.val);
            l2 = l2.next;
        }

        int l1Size = l1List.size() - 1;
        int l2Size = l2List.size() - 1;

        List<Integer> resultList = new ArrayList<>();
        // 承接多出来的数，超出十的数
        int mount = 0;
        int i = 0;
        // 将两个数组的每一位进行相加
        while (i <= l1Size && i <= l2Size) {
            int bit = l1List.get(l1Size - i) + l2List.get(l2Size - i) + mount;
            resultList.add(bit % 10);
            mount = bit / 10;
            i++;
        }

        while (i <= l1Size) {
            int bit = l1List.get(l1Size - i) + mount;
            mount = bit / 10;
            resultList.add(bit % 10);
            i++;
        }

        while (i <= l2Size) {
            int bit = l2List.get(l2Size - i) + mount;
            mount = bit / 10;
            resultList.add(bit % 10);
            i++;
        }

        // 如果加出来的数字不是0，就说明多出一位，例如：5 + 5 = 10
        if (mount != 0) {
            resultList.add(1);
        }

        int resultCount = resultList.size();

        ListNode node = new ListNode(resultList.get(resultCount - 1), null);
        ListNode result = node;
        for (int j = resultCount - 2; j >= 0; j--) {
            node.next = new ListNode(resultList.get(j), null);
            node = node.next;
        }
        return result;
    }
}