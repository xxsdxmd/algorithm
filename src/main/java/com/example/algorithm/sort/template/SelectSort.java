package com.example.algorithm.sort.template;

import java.util.Arrays;

/**
 * @author xxs
 * @create 2022/3/19 23:00
 * 选择排序 时间复杂度 O(n^2) 空间复杂度O(1)
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {1,5,2,3,4,2};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序
     * @param arr
     */
    private static void selectSort(int[] arr) {
        // loop 寻找 minIndex swap j minIndex
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr,minIndex,i);
        }
    }

    /**
     * swap
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }
}
