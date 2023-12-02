package helloalgo.deque;

public class TestDeque {
    public static void main(String[] args) {
//        Deque<Integer> deque = new ArrayDeque<>(10);
        Deque<Integer> deque = new LinkedListDeque<>();
        deque.pushFirst(1);
        deque.pushFirst(2);
        deque.pushFirst(3);
        deque.pushLast(4);
        deque.pushLast(5);
        // 3 2 1 4 5

        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());

        System.out.println(deque.popLast());
        System.out.println(deque.popLast());
        System.out.println(deque.popFirst());
        System.out.println(deque.popFirst());
        System.out.println(deque.popFirst());
    }
}
