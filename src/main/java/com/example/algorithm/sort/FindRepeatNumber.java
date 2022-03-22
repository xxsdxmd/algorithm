package com.example.algorithm.sort;

import java.util.HashSet;

/**
 * @author xxs
 * @create 2022/3/22 17:57
 * 链接: https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class FindRepeatNumber {
    public static void main(String[] args) {
        int[] arr = {2,3,1,0,2,5,3};
        int res = slove(arr);
        System.out.println(res);
        res = sloveTwo(arr);
        System.out.println(res);
    }


    /**
     * 用set 来保存 时间复杂度O(n) 空间复杂度O(n)
     * @param arr
     * @return
     */
    private static int slove(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int value : arr) {
            if (set.contains(value)) {
                return value;
            }else {
                set.add(value);
            }
        }
        return -1;
    }

    /**
     * 原地hash 时间复杂度O(n) 空间复杂度O(1)
     * @param arr
     * @return
     */
    private static int sloveTwo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i) {
                if (arr[arr[i]] == arr[i]) {return arr[i];}
                swap(arr,arr[i],i);
            }
        }
        return -1;
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
