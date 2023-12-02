package helloalgo.stack;

/**
 * 基于链表实现的栈
 */
public class LinkedListStack<T> implements Stack<T> {

    private StackNode<T> stack;

    private int stackSize;

    public LinkedListStack() {
        stack = null;
    }

    @Override
    public int size() {
        return stackSize;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void push(T t) {
        StackNode<T> node = new StackNode<>(t);
        node.next = stack;
        stack = node;
        stackSize++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        T val = peek();
        stack = stack.next;
        stackSize--;
        return val;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return stack.val;
    }

    @Override
    public T[] toArray() {
        return null;
    }
}

