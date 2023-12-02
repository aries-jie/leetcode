package helloalgo.stack;

import java.util.ArrayList;

public class ArrayStack<T> implements Stack<T> {

    private final ArrayList<T> stack;

    public ArrayStack() {
        stack = new ArrayList<>();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public boolean isEmpty() {
        return stack.size() == 0;
    }

    @Override
    public void push(T o) {
        stack.add(o);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return stack.remove(size() - 1);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return stack.get(size() - 1);
    }

    @Override
    public T[] toArray() {
        return null;
    }
}
