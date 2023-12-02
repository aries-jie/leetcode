package helloalgo.deque;

public interface Deque<T> {

    int size();

    boolean isEmpty();

    void pushFirst(T t);

    void pushLast(T t);

    T popFirst();

    T popLast();

    T peekFirst();

    T peekLast();
}
