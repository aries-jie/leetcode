package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * K 个一组翻转链表
 *
 * @author xiaojie.huang
 * @date 2024-01-22
 */
public class Solution25 {
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



    public ListNode reverseKGroup(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>(k);
        ListNode dummy = new ListNode();
        flip(dummy, head, k, list);
        return dummy.next;
    }

    private void flip(ListNode parent, ListNode head, int k, List<ListNode> list) {
        if (head == null) {
            return;
        }

        // 找到这次需要翻转的最后一个节点
        getNextNodes(head, k, list);
        if (list.size() == k) {
            // 记录下一次需要循环的节点
            ListNode nextHead = list.get(k - 1).next;

            for (int i = k - 1; i >= 0; i--) {
                parent.next = list.get(i);
                parent = parent.next;
                parent.next = null;
            }

            list.clear();
            flip(parent, nextHead, k, list);
        } else {
            for (int i = 0; i < list.size(); i++) {
                parent.next = list.get(i);
                parent = parent.next;
            }
        }
    }

    private void getNextNodes(ListNode head, int k, List<ListNode> list) {
        ListNode temp = head;
        for (int i = 0; i < k; i++) {
            if (temp == null) {
                break;
            }
            list.add(temp);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        ListNode x = new Solution25().reverseKGroup(a1, 3);
        while (x != null) {
            System.out.println(x.val);
            x = x.next;
        }
    }

}
