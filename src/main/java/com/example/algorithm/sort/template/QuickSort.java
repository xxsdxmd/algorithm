package com.example.algorithm.sort.template;

import java.util.Arrays;

/**
 * @author xxs
 * @create 2022/3/20 17:50
 * 快速排序 时间复杂度 O(n log n) 空间复杂度O(1)
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1,5,2,3,4,2};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序
     * @param arr
     */
    private static void quickSort(int[] arr) {
        sort(arr,0,arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        if (left >= right) return;
        int index = getIndex(arr, left, right);
        sort(arr, left,index - 1);
        sort(arr, index + 1, right);
    }

    private static int getIndex(int[] arr, int left, int right) {
        int base = arr[right], wall = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < base) {
                swap(arr,i,wall);
                wall++;
            }
        }
        swap(arr,wall,right);
        return wall;
    }

    private static void swap(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }

}
