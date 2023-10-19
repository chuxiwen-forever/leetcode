package com.liu.day18.p503;


import java.util.Arrays;
import java.util.Stack;

/***
 * @description: <a href="https://leetcode.cn/problems/next-greater-element-ii/">leetcode p503 下一个更大元素 II</a>。
 * @auther: chuxiwen
 * @date: 2023/10/19 13:48
 * @version 1.0
 */

public class Solve {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(ans, -1);
        for (int i = 0; i < 2 * n - 1; i++) {
            while (!stack.empty() && nums[stack.peek()] < nums[i % n]) {
                ans[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ans;
    }
}
