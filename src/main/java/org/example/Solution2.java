package org.example;

/**
 * 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * @author xiaojie.huang
 * @date 2023-10-29
 */
public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        add(l1, l2, ans);
        return ans;
    }

    public void add(ListNode l1, ListNode l2, ListNode ans) {
        if (l1 == l2 && l1 == null) {
            return;
        }
        ListNode next1 = null;
        ListNode next2 = null;
        ListNode nextAns = null;
        if (l1 != null) {
            ans.val += l1.val;
            next1 = l1.next;
        }
        if (l2 != null) {
            ans.val += l2.val;
            next2 = l2.next;
        }
        if (ans.val > 9) {
            nextAns = new ListNode(1);
            ans.val %= 10;
        } else {
            nextAns = new ListNode(0);
        }
        if (next1 == null && next2 == null) {
            if (nextAns.val > 0) {
                ans.next = nextAns;
            }
        } else {
            ans.next = nextAns;
            add(next1, next2, nextAns);
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
