package helloalgo.queue;

public class TestQueue {
    public static void main(String[] args) {
//        Queue<Integer> queue = new LinkedListQueue<>();
        Queue<Integer> queue = new ArrayQueue<>(10);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(4);
        queue.push(5);
        System.out.println(queue.pop());
    }
}
