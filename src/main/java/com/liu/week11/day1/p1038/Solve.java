package com.liu.week11.day1.p1038;

/***
 * @description: <a href="https://leetcode.cn/problems/binary-search-tree-to-greater-sum-tree/">leetcode p1038. 从二叉搜索树到更大和树</a>。
 * @auther: chuxiwen
 * @date: 2023/12/04 09:03
 * @version 1.0
 */

class Solve {

    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            bstToGst(root.right);
            sum += root.val;
            root.val = sum;
            bstToGst(root.left);
        }
        return root;
    }
}
