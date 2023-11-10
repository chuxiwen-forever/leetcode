package com.liu.week1.day3.p234;

import java.util.ArrayList;
import java.util.List;

/***
 * @description: leetcode p234 回文链表
 * @auther: chuxiwen
 * @date: 2023/9/20 18:08
 * @version 1.0
 */

public class Solve {

    // 存到数组中 进行处理
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int num = list.size() / 2;
        for (int i = 0; i < num; i++) {
            if (list.get(i) != list.get(list.size() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}