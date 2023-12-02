package helloalgo.deque;

public class ArrayDeque<T> implements Deque<T> {
    private Object[] deque;
    private int front;
    private int dequeSize;

    public ArrayDeque(int capacity) {
        deque = new Object[capacity];
        front = 0;
        dequeSize = 0;
    }

    private int getCapacity() {
        return deque.length;
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

    private int getIndex(int index) {
        return (index + getCapacity()) % getCapacity();
    }

    private void push(T t, boolean first) {
        if (dequeSize == getCapacity()) {
            throw new IndexOutOfBoundsException();
        }
        if (first) {
            deque[getIndex(front - 1)] = t;
            front = getIndex(front - 1);
        } else {
            deque[getIndex(front + dequeSize)] = t;
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
            front = getIndex(front + 1);
        } else {
            t = peekLast();
        }
        dequeSize--;
        return t;
    }

    @Override
    public T peekFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return (T)deque[front];
    }

    @Override
    public T peekLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return (T)deque[getIndex(front + dequeSize - 1)];
    }
}
