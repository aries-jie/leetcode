package helloalgo.queue;

import helloalgo.ListNode;

public class LinkedListQueue<T> implements Queue<T> {
    private ListNode<T> head;
    private ListNode<T> tail;
    private int queueSize;

    public LinkedListQueue() {
        head = null;
        tail = null;
    }

    @Override
    public int size() {
        return queueSize;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void push(T t) {
        ListNode<T> node = new ListNode<>(t);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        queueSize++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        T val = peek();
        head = head.next;
        queueSize--;
        return val;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return head.val;
    }
}
