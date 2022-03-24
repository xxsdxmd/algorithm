package com.example.algorithm.sweepline;

import java.util.Arrays;

/**
 * @author xxs
 * @create 2022/3/24 20:19
 * 会议室
 * 链接: https://leetcode-cn.com/problems/meeting-rooms/
 */
public class CanAttendMeetings {
    public static void main(String[] args) {
        int[][] intervals = {{0,30},{5,10},{15,20}};
        boolean res = slove(intervals);
        System.out.println(res);
    }

    /**
     * 会议室 扫描线 判断是否有交集
     * @param intervals
     * @return
     */
    private static boolean slove(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return false;
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i -1][1]) {
                return false;
            }
        }
        return true;
    }
}
