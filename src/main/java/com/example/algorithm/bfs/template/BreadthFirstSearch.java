package com.example.algorithm.bfs.template;

import com.example.algorithm.bfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xxs
 * @create 2022/3/25 22:12
 * 广度优先遍历 模板
 */
public class BreadthFirstSearch {

    private static final ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        slove(node);
        System.out.println(res);
    }

    /**
     * 层序变量 模板
     * @param node
     */
    private static void slove(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tem = queue.poll();
                assert tem != null;
                list.add(tem.val);
                if (tem.left != null) {
                    queue.add(tem.left);
                }
                if (tem.right != null) {
                    queue.add(tem.right);
                }
            }
            res.add(list);
        }
    }
}
