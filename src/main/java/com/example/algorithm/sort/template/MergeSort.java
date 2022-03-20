package com.example.algorithm.sort.template;

import java.util.Arrays;

/**
 * @author xxs
 * @create 2022/3/20 19:12
 * 归并排序
 * 时间复杂度O(n log n) 空间复杂度 O(n) 模板
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1,5,4,2,3,2};
        int[] res = divide(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(res));
    }

    private static int[] divide(int[] arr, int left, int right) {
        if (left >= right) return new int[]{arr[left]};
        int mid = left + (right - left) / 2;
        int[] leftRes = divide(arr, left, mid);
        int[] rightRes = divide(arr, mid + 1, right);
        return merge(leftRes, rightRes);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {res[k++] = left[i++];}
            else { res[k++] = right[j++];}
        }
        while (i < left.length) { res[k++] = left[i++];}
        while (j < right.length) {res[k++] = right[j++];}
        return res;
    }
}
