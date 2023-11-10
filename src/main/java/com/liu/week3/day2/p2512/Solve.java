package com.liu.day12.p2512;

import java.util.*;

/***
 * @description: <a href="https://leetcode.cn/problems/reward-top-k-students/">leetcode p2512 奖励最顶尖的 K 名学生 </a>。
 * @auther: chuxiwen
 * @date: 2023/10/11 09:06
 * @version 1.0
 */

public class Solve {

    public TreeMap<Integer, PriorityQueue<Integer>> student = new TreeMap<>();

    // 使用treeMap维护score,使用priorityQueue获取同一个score的学号
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String string : positive_feedback) map.put(string, 3);
        for (String string : negative_feedback) map.put(string, -1);

        for (int i = 0; i < student_id.length; i++) {
            String studentInfo = report[i];
            int score = 0;
            for (String string : studentInfo.split(" ")) {
                score += map.getOrDefault(string, 0);
            }
            if (student.containsKey(score)) {
                PriorityQueue<Integer> integers = student.get(score);
                integers.add(student_id[i]);
            } else {
                PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
                priorityQueue.add(student_id[i]);
                student.put(score, priorityQueue);
            }
        }

        int n = 0;
        boolean flag = false;
        List<Integer> targetStudent = new ArrayList<>();
        while (!student.isEmpty()) {
            PriorityQueue<Integer> integers = student.get(student.lastKey());
            while (!integers.isEmpty()) {
                targetStudent.add(integers.poll());
                n++;
                if (n == k) {
                    flag = true;
                    break;
                }
            }
            student.remove(student.lastKey());
            if (flag) {
                break;
            }
        }
        return targetStudent;
    }

    // 官方
    public List<Integer> topStudents1(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Map<String, Integer> words = new HashMap<>();
        for (String word : positive_feedback) {
            words.put(word, 3);
        }
        for (String word : negative_feedback) {
            words.put(word, -1);
        }
        int n = report.length;
        int[][] A = new int[n][2];
        for (int i = 0; i < n; i++) {
            int score = 0;
            for (String word : report[i].split(" ")) {
                score += words.getOrDefault(word, 0);
            }
            A[i] = new int[]{-score, student_id[i]};
        }
        Arrays.sort(A, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<Integer> topK = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            topK.add(A[i][1]);
        }
        return topK;
    }
}
