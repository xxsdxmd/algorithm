package com.example.algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xxs
 * @create 2022/3/26 16:57
 * 二叉树的深度
 * 链接: https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 */
public class MaxDepth {
    public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      int cnt = slove(root);
      System.out.println(cnt);
    }

    /**
     * 二叉树的深度 bfs
     * @param root
     * @return
     */
    private static int slove(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
