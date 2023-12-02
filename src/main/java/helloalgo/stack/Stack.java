package helloalgo.stack;

public interface Stack<T> {

    int size();

    boolean isEmpty();

    void push(T t);

    T pop();

    T peek();

    T[] toArray();
}
