package com.liu.week9.day4.p1410;

/***
 * @description: <a href="https://leetcode.cn/problems/html-entity-parser/">leetcode p1410. HTML 实体解析器</a>。
 * @auther: chuxiwen
 * @date: 2023/11/23 09:14
 * @version 1.0
 */


class Solve {

    public String entityParser(String text) {
        return text.replaceAll("&quot;", "\"")
                .replaceAll("&apos;", "'")
                .replaceAll("&gt;", ">")
                .replaceAll("&lt;", "<")
                .replaceAll("&frasl;", "/")
                .replaceAll("&amp;", "&");
    }
}
