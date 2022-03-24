package com.example.algorithm.sweepline;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xxs
 * @create 2022/3/24 19:45
 * 数飞机
 * 链接: https://www.lintcode.com/problem/391/
 */
public class CountOfAirplanes {
    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1,10));
        list.add(new Interval(2,3));
        int cnt = slove(list);
        System.out.println(cnt);
    }

    /**
     * 扫描线
     * @param airplanes
     * @return
     */
    private static int slove(List<Interval> airplanes) {
        if (airplanes == null || airplanes.size() == 0) return 0;
        List<int[]> list = new ArrayList<>();
        for (Interval interval : airplanes) {
            list.add(new int[]{interval.start,1});
            list.add(new int[]{interval.end, -1});
        }
        list.sort((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int res = 0, cnt = 0;
        for (int[] point : list) {
            cnt += point[1];
            res = Math.max(cnt, res);
        }
        return res;
    }
}


class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}