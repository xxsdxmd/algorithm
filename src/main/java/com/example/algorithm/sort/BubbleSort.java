package com.example.algorithm.sort;

import java.util.Arrays;

/**
 * @author xxs
 * @create 2022/3/19 22:37
 * 冒泡排序
 * 时间复杂度 O(n^2) 空间复杂度 O(1)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1,5,2,3,4,2};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        // 思路 swap  如果 j > j + 1 swap
        for (int i = 0; i < arr.length -1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr,j,j + 1);
                }
            }
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
