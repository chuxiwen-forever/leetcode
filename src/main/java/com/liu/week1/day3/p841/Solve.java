package com.liu.week1.day3.p841;

import java.util.List;

/***
 * @description: leetcode p841 钥匙和房间
 * @auther: chuxiwen
 * @date: 2023/9/20 15:46
 * @version 1.0
 */

public class Solve {

    boolean[] vis;

    int count;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int roomNum = rooms.size();
        count = 0;
        vis = new boolean[roomNum];
        dfs(rooms, 0);
        return roomNum == count;
    }

    // 遍历所有房间，将已经进入的房间标记成已经进入，房间一个一个走，走到底
    private void dfs(List<List<Integer>> rooms, int i) {
        vis[i] = true;
        count++;
        for (int j = 0; j < rooms.get(i).size(); j++) {
            Integer roomPointer = rooms.get(i).get(j);
            if (!vis[roomPointer]) {
                dfs(rooms, roomPointer);
            }
        }
    }
}