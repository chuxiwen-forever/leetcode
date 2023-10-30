package com.liu.day25.p110;


/***
 * @description: <a href="https://leetcode.cn/problems/balanced-binary-tree/">leetcode p110 平衡二叉树</a>。
 * @auther: chuxiwen
 * @date: 2023/10/30 15:51
 * @version 1.0
 */


public class Solve {

    // 自下而上的判断
    public boolean isBalanced(TreeNode root) {
        return dfs(root) >= 0;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int l = dfs(root.left), r = dfs(root.right);
        if (l == -1 || r == -1 || Math.abs(l - r) > 1) return -1;
        else return Math.max(l, r) + 1;
    }

    // 自上向下判断
    public boolean isBalanced1(TreeNode root) {
        if (root == null) return true;
        return Math.abs(h(root.left) - h(root.right)) <= 1 && isBalanced1(root.left) && isBalanced1(root.right);
    }

    private int h(TreeNode root) {
        if (root == null) return 0;
        return Math.max(h(root.right), h(root.left)) + 1;
    }
}
