package com.liu.week8.day6.p116;

import java.util.LinkedList;
import java.util.Queue;

/***
 * @description: <a href="https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/">leetcode p116. 填充每个节点的下一个右侧节点指针</a>。
 * @auther: chuxiwen
 * @date: 2023/11/18 09:39
 * @version 1.0
 */


class Solve {
    // 使用队列，进行广度优先遍历，将每一层进行串联
    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node head = new Node();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                head.next = poll;
                head = head.next;
            }
        }
        return root;
    }

    // 直接在链表上进行操作
    public Node connect1(Node root) {
        if (root == null) return null;

        Node curr = root;

        while (curr.left != null) {
            Node head = curr;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            curr = curr.left;
        }

        return root;
    }
}
