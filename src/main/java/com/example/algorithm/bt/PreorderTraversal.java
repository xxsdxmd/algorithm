package com.example.algorithm.bt;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xxs
 * @Date 2024/7/3 22:27
 *  前序遍历
 */
public class PreorderTraversal {

    public static void main(String[] args) {
        List<Integer> traversal = preorderTraversal(TreeNodeFactory.createTreeNode());
        List<Integer> traversalV2 = preorderTraversalV2(TreeNodeFactory.createTreeNode());
        System.out.println(traversal);
        System.out.println(traversalV2);

    }

    /**
     * 前序遍历 root left right
     * 迭代
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return res;
        stack.push(root);

        while (!stack.empty()) {
            TreeNode curNode = stack.pop();
            res.add(curNode.val);
            // 因为是先进后出 所以先让右节点进去
            if (root.right != null) stack.push(root.right);
            if (root.left != null) stack.push(root.left);
        }
        return res;
    }


    /**
     * 递归
     * root left right
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversalV2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(res, root);
        return res;
    }

    /**
     * 递归
     * @param res
     * @param root
     * @return
     */
    private static void preOrder(List<Integer> res, TreeNode root) {
        // 终止条件
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrder(res, root.left);
        preOrder(res, root.right);
    }


}
