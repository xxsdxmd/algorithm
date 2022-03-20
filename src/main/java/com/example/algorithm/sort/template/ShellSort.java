package com.example.algorithm.sort.template;

import java.util.Arrays;

/**
 * @author xxs
 * @create 2022/3/19 23:58
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {1,5,2,3,4,2};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 希尔排序
     * @param arr
     */
    private static void shellSort(int[] arr) {
        // 思路 有gap的插入排序
        int len = arr.length;
        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < len; i++) {
                // 插入排序
                int tem = arr[i];
                int j = i;
                while ((j - gap) >= 0 && arr[j - gap] > tem) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = tem;
            }
        }
    }


}
