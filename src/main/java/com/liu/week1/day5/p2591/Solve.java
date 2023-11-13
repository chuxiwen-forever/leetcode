package com.liu.week1.day5.p2591;

/***
 * @description: <a href="https://leetcode.cn/problems/distribute-money-to-maximum-children/">leetcode p2591 将钱分给最多的儿童 </a>。
 * @auther: chuxiwen
 * @date: 2023/9/22 17:00
 * @version 1.0
 */

class Solve {

    public int distMoney(int money, int children) {
        // 如果钱比人还少，肯定没有分配方案，因为每人必须一块钱
        if (money < children) {
            return -1;
        }
        // 题目要求每一个人都不能少于一元钱
        money -= children;
        // 给每一个小孩七块，凑最多个 8 元
        int p = Math.min(money / 7, children);
        // 检查有多少个小孩还没有 8
        children -= p;
        // 检查给若干给小孩后，还有多少钱
        money -= p * 7;

        // 如果所以小孩都有8元了，还有剩余那就说明肯定还有小孩大于8
        // 如果有一个小孩没8，但是剩下的钱只能让他凑够4，就需要将这剩余的钱分配到两个小孩身上（题目要求不能为4）
        if ((children == 0 && money > 0) || (children == 1 && money == 3)) {
            p--;
        }
        return p;
    }
}