package com.example.algorithm.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author qiaopeng
 * @Date 2024/7/12 22:53
 */
public class Subsets {

    public static void main(String[] args) {

    }

    private final List<List<Integer>> res = new ArrayList<>();
    private final LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0,nums);
        return res;
    }

    void dfs(int i, int[] nums) {
        // 边界
        if (i == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        // 不选当前元素
        dfs(i + 1, nums);

        // 选当前元素
        list.add(nums[i]);
        dfs(i + 1, nums);
        list.removeLast();
    }
}
