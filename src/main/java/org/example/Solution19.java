package org.example;


import java.util.HashMap;
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
        int nodeNum = 1;
        numForNodeMap.put(nodeNum, node);
        while (node.next != null) {
            ++nodeNum;
            node = node.next;
            numForNodeMap.put(nodeNum, node);
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
