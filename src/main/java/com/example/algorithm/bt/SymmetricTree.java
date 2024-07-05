package com.example.algorithm.bt;

import java.util.*;

/**
 * @Author qiaopeng
 * @Date 2024/7/5 21:54
 * 对称二叉树
 */
public class SymmetricTree {

    public static void main(String[] args) {
        System.out.println(isSymmetric(TreeNodeFactory.createTreeNode()));
        System.out.println(isSymmetricV2(TreeNodeFactory.createTreeNode()));
    }


    /**
     * 迭代
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelItemList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                Integer curVal = curNode == null ? 101 : curNode.val;
                levelItemList.add(curVal);
                if (curNode == null)
                    continue;
                queue.add(curNode.left);
                queue.add(curNode.right);
            }
            if (!judgeSymmetric(levelItemList)) {
                return false;
            }
        }
        return true;
    }

    private static boolean judgeSymmetric(List<Integer> levelItemList) {
        int i = 0, j = levelItemList.size() - 1;
        while (i <= j) {
            if (!Objects.equals(levelItemList.get(i), levelItemList.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public static boolean isSymmetricV2(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }

    /**
     * recu
     * @param l
     * @param r
     * @return
     */
    static boolean recur(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null || l.val != r.val) return false;
        return recur(l.left, r.right) &&  recur(l.right, r.left);
    }

}
