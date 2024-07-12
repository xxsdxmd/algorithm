package com.example.algorithm.graph;

import java.util.*;

/**
 * @author xxs
 * @Date 2024/7/11 23:58
 * 课程表
 */
public class Courses {
    public static void main(String[] args) {

    }


    /**
     * [[3, 0], [3, 1], [4, 1], [4, 2], [5, 3], [5, 4]]
     * 0 1 -> 3  1 2 -> 4  3 4 -> 5 0 1 2 入度为0  3 4 5 出度为2
     * 根据依赖关系，构建邻接表、入度数组。
     * 选取入度为 0 的数据，根据邻接表，减小依赖它的数据的入度。
     * 找出入度变为 0 的数据，重复第 2 步。
     * 直至所有数据的入度为 0，得到排序，如果还有数据的入度不为 0，说明图中存在环。
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] ing = new int[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            // 计算出度
            ing[prerequisite[0]]++;
            List<Integer> curVal = adj.getOrDefault(prerequisite[1], new ArrayList<>());
            curVal.add(prerequisite[0]);
            adj.put(prerequisite[1], curVal);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < ing.length; i++) {
            if (ing[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            numCourses--;
            for (int next: adj.getOrDefault(cur, new ArrayList<>())) {
                if (--ing[next] == 0) {
                    queue.add(next);
                }
            }
        }
        return numCourses == 0;
    }


}
