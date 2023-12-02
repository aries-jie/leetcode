package helloalgo.stack;

public class TestStack {
    public static void main(String[] args) {
//        Stack<Integer> stack = new ArrayStack<>();
        Stack<Integer> stack = new LinkedListStack<>();
        stack.push(1);
        stack.push(3);
        stack.push(2);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
