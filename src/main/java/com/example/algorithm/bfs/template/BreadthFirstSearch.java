package com.example.algorithm.bfs.template;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xxs
 * @create 2022/3/25 22:12
 * 广度优先遍历 模板
 */
public class BreadthFirstSearch {

    private static final ArrayList<ArrayList<Integer>> RES = new ArrayList<>();
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        slove(node);
        System.out.println(RES);
    }

    /**
     * 层序变量 模板
     * @param node
     */
    private static void slove(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node tem = queue.poll();
                assert tem != null;
                list.add(tem.val);
                if (tem.left != null) {
                    queue.add(tem.left);
                }
                if (tem.right != null) {
                    queue.add(tem.right);
                }
            }
            RES.add(list);
        }
    }
}


class Node {
    int val;
    Node left;
    Node right;
    Node(int val) {
        this.val = val;
    }
}