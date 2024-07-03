package com.example.algorithm.bt;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xxs
 * @Date 2024/7/3 22:37
 */
public class InorderTraversal {


    public static void main(String[] args) {
        List<Integer> traversal = inorderTraversal(TreeNodeFactory.createTreeNode());
        List<Integer> traversalV2 = inorderTraversalV2(TreeNodeFactory.createTreeNode());
        System.out.println(traversal);
        System.out.println(traversalV2);
    }

    /**
     * 中序遍历  left  root right
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return res;
        TreeNode cur = root;

        while (!stack.empty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (cur == null) {
                cur = stack.peek();
                stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }

    /**
     * 递归
     * left root right
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversalV2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(res, root);
        return res;
    }

    /**
     * 递归
     * @param res
     * @param root
     */
    private static void inOrder(List<Integer> res, TreeNode root) {
        if (root == null) return;
        inOrder(res, root.left);
        res.add(root.val);
        inOrder(res, root.right);
    }

}
