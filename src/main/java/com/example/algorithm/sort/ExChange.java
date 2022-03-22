package com.example.algorithm.sort;

import java.util.Arrays;

/**
 * @author xxs
 * @create 2022/3/22 18:44
 * 链接: https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */
public class ExChange {
    public static void main(String[] args) {
       int[] arr = {1,2,3,4};
       slove(arr);
       System.out.println(Arrays.toString(arr));
    }

    /**
     * 双指针
     * @param arr
     */
    private static void slove(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            if (arr[left] % 2 == 1) {
                left++;
                continue;
            }
            if (arr[right] % 2 == 0) {
                right--;
                continue;
            }
            swap(arr,left,right);
        }
    }

    private static void swap(int[] arr, int left, int right) {
        int t = arr[left];
        arr[left] = arr[right];
        arr[right] = t;
    }
}
