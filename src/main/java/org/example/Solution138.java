package org.example;


import java.util.HashMap;
import java.util.Map;

/**
 * 随机链表的复制
 * @author xiaojie.huang
 * @since 2023-12-21
 */
public class Solution138 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        // 先复制所有的节点，保存关系
        Node temp = head;
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        // 再变更复制节点的关系
        temp = head;
        while (temp != null) {
            Node copyNode = map.get(temp);
            copyNode.next = map.get(temp.next);
            copyNode.random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }

    public static void main(String[] args) {
    }

}
