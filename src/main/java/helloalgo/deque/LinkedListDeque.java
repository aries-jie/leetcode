package helloalgo.deque;

import helloalgo.ListNode;

public class LinkedListDeque<T> implements Deque<T> {
    private ListNode<T> head;
    private ListNode<T> tail;
    private int dequeSize;

    public LinkedListDeque() {
        head = tail = null;
        dequeSize = 0;
    }

    @Override
    public int size() {
        return dequeSize;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void pushFirst(T t) {
        push(t, true);
    }

    @Override
    public void pushLast(T t) {
        push(t, false);
    }

    private void push(T t, boolean first) {
        ListNode<T> node = new ListNode<>(t);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            if (first) {
                head.prev = node;
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
        }
        dequeSize++;
    }

    @Override
    public T popFirst() {
        return pop(true);
    }

    @Override
    public T popLast() {
        return pop(false);
    }

    private T pop(boolean first) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        T t;
        if (first) {
            t = peekFirst();

            ListNode<T> next = head.next;
            if (next != null) {
                head.next = null;
                next.prev = null;
            }

            head = next;
        } else {
            t = peekLast();

            ListNode<T> prev = tail.prev;
            if (prev != null) {
                tail.prev = null;
                prev.next = null;
            }

            tail = prev;
        }
        dequeSize--;
        return t;
    }

    @Override
    public T peekFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return head.val;
    }

    @Override
    public T peekLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return tail.val;
    }
}
