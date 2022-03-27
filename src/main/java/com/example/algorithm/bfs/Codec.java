package com.example.algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xxs
 * @create 2022/3/27 07:43
 * 序列化二叉树
 * 链接: https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
 */
public class Codec {

    /**
     * 序列化
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }else {
                sb.append("null");
            }
            sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 反序列化
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        String[] dataList = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(dataList[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"null".equals(dataList[i])) {
                node.left = new TreeNode(Integer.parseInt(dataList[i]));
                queue.add(node.left);
            }
            i++;
            if (!"null".equals(dataList[i])) {
                node.right = new TreeNode(Integer.parseInt(dataList[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}