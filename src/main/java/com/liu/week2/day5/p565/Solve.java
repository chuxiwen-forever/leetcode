package com.liu.week2.day5.p565;

/***
 * @description: <a href="https://leetcode.cn/problems/array-nesting/">leetcode p565 数组嵌套 </a>。
 * @auther: chuxiwen
 * @date: 2023/10/9 14:22
 * @version 1.0
 */

class Solve {
    // 使用有向图，因为数组中没有重复的数值，所以不会存在重复的路线，vis数组可以外放
    public int arrayNesting(int[] nums) {
        int max = 0, n = nums.length;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int cnt = 0;
            // 这里不需要担心i超过n
            // [1,3,6,4,0,2,5]
            //            1         3         4         0          1
            // 行进路线为，num[0] -> num[1] -> num[3] -> num[4] -> num[0]  => 4
            // 然后i 为 0 ; i++ for 使下一次从num[1] ; while跳过, i++, for 使下一次从num[2]
            //             6          5       2          6
            // 行进路线为，num[2] -> num[6] -> num[5] -> num[2] => 3 ; 这时候max为4，vis[]全部为ture,所以接下来for全部通过
            while (!vis[i]) {
                vis[i] = true;
                i = nums[i];
                ++cnt;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }

    // 将上面的boolean优化掉，将走过的路线标价为-1
    public int arrayNesting1(int[] nums) {
        int n = nums.length, max = 0;
        for (int i = 0; i < n; i++) {
            int ans = 0;
            while (nums[i] != -1) {
                int temp = i;
                i = nums[i];
                nums[temp] = -1;
                ans++;
            }
            max = Math.max(max, ans);
        }
        return max;
    }
}
