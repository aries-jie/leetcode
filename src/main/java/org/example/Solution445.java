package org.example;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 两数相加 II
 *
 * @author xiaojie.huang
 * @date 2024-01-20
 */
public class Solution445 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> queue1 = new LinkedList<>();
        Deque<ListNode> queue2 = new LinkedList<>();
        ListNode temp = l1;
        while (temp != null) {
            queue1.offer(temp);
            temp = temp.next;
        }
        temp = l2;
        while (temp != null) {
            queue2.offer(temp);
            temp = temp.next;
        }

        ListNode lastNode = new ListNode(0);
        int max = Math.max(queue1.size(), queue2.size());
        for (int i = 0; i < max; i++) {
            ListNode node1 = queue1.pollLast();
            ListNode node2 = queue2.pollLast();
            lastNode.val += (node1 != null ? node1.val : 0) + (node2 != null ? node2.val : 0);
            int add = 0;
            if (lastNode.val > 9) {
                add = 1;
                lastNode.val -= 10;
            }
            ListNode preNode = new ListNode(add);
            preNode.next = lastNode;
            lastNode = preNode;
        }

        if (lastNode.val == 0 && lastNode.next != null) {
            return lastNode.next;
        }
        return lastNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode res = new Solution445().addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

}
