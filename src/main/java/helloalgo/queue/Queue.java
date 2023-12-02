package helloalgo.queue;

public interface Queue<T> {

    int size();

    boolean isEmpty();

    void push(T t);

    T pop();

    T peek();

}
