import java.util.Stack;

public class Reverse_Stack {
    Stack<Integer> stack = new Stack<>();

    void pushStackbottom(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element); //save to bottom;
            return;
        }

        int pop = stack.pop(); //top element
        pushStackbottom(stack, element);
        stack.push(pop); //insert top element

    }

    void reverseStack(int n) {
        if (n == -1) {

            return;
        }
        int element = stack.pop();

        reverseStack(n - 1);
        pushStackbottom(stack, element);
    }

    void display() {
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }
    }

    static void main(String[] args) {
        Reverse_Stack obj = new Reverse_Stack();
        obj.stack.push(1);
        obj.stack.push(2);
        obj.stack.push(3);

        obj.display();
        obj.reverseStack(obj.stack.size() - 1);
        System.out.println("\nAfter reverse");
        obj.display();
    }
}
