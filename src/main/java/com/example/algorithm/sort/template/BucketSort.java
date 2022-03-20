package com.example.algorithm.sort.template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author xxs
 * @create 2022/3/20 22:03
 * 桶排序
 */
public class BucketSort {
    public static void main(String[] args) {
         int[] arr = {1,5,2,3,4,1};
         bucketSort(arr);
         System.out.println(Arrays.toString(arr));
    }

    public static void bucketSort(int[] arr){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int item : arr) {
            max = Math.max(max, item);
            min = Math.min(min, item);
        }
        //桶数
        int bucketNum = (max - min) / arr.length + 1;

        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketArr.add(new ArrayList<>());
        }

        for (int value : arr) {
            int num = (value - min) / (arr.length);
            bucketArr.get(num).add(value);
        }

        for (ArrayList<Integer> integers : bucketArr) {
            Collections.sort(integers);
        }

        ArrayList<Integer> res = bucketArr.get(0);
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
    }
}
