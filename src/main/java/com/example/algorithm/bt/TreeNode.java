package com.example.algorithm.bt;

import lombok.Data;

/**
 * @author xxs
 * @Date 2024/7/3 22:19
 */

@Data
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
