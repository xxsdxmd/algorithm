package com.example.algorithm.bt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author qiaopeng
 * @Date 2024/7/4 23:10
 * 翻转二叉树
 */
public class InvertTree {

    public static void main(String[] args) {
        System.out.println(invertTreeStack(TreeNodeFactory.createTreeNode()));
        System.out.println(dfs(TreeNodeFactory.createTreeNode()));
    }

    /**
     * 翻转二叉树 stack
     * @param root
     * @return
     */
    public static TreeNode invertTreeStack(TreeNode root) {
        return invert(root);
    }

    private static TreeNode invert(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode curNode = stack.pop();
            if (curNode.left != null) stack.push(curNode.left);
            if (curNode.right != null) stack.push(curNode.right);
            TreeNode tem = curNode.left;
            curNode.left = curNode.right;
            curNode.right = tem;
        }
        return root;
    }


    public static TreeNode dfs(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        root.left = dfs(root.right);
        root.right = dfs(left);
        return root;
    }


    /**
     * 队列实现
     * @param root
     * @return
     */
    private TreeNode invertQueue(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode == null) break;
                if (curNode.right != null) queue.add(curNode.right);
                if (curNode.left != null) queue.add(curNode.left);
                TreeNode tem = curNode.left;
                curNode.left = curNode.right;
                curNode.right = tem;
            }
        }
        return root;
    }
}
