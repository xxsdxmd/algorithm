package com.example.algorithm.sweepline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xxs
 * @create 2022/3/24 20:28
 * 合并区间
 * 链接: https://leetcode-cn.com/problems/SsGoHC/
 */
public class Merge {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10}};
        int[][] res = merge(intervals);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 合并区间
     * @param intervals
     * @return
     */
    private static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[][]{};
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals,(a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] tem = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (tem[1] > intervals[i][0]) {
                tem[1] = Math.max(tem[1], intervals[i][1]);
            }else {
                res.add(tem);
                tem = intervals[i];
            }
        }
        res.add(tem);
        int[][] r = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;
    }
}
