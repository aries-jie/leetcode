package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 回文链表
 * @author xiaojie.huang
 * @since 2023-12-16
 */
public class Solution234 {

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

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp= head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        int i = 0, j = list.size() - 1;
        while (i <= j) {
            if (!Objects.equals(list.get(i), list.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        // 找到后半部分
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
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
        Solution234.ListNode a = new Solution234.ListNode(1);
        Solution234.ListNode b = new Solution234.ListNode(2);
        Solution234.ListNode c = new Solution234.ListNode(1);
        Solution234.ListNode d = new Solution234.ListNode(1);
        a.next = b;
        b.next = c;
//        c.next = d;
        System.out.println(new Solution234().isPalindrome2(a));;
    }

}
