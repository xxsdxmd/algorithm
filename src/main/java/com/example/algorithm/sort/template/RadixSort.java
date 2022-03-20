package com.example.algorithm.sort.template;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * @author xxs
 * @create 2022/3/20 22:02
 * 基数排序
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {1,5,2,1,4};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 基数排序
     * @param arr
     */
    public static void radixSort(int[] arr) {
        int digit = getMaxDigit(arr);
        for (int i = 0; i < digit; i++) {
            bucketSort(arr, i);
        }
    }

    public static int getMaxDigit(int[] arr) {
        int digit = 1;
        int base = 10;
        for (int i : arr) {
            while (i > base) {
                digit++;
                base *= 10;
            }
        }
        return digit;
    }

    public static void bucketSort(int[] arr, int digit) {
        int base = (int) Math.pow(10, digit);
        // init buckets
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<Integer>());
        }
        // sort
        for (int i : arr) {
            int index = i / base % 10;
            buckets.get(index).add(i);
        }
        // output: copy back to arr
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int i : bucket) {
                arr[index++] = i;
            }
        }
    }
}
