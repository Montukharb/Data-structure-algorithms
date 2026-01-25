import java.util.Stack;

public class Stack_push_bottom {
    Stack<Integer> stack = new Stack<>();
    ;

    void pushBottom(int data, int n) {
        if (n == -1) {
            stack.push(data);
            return;
        }
        int pop = stack.pop();
        pushBottom(data, n - 1);
        stack.push(pop);
    }

    void display() {
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }
    }

    static void main(String[] args) {
        Stack_push_bottom obj = new Stack_push_bottom();
        obj.stack.push(1);
        obj.stack.push(2);
        obj.stack.push(3);

//        obj.display();
        obj.pushBottom(4, obj.stack.size() - 1);
        obj.display();
    }
}
