package com.liu.week3.day4.p20;


import java.util.Stack;

/***
 * @description: <a href="https://leetcode.cn/problems/valid-parentheses/">leetcode p20 有效的括号</a>。
 * @auther: chuxiwen
 * @date: 2023/10/13 10:10
 * @version 1.0
 */
class Solve {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (!stack.empty() && checkCharacter(stack.peek(), c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private boolean checkCharacter(Character a, Character b) {
        return (a == '{' && b == '}') || (a == '(' && b == ')') || (a == '[' && b == ']');
    }
}
