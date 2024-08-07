package com.example.algorithm.bt;

/**
 * @author xxs
 * @Date 2024/7/3 23:09
 */
public class TreeNodeFactory {


    /**
     * 创建
     * @return
     */
    public static TreeNode createTreeNode() {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        return root;
    }
}
