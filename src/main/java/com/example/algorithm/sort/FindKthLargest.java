package com.example.algorithm.sort;

/**
 * @author xxs
 * @create 2022/3/20 18:53
 * 链接 https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 *
 */
public class FindKthLargest {
    public static void main(String[] args) {
      int[] arr = {1,3,2,4,5};
      int k = 2;
      sort(arr,0,arr.length - 1,k);
    }

    private static void sort(int[] arr, int left, int right, int k) {
            if (left >= right) return;
            int index = getIndex(arr, left, right);
            if (arr.length - k == index) return;
            else if (arr.length - k > index) {
                sort(arr,index + 1, right ,k);
            }else {
                sort(arr, left, index - 1,k);
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
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
    }

}
