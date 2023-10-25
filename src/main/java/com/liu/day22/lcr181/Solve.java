package com.liu.day22.lcr181;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/***
 * @description: <a href="https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/">leetcode LCR 181 字符串中的单词反转</a>。
 * @auther: chuxiwen
 * @date: 2023/10/25 14:04
 * @version 1.0
 */

public class Solve {

    // 切割+倒序拼接
    public String reverseMessage(String message) {
        String[] strings = message.split(" ");
        List<String> stringList = Arrays.stream(strings).filter(item -> !"".equals(item)).collect(Collectors.toList());
        if (stringList.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = stringList.size() - 1; i >= 1; i--) {
            sb.append(stringList.get(i)).append(" ");
        }
        sb.append(stringList.get(0));
        return sb.toString();
    }

    // 双指针倒序输出
    public String reverseMessage1(String message){
        message = message.trim();                               // 删除首尾空格
        int j = message.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && message.charAt(i) != ' ') i--;     // 搜索首个空格
            res.append(message, i + 1, j + 1).append(" ");  // 添加单词
            while (i >= 0 && message.charAt(i) == ' ') i--;     // 跳过单词间空格
            j = i;                                              // j 指向下个单词的尾字符
        }
        return res.toString().trim();                           // 转化为字符串并返回
    }
}
