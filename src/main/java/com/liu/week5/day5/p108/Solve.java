package com.liu.day25.p108;


/***
 * @description: <a href="https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/">leetcode p108 将有序数组转换为二叉搜索树</a>。
 * @auther: chuxiwen
 * @date: 2023/10/30 14:33
 * @version 1.0
 */

public class Solve {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    // 中序遍历
    private TreeNode dfs(int[] nums, int left, int right) {

        if (left > right) return null;

        int mid = left + ((right - left) >> 1);
        TreeNode root = new TreeNode(nums[mid]);

        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid + 1, right);
        return root;
    }
}
