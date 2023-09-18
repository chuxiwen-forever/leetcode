package com.liu.day1.p337;

/***
 * @description: leetcode 337. 打家劫舍 III
 * @auther: Liu.
 * @date: 2023/9/18 10:05
 * @version 1.0
 */
public class Solve {
    public int getValue() {
        TreeNode treeNode = new TreeNode(0);
        int[] rootValue = dfs(treeNode);
        return Math.max(rootValue[0], rootValue[1]);
    }

    // 从叶子节点推到根节点
    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        // l 为左节点 l[0]为不选择该节点，l[1]为选择该节点
        int[] l = dfs(node.left);
        // r 为左节点 r[0]为不选择该节点，r[1]为选择该节点
        int[] r = dfs(node.right);

        // 如果选择当前节点，那不可以在选择左右孩子节点
        int selected = node.val + l[0] + r[0];
        // 如果不选择当前节点，可以选择左右孩子节点
        int noSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{noSelected, selected};
    }
}