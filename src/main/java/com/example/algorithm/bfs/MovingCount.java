package com.example.algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xxs
 * @create 2022/3/26 17:55
 * 计算人的运动范围
 * 链接: https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
public class MovingCount {
    public static void main(String[] args) {
        int m = 2, n = 3, k = 1;
        int cnt = slove(m,n,k);
        System.out.println(cnt);
    }

    /**
     * 也不能进入行坐标和列坐标的数位之和大于k的格子 该机器人能够到达多少个格 bfs
     * @param m
     * @param n
     * @param k
     * @return
     */
    private static int slove(int m, int n, int k) {
       boolean[][] visited = new boolean[m][n];
       int cnt = 0;
       Queue<int[]> queue = new LinkedList<>();
       queue.add(new int[]{0,0});
       while (!queue.isEmpty()) {
           int[] x = queue.poll();
           int i = x[0], j = x[1];
           if (i >= m || j >= n || sum(i,j) > k || visited[i][j]) {
               continue;
           }
           visited[i][j] = true;
           cnt++;
           queue.add(new int[]{i + 1, j});
           queue.add(new int[]{i, j + 1});
       }
       return cnt;
    }

    private static int sum(int i, int j) {
        int sum = 0;
        while (i != 0) {
            sum += (i % 10);
            i = i / 10;
        }
        while (j != 0) {
            sum += (j % 10);
            j = j / 10;
        }
        return sum;
    }
}
