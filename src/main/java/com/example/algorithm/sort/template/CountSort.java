package com.example.algorithm.sort.template;

import java.util.Arrays;

/**
 * @author xxs
 * @create 2022/3/20 21:06
 * 计数排序
 */
public class CountSort {
    public static void main(String[] args) {
        int[] arr = {1,5,4,2,3,1};
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 计数排序
     * @param arr
     */
    private static void countSort(int[] arr) {
        // 1,5,4,2,3,1
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int value : arr) {
            min = Math.min(value, min);
            max = Math.max(max, value);
        }
        int[] output = new int[n];
        int[] count = new int[(max - min + 1) + 1];
        for (int value : arr) {
            count[value - min + 1]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int value : arr) {
            output[count[value - min]] = value;
            count[value - min]++;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }
}
