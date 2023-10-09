package com.liu.day10.p769;

/***
 * @description: <a href="https://leetcode.cn/problems/max-chunks-to-make-sorted/">leetcode p769 最多能完成排序的块 </a>。
 * @auther: chuxiwen
 * @date: 2023/10/9 15:36
 * @version 1.0
 */

public class Solve {
    // 拍好序后的数组： [0, 1, 2, 3, 4, 5]
    // 不管排序前的数组多么混乱，最后一定是回到他应该去的地方
    // 所以分组需要去到他指定的下标，只要可以回自己的位置就可以分组
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int m = 0;
        for (int i = 0; i < arr.length; i++) {
            m = Math.max(m, arr[i]);
            if (m == i) {
                res++;
            }
        }
        return res;
    }

    // 利用排好序后数组下标加起来和数组数据一致的性质
    public int maxChunksToSorted1(int[] arr) {
        int res = 0;
        int cur = 0;
        int need = 0;
        for (int i = 0; i < arr.length; i++) {
            cur += arr[i];
            need += i;
            if (cur == need) res++;
        }
        return res;
    }
}
