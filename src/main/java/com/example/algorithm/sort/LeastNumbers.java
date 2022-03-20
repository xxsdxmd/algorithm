package com.example.algorithm.sort;

import java.util.Arrays;

/**
 * @author xxs
 * @create 2022/3/20 18:18
 * 链接 https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 最小的K个数
 */
public class LeastNumbers {
    public static void main(String[] args) {
        int[] arr = {1,4,3,2,2};
        int k = 2;
        sort(arr,0,arr.length - 1,k);
        int[] res = Arrays.copyOfRange(arr, 0, k);
        System.out.println(arr[k]);
    }

    /**
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static void sort(int[] arr, int left, int right, int k) {
        if (left >= right) return;
        int index = getIndex(arr,left,right);
        if (index == k) return;
        else if (index > k) {
            sort(arr, left, index - 1,k);
        }else {
            sort(arr,index + 1, right,k);
        }
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
