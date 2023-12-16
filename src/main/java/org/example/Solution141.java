package org.example;


import java.util.*;

/**
 * 环形链表
 * @author xiaojie.huang
 * @since 2023-12-16
 */
public class Solution141 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int x) {
            val = x;
            next = null;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            if (set.contains(temp)) {
                return true;
            }
            set.add(temp);
            temp = temp.next;
        }
        return false;
    }

    /**
     * 快慢指针
     */
    public boolean hasCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Solution141.ListNode a = new Solution141.ListNode(1);
        Solution141.ListNode b = new Solution141.ListNode(2);
        Solution141.ListNode c = new Solution141.ListNode(1);
        Solution141.ListNode d = new Solution141.ListNode(1);
        a.next = b;
        b.next = c;
//        c.next = d;
        System.out.println(new Solution141().hasCycle2(a));;
    }

}
