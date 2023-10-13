package com.liu.day14.p496;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/***
 * @description: <a href="https://leetcode.cn/problems/next-greater-element-i/">leetcode p496 下一个更大元素 I</a>。
 * @auther: chuxiwen
 * @date: 2023/10/13 10:10
 * @version 1.0
 */

public class Solve {
    // 暴力解决
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] ans = new int[n];
        for (int t = 0; t < n; t++) {
            int i;
            boolean notHaveBig = true;
            for (i = 0; i < nums2.length; i++) {
                if (nums1[t] == nums2[i]) break;
            }
            for (int j = i + 1; j < nums2.length; j++) {
                if (nums2[j] > nums1[t]) {
                    ans[t] = nums2[j];
                    notHaveBig = false;
                    break;
                }
            }
            if (notHaveBig) {
                ans[t] = -1;
            }
        }
        return ans;
    }

    // 单调栈 获取距离自己最近的最大数
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            // 如果当前数值大于栈中的，大于他的数可能在后面
            while (!stack.empty() && num > stack.peek()) {
                stack.pop();
            }
            // 如果栈空了，说明没有比当前数组大的数了
            map.put(num, stack.empty() ? -1 : stack.peek());
            // 将当前数存入栈中，以便后续使用
            stack.push(num);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
