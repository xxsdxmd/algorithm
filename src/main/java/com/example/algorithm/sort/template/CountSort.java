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
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[256];
        for (int value : arr) {count[value]++;}
        for (int i = 1; i <= 255; i++) {
            count[i] += count[i - 1];
        }
        // count 0 1 3 4 5 6   arr 1 5 4 2 3 1
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i] - 1]] = arr[i];
            count[arr[i]]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }
}
