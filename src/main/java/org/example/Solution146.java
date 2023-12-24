package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU 缓存
 * @author xiaojie.huang
 * @since 2023-12-24
 */
public class Solution146 {

    static class Node {
        int key;
        int val;
        Node pre;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    static class LRUCache {

        // 最近访问的节点
        Node head;
        // 最后访问的节点
        Node tail;

        final Map<Integer, Node> cacheMap;
        final int capacity;

        public LRUCache(int capacity) {
            this.cacheMap = new HashMap<>(capacity);
            this.capacity = capacity;
        }

        public int get(int key) {
            int val;
            if (cacheMap.containsKey(key)) {
                Node node = cacheMap.get(key);
                if (node != head) {
                    unlink(node);
                    addHead(node);
                }
                val = node.val;
            } else {
                val = -1;
            }
            System.out.println(val);
            return val;
        }

        public void put(int key, int value) {
            if (cacheMap.containsKey(key)) {
                // 节点已存在，则把节点放到 head
                Node node = cacheMap.get(key);
                node.val = value;

                // 把 node 放到头部
                if (node != head) {
                    unlink(node);
                    addHead(node);
                }
            } else {
                Node node = new Node(key, value);

                addHead(node);
                cacheMap.put(key, node);

                // 如果已经超出了，则需要把为尾节点删除
                if (cacheMap.size() > capacity) {
                    cacheMap.remove(tail.key);
                    unlink(tail);
                }
            }
        }

        private void unlink(Node node) {
            Node pre = node.pre;
            Node next = node.next;
            if (pre != null) {
                pre.next = next;
            } else {
                head = next;
            }
            if (next != null) {
                next.pre = pre;
            } else {
                tail = pre;
            }
        }

        private void addHead(Node node) {
            if (head != null) {
                node.next = head;
                head.pre = node;
            }
            head = node;
            if (tail == null) {
                tail = node;
            }
        }
    }


    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
//        lRUCache.put(1, 0); // 缓存是 {1=1}
//        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//        lRUCache.get(1);    // 返回 1
//        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//        lRUCache.get(2);    // 返回 -1 (未找到)
//        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//        lRUCache.get(1);    // 返回 -1 (未找到)
//        lRUCache.get(3);    // 返回 3
//        lRUCache.get(4);    // 返回 4

        lRUCache.put(2, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(2);    // 返回 1
        lRUCache.put(1, 1); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.put(4, 1); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
    }

}
