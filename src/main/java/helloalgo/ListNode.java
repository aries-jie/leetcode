package helloalgo;

public class ListNode<T> {
    public T val;

    public ListNode<T> next;

    public ListNode<T> prev;

    public ListNode(T val) {
        this.val = val;
    }
}
