package com.example.algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xxs
 * @create 2022/3/26 18:36
 * 二叉树的镜像: 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class MirrorTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        TreeNode res = slove(root);
        System.out.println(res);
    }

    /**
     * 层序遍历
     * @param root
     * @return
     */
    private static TreeNode slove(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tem = queue.poll();
            TreeNode left = tem.left;
            tem.left = tem.right;
            tem.right = left;

            if (tem.left != null) {
                queue.add(tem.left);
            }
            if (tem.right != null) {
                queue.add(tem.right);
            }
        }
        return root;
    }
}
