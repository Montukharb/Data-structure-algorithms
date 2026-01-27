import java.util.Queue;
import java.util.Stack;

public class Queue_using_Two_stack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void quePush(int data) {
        if (s1.isEmpty()) {
            s1.push(data);
        } else {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);
            if (!s2.isEmpty()) {
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
            }
        }
    }

    void display() {
        if (s1.isEmpty()) {
            System.out.println("no more data");
            return;
        }

        for (int i = s1.size() - 1; i >= 0; i--) {
            System.out.print(s1.get(i) + " ");
        }
    }

    int remove() {
        if (s1.isEmpty()) {
            System.out.println("stack empty");
            return -1;
        }
        return s1.pop();
    }

    static void main(String[] args) {
        Queue_using_Two_stack que = new Queue_using_Two_stack();
        que.quePush(1);
        que.quePush(2);
        que.quePush(3);
        que.quePush(4);

        que.display();

        System.out.println("\npop item = " + que.remove());
        que.display();

    }
}
