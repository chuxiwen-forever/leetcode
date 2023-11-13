package com.liu.week8.day1.p307;

/***
 * @description: <a href="https://leetcode.cn/problems/range-sum-query-mutable/">leetcode p307. 区域和检索 - 数组可修改</a>。
 * @auther: chuxiwen
 * @date: 2023/11/13 09:28
 * @version 1.0
 */

// 线段数解决
class NumArray1 {

    private final int[] segmentTree;
    private final int n;

    public NumArray1(int[] nums) {
        n = nums.length;
        segmentTree = new int[n * 4];
        build(0, 0, n - 1, nums);
    }

    private void build(int node, int l, int r, int[] nums) {
        if (l == r) {
            segmentTree[node] = nums[l];
            return;
        }
        int mid = l + ((r - l) >> 1);
        build(node * 2 + 1, l, mid, nums);
        build(node * 2 + 2, mid + 1, r, nums);
        segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
    }

    public void update(int index, int val) {
        change(index, val, 0, 0, n - 1);
    }

    private void change(int index, int val, int node, int l, int r) {
        if (l == r) {
            segmentTree[node] = val;
            return;
        }
        int mid = l + ((r - l) >> 1);
        if (index <= mid) {
            change(index, val, node * 2 + 1, l, mid);
        } else {
            change(index, val, node * 2 + 2, mid + 1, r);
        }
        segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
    }

    public int sumRange(int left, int right) {
        return range(left, right, 0, 0, n - 1);
    }

    private int range(int left, int right, int node, int l, int r) {
        if (left == l && right == r) {
            return segmentTree[node];
        }
        int mid = l + ((r - l) >> 1);
        if (right <= mid) {
            return range(left, right, node * 2 + 1, l, mid);
        } else if (left > mid) {
            return range(left, right, node * 2 + 2, mid + 1, r);
        } else {
            return range(left, mid, node * 2 + 1, l, mid) + range(mid + 1, right, node * 2 + 2, mid + 1, r);
        }
    }
}
