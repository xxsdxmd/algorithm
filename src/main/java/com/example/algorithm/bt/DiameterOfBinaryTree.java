package com.example.algorithm.bt;

/**
 * @Author qiaopeng
 * @Date 2024/7/5 22:22
 * 二叉树的直径
 */
public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        System.out.println(diameterOfBinaryTree(TreeNodeFactory.createTreeNode()));
    }

    static int res = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    static int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left), r = dfs(root.right);
        res = Math.max(res, l + r);
        return Math.max(l, r) + 1;
    }
}
