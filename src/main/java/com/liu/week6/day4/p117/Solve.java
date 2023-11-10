package com.liu.week6.day4.p117;

import java.util.LinkedList;
import java.util.Queue;

/***
 * @description: <a href="https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/">leetcode p117 填充每个节点的下一个右侧节点指针 II</a>。
 * @auther: chuxiwen
 * @date: 2023/11/03 09:51
 * @version 1.0
 */

public class Solve {
    // 使用队列，一层一层遍历 空间O(n)
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Node last = null;
            for (int i = 1; i <= n; i++) {
                Node poll = queue.poll();
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
                if (i != 1) last.next = poll;
                last = poll;
            }
        }
        return root;
    }


    // 空间O(1) 不使用队列维护
    public Node connect1(Node root) {
        if (root == null)
            return null;
        //cur我们可以把它看做是每一层的链表
        Node cur = root;
        while (cur != null) {
            //遍历当前层的时候，为了方便操作在下一
            //层前面添加一个哑结点（注意这里是访问
            //当前层的节点，然后把下一层的节点串起来）
            Node dummy = new Node(0);
            //pre表示访下一层节点的前一个节点
            Node pre = dummy;
            //然后开始遍历当前层的链表
            while (cur != null) {
                if (cur.left != null) {
                    //如果当前节点的左子节点不为空，就让pre节点
                    //的next指向他，也就是把它串起来
                    pre.next = cur.left;
                    //然后再更新pre
                    pre = pre.next;
                }
                //同理参照左子树
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                //继续访问这样行的下一个节点
                cur = cur.next;
            }
            //把下一层串联成一个链表之后，让他赋值给cur，
            //后续继续循环，直到cur为空为止
            cur = dummy.next;
        }
        return root;
    }
}

