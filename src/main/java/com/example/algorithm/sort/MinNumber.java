package com.example.algorithm.sort;

import java.util.Arrays;

/**
 * @author xxs
 * @create 2022/3/22 19:26
 * 链接: https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 */
public class MinNumber {
    public static void main(String[] args) {
       int[] arr = {3,30,34};
       String res = slove(arr);
       System.out.println(res);
    }

    /**
     * 排序就
     * @param arr
     * @return
     */
    private static String slove(int[] arr) {
        int n = arr.length;
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = String.valueOf(arr[i]);
        }
        Arrays.sort(str,(s1,s2) -> {
           return  (s1 + s2).compareTo(s2 + s1);
        });
        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }
        return sb.toString();
    }
}
