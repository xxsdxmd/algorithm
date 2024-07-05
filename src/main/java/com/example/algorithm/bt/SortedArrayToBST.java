package com.example.algorithm.bt;

/**
 * @Author qiaopeng
 * @Date 2024/7/5 23:37
 * 将有序数组转换为二叉搜索树
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        System.out.println(sortedArrayToBST(nums));
    }

    /**
     * 将有序数组转换为二叉搜索树
     * @param nums
     * @return
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }


    static TreeNode dfs(int[] nums, int l, int r) {
        if (l > r) return null;
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, l , mid - 1);
        root.right = dfs(nums, mid + 1, r);
        return root;
    }

}
