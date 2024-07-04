package com.example.algorithm.bt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @Author qiaopeng
 * @Date 2024/7/4 13:12
 * 后续遍历
 */
public class BackorderTraversal {

    public static void main(String[] args) {
        System.out.println(backorderTraversal(TreeNodeFactory.createTreeNode()));
        System.out.println(backorderTraversalV2(TreeNodeFactory.createTreeNode()));
    }

    /**
     * 后续遍历
     * 迭代 left right root
     * @param root
     * @return
     */
    public static List<Integer> backorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return res;
        stack.push(root);

        while (!stack.empty()) {
            TreeNode curNode = stack.pop();;
            res.add(curNode.val);
            if (curNode.right != null) stack.push(curNode.right);
            if (curNode.left != null) stack.push(curNode.left);
        }
        Collections.reverse(res);
        return res;
    }


    /**
     * 递归
     * @param treeNode
     * @return
     */
    public static List<Integer> backorderTraversalV2(TreeNode treeNode) {
        List<Integer> res = new ArrayList<>();
        backOrder(res, treeNode);
        return res;
    }


    /**
     * 后序遍历
     * @param res
     * @param treeNode
     */
    private static void backOrder(List<Integer> res, TreeNode treeNode) {
        // 边界
        if (treeNode == null) return;
        backOrder(res, treeNode.left);
        backOrder(res, treeNode.right);
        res.add(treeNode.val);
    }

}
