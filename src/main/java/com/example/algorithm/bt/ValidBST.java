package com.example.algorithm.bt;

import java.util.*;

/**
 * @Author qiaopeng
 * @Date 2024/7/5 23:51
 */
public class ValidBST {
    public static void main(String[] args) {
        System.out.println(isValidBST(TreeNodeFactory.createTreeNode()));
        System.out.println(isValidBSTV2(TreeNodeFactory.createTreeNode()));
    }

    public static boolean isValidBST(TreeNode root) {
        // level order
        return judgeSortList(levelOrder(root));
    }

    /**
     * judge的正确姿势 别用两个指针了
     * @param levelOrderList
     * @return
     */
    static boolean judgeSortList(List<Integer> levelOrderList) {
        for (int i = 0; i < levelOrderList.size() - 1; i++) {
            if (levelOrderList.get(i) >= levelOrderList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    static List<Integer> levelOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tem = root;
        while (!stack.empty() || tem != null) {
            if (tem != null) {
                stack.push(tem);
                tem = tem.left;
            }
            if (tem == null) {
                tem = stack.peek();
                stack.pop();
                res.add(tem.val);
                tem = tem.right;
            }
        }
        return res;
    }


    private static Long PRE = Long.MIN_VALUE;
    /**
     * 递归
     * @param root
     * @return
     */
    private static boolean isValidBSTV2(TreeNode root) {
        // 边界
        if (root == null) return true;
        if (!isValidBST(root) || root.val <= PRE) {
            return false;
        }
        PRE = (long) root.val;
        return isValidBST(root.right);
    }
}
