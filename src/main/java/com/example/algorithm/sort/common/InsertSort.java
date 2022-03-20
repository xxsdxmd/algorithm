package com.example.algorithm.sort.common;

import java.util.Arrays;

/**
 * @author xxs
 * @create 2022/3/19 23:12
 * 插入排序 O(n^2) 空间复杂度 O(1)
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {1,5,2,3,4,2};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序
     * @param arr
     */
    private static void insertSort(int[] arr) {
        // 思路 loop 0 - n 把当前元素作为base 去向前找 比他大的元素
        for (int i = 0; i < arr.length; i++) {
            int tem = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > tem) {
                // 给最小值保留位置
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = tem;
        }
    }

}
