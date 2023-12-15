package org.example;


/**
 * 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * @author xiaojie.huang
 * @since 2023-12-15
 */
public class Solution160 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 暴力解法
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node = headA;
        while (node != null) {
            ListNode compareNode = headB;
            while (compareNode != null) {
                if (node.equals(compareNode)) {
                    return node;
                }
                compareNode = compareNode.next;
            }

            node = node.next;
        }
        return null;
    }

    /**
     * 官方题解，两个链表分别拼接后进行 m+n 次循环即可得到答案
     * 例如 headA = 1 5 9 7
     *     headB = 3 6 8 7
     *     headA + headB 和 headB + headA 进行对比
     *     1 5 9 7 3 6 8 7
     *     3 6 8 7 1 5 9 7
     *                   7 = 最终返回
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}
