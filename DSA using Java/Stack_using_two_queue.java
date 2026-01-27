import java.util.LinkedList;
import java.util.Queue;

public class Stack_using_two_queue {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    boolean isEmpty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    void stackPush(int data) {
        if (!q1.isEmpty()) {
            q1.add(data);
        } else {
            q2.add(data);
        }
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int top = -1;
        if (!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                top = q1.remove();
                if (q1.isEmpty()) {
                    break;
                }
                q2.add(top);
            }
        } else {
            while (!q2.isEmpty()) {
                top = q2.remove();
                if (q2.isEmpty()) {
                    break;
                }
                q1.add(top);
            }
        }
        return top;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Stack queue is empty ");
            return;
        }
        if (!q1.isEmpty()) {
            System.out.print("Stack: ");
            for (int x : q1) {
                System.out.print(x + " ");
            }
        } else {
            System.out.print("Stack: ");
            for (int x : q2) {
                System.out.print(x + " ");
            }
        }
    }

    static void main(String[] args) {
        Stack_using_two_queue st = new Stack_using_two_queue();
        st.stackPush(1);
        st.stackPush(2);
        st.stackPush(3);
        st.stackPush(4);
        st.stackPush(5);

        System.out.println("pop item = " + st.pop());
        System.out.println("pop item = " + st.pop());
        st.display();
    }
}
