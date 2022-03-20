package com.example.algorithm.sort;

/**
 * @author xxs
 * @create 2022/3/20 19:33
 * 链接 https://leetcode-cn.com/problems/sort-list/
 */
public class SortList {
    public static void main(String[] args) {
       ListNode head = new ListNode(-1);
       sortList(head);
    }

    /**
     * 单链表排序 时间复杂度 O(n log n)
     * @param head
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = findMid(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return merge(left,right);
    }

    private static ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode dum = new ListNode(-1);
        ListNode cur = dum;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = new ListNode(left.val);
                left = left.next;
            }else {
                cur.next = new ListNode(right.val);
                right = right.next;
            }
            cur = cur.next;
        }
        if (left != null) cur.next = left;
        if (right != null) cur.next = right;
        return dum.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
