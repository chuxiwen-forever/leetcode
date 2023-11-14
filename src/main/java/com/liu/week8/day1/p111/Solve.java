package com.liu.week8.day1.p111;

/***
 * @description: <a href="https://leetcode.cn/problems/minimum-depth-of-binary-tree/">leetcode p111. 二叉树的最小深度</a>。
 * @auther: chuxiwen
 * @date: 2023/11/13 11:55
 * @version 1.0
 */

class Solve {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);

        return root.left == null || root.right == null ? m1 + m2 + 1 : Math.min(m1, m2) + 1;
    }
}
