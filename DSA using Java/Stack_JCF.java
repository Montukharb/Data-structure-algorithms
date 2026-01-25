import java.util.Stack;

public class Stack_JCF {


    static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }
        System.out.println("pop item = " + stack.pop());
        System.out.println("peek item = " + stack.peek());
    }
}
