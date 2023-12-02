package helloalgo.queue;

public class ArrayQueue<T> implements Queue<T> {
    private Object[] queue;
    private int front;
    private int queueSize;

    public ArrayQueue(int capacity) {
        queue = new Object[capacity];
    }

    private int capacity() {
        return queue.length;
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
        if (queueSize == capacity()) {
            throw new IndexOutOfBoundsException();
        }
        int tail = (front + queueSize) % capacity();
        queue[tail] = t;
        queueSize++;
    }

    @Override
    public T pop() {
        T peek = peek();
        front = (front + 1) % capacity();
        queueSize--;
        return peek;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return (T)queue[front];
    }
}
