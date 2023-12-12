package org.example;


/**
 * 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * @author xiaojie.huang
 * @since 2023-12-12
 */
public class Solution155 {

    static class Node {
        int val;
        int min;
        Node next;
        Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    static class MinStack {

        Node head;

        public MinStack() {

        }

        public void push(int val) {
            Node node = new Node(val, val, null);
            if (head == null) {
                head = node;
            } else {
                node.next = head;
                node.min = Math.min(head.min, node.min);
                head = node;
            }
        }

        public void pop() {
            if (head != null) {
                Node next = head.next;
                head.next = null;
                head = next;
            }
        }

        public int top() {
            if (head != null) {
                return head.val;
            }
            return -1;
        }

        public int getMin() {
            if (head != null) {
                return head.min;
            }
            return -1;
        }
    }
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */

    public static void main(String[] args) {

        MinStack obj = new MinStack();
        obj.push(1);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
    }

}
