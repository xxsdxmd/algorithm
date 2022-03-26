package com.example.algorithm.bfs;

import java.util.*;

/**
 * @author xxs
 * @create 2022/3/26 17:43
 */
public class LevelOrder {
    private static final List<ArrayList<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        slove(root);
        System.out.println(res);
    }

    /**
     * 层序遍历二叉树二  bfs
     * @param root
     */
    private static void slove(TreeNode root) {
            if (root == null) return;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int level = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode tem = queue.poll();
                    list.add(tem.val);
                    if (tem.left != null) {
                        queue.add(tem.left);
                    }
                    if (tem.right != null) {
                        queue.add(tem.right);
                    }
                }
                if (level % 2 == 0) {
                    Collections.reverse(list);
                }
                level++;
                res.add(list);
            }
    }
}
