package helloalgo.stack;

class StackNode<T> {
    public T val;
    public StackNode<T> next;

    public StackNode(T val) {
        this.val = val;
    }
}
