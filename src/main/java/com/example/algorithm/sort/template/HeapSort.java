package com.example.algorithm.sort.template;

import java.util.Arrays;

/**
 * @author xxs
 * @create 2022/3/20 20:02
 * 堆排序 时间复杂度O(n log n)
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {1,5,3,4,2};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序
     * @param arr
     */
    private static void heapSort(int[] arr) {
         // 构建大根堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr,i,arr.length);
        }

        // 调整堆的结构 swap 堆顶 和 last index
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr,0,j);
            adjustHeap(arr,0,j);
        }
    }

    /**
     * 调整大根堆
     * @param arr
     * @param i
     * @param length
     */
    private static void adjustHeap(int[] arr, int i, int length) {
        int tem = arr[i];
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
            if ((k + 1) < length && arr[k] < arr[k + 1]) {
                // right 大
                k++;
            }
            if (arr[k] > tem) {
                arr[i] = arr[k];
                i = k;
            }else {
                // 说明 arr[i]是大的
                break;
            }
            arr[i] = tem;
        }
    }

    /**
     * swap
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
