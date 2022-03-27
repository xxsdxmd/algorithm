package com.example.algorithm.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xxs
 * @create 2022/3/27 21:45
 * 课程表
 * 链接: https://leetcode-cn.com/problems/course-schedule/
 */
public class CanFinish {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{0,1}};
        boolean res = canFinish(numCourses,prerequisites);
        System.out.println(res);
    }

    /**
     * bfs 有向图判断环
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] degree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int start = prerequisites[i][0], end = prerequisites[i][1];
            map.computeIfAbsent(start, x -> new ArrayList<>()).add(end);
            degree[end]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            cnt++;
            for (int nei : map.getOrDefault(cur, new ArrayList<>())) {
                if (--degree[nei] == 0) {
                    queue.add(nei);
                }
            }
        }
        return cnt == numCourses;
    }
}
