package com.example.algorithm.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author qiaopeng
 * @Date 2024/7/12 22:09
 * 全排列
 * 回溯
 */
public class Permute {

    public static void main(String[] args) {

    }

    private final List<List<Integer>> res = new ArrayList<>();
    private final LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums);
        return res;
    }

    void dfs(int[] nums) {
        // 边界
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        }
        for (int num : nums) {
            if (list.contains(num)) continue;
            list.add(num);
            dfs(nums);
            // 恢复
            list.removeLast();
        }
    }
}
