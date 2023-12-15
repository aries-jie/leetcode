package org.example;


/**
 * 反转链表
 * @author xiaojie.huang
 * @since 2023-12-15
 */
public class Solution206 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        fds(head, head.next);
        head.next = null;
        return temp;
    }

    public void fds(ListNode pre, ListNode next) {
        if (next != null) {
            fds(next, next.next);
            next.next = pre;
        }
    }


    /**
     * 官方题解
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        return reverse(null, head);
    }
    ListNode reverse(ListNode pre, ListNode cur){
        if(cur == null){
            return pre;
        }
        ListNode temp = cur.next;
        cur.next = pre;

        return reverse(cur, temp);
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        ListNode listNode = new Solution206().reverseList2(a);
    }

}
