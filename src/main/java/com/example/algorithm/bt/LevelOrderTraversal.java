package com.example.algorithm.bt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author qiaopeng
 * @Date 2024/7/4 13:34
 * 层序遍历
 */
public class LevelOrderTraversal {

    public static void main(String[] args) {
        System.out.println(levelOrderTraversal(TreeNodeFactory.createTreeNode()));
        System.out.println(levelOrderTraversalV2(TreeNodeFactory.createTreeNode()));
    }

    /**
     * 层序遍历
     * level1 -> level2 -> level3
     * 借助队列
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelItemList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode == null) break;
                levelItemList.add(curNode.val);
                if (curNode.left != null) queue.add(curNode.left);
                if (curNode.right != null) queue.add(curNode.right);
            }
            res.add(levelItemList);
        }
        return res;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderTraversalV2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrder(res, root, 0);
        return res;
    }


    /**
     * 层序遍历
     * @param
     * @param root
     */
    private static void levelOrder(List<List<Integer>> res, TreeNode root, Integer deep) {
        // 边界
        if (root == null) return;
        deep++;
        if (res.size() < deep) {
            List<Integer> levelItem = new ArrayList<>();
            res.add(levelItem);
        }
        res.get(deep - 1).add(root.val);
        levelOrder(res,root.left, deep);
        levelOrder(res, root.right, deep);
    }

}
