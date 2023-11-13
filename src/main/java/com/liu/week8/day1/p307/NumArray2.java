package com.liu.week8.day1.p307;

/***
 * @description: <a href="https://leetcode.cn/problems/range-sum-query-mutable/">leetcode p307. 区域和检索 - 数组可修改</a>。
 * @auther: chuxiwen
 * @date: 2023/11/13 10:14
 * @version 1.0
 */

// 树状数组
public class NumArray2 {

    private final int[] tree;
    private final int[] nums;

    public NumArray2(int[] nums) {
        tree = new int[nums.length + 1];
        this.nums = nums;
        for (int i = 0; i < nums.length; i++) add(i + 1, nums[i]);
    }

    public void update(int index, int val) {
        add(index + 1, val - nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return prefixSum(right + 1) - prefixSum(left);
    }

    private int lowBit(int x) {
        return x & -x;
    }

    private void add(int index, int val) {
        while (index < tree.length) {
            tree[index] += val;
            index += lowBit(index);
        }
    }

    private int prefixSum(int index) {
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= lowBit(index);
        }
        return sum;
    }
}
