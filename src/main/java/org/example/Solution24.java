package org.example;


/**
 * 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * @author xiaojie.huang
 * @date 2023-12-18
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        swap(dummy, head);
        return dummy.next;
    }

    public void swap(ListNode parent, ListNode next) {
        if (next != null && next.next != null) {
            ListNode b = next.next;
            ListNode c = next.next.next;

            parent.next = b;
            b.next = next;
            next.next = c;

            swap(next, c);
        }

    }

    public static void main(String[] args) {
        Solution24.ListNode a = new Solution24.ListNode(1);
        Solution24.ListNode b = new Solution24.ListNode(2);
        Solution24.ListNode c = new Solution24.ListNode(3);
        Solution24.ListNode d = new Solution24.ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        System.out.println(new Solution24().swapPairs(a));;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
