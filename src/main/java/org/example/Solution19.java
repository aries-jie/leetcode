package org.example;


import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 删除链表的倒数第 N 个节点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @author xiaojie.huang
 * @date 2023-11-03
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> numForNodeMap = new HashMap<>();

        ListNode node = head;
        int nodeNum = 0;
        while (node != null) {
            ++nodeNum;
            numForNodeMap.put(nodeNum, node);
            node = node.next;
        }

        ListNode delNode = numForNodeMap.get(nodeNum - n + 1);
        ListNode preNode = numForNodeMap.get(nodeNum - n);
        if (preNode != null) {
            preNode.next = delNode.next;
            return head;
        } else {
            return delNode.next;
        }
    }

    /**
     * 栈的解法
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public class ListNode {
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
