package com.example.algorithm.sweepline.template;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xxs
 * @create 2022/3/23 21:20
 * 扫描线的模板
 * intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 链接 会议室二 LeetCode
 */
public class SweepLine {
    public static void main(String[] args) {
        int[][] intervals = {{0,30},{5,10},{15,20}};
        int cnt = slove(intervals);
        System.out.println(cnt);
    }

    /**
     * 扫描线
     * @param intervals
     * @return
     */
    private static int slove(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            list.add(new int[]{interval[0], 1});
            list.add(new int[]{interval[1], -1});
        }
        list.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int cnt = 0, res = 0;
        for (int[] point : list) {
            cnt += point[1];
            res = Math.max(res, cnt);
        }
        return res;
    }
}
