package org.example;


import java.util.*;

/**
 * 环形链表 II
 * @author xiaojie.huang
 * @since 2023-12-17
 */
public class Solution142 {

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

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            }
            set.add(temp);
            temp = temp.next;
        }
        return null;
    }

    /**
     * 假设快指针走了 f 步，慢指针走了 s 步，则： f = 2s
     * 假设走到环形入口有 a 个节点，环形有 b 个节点，f 比 s 多走了 n 圈，则： f = s + nb
     * 由 f = 2s 和 f = s + nb 推导出 s = nb
     * 假设走到入口需要 k 步，可以推导出 k = a + nb；
     * 至此可以推导出 a 想要走到入口，只需要再走 a 步即可；
     * 而如果 f 此时从起点走 a 步，也一定会到达入口处，至此一定会相遇，也就可以找到入口
     *
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        Solution142.ListNode a = new Solution142.ListNode(1);
        Solution142.ListNode b = new Solution142.ListNode(2);
        Solution142.ListNode c = new Solution142.ListNode(1);
        Solution142.ListNode d = new Solution142.ListNode(1);
        a.next = b;
        b.next = c;
//        c.next = d;
        System.out.println(new Solution142().detectCycle(a));
    }

}
