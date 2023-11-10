package com.liu.week3.day3.p189;


/***
 * @description: <a href="https://leetcode.cn/problems/rotate-array/">leetcode p189 轮转数组</a>。
 * @auther: chuxiwen
 * @date: 2023/10/12 13:41
 * @version 1.0
 */

public class Solve {
    // 空间负责度 O(n) 新开一个数组
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            // i  向后移动 k 位，然后取mod，以防数组越界
            arr[(i + k) % n] = nums[i];
        }
        System.arraycopy(arr, 0, nums, 0, n);
    }

    // 空间复杂度 O(1)
    public void rotate1(int[] nums, int k) {
        // 防止k过大，数组越界
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
