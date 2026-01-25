import java.util.ArrayList;

public class Stack_ArrayList {
    ArrayList<Integer> list = new ArrayList<>();

    void push(int data) {
        list.addLast(data);
    }

    int pop() {
        if (list.isEmpty()) {
            System.out.println("Stack list is underflow");
            return -1;
        }
        int popitem = list.getLast();
        list.removeLast();
        return popitem;
    }

    void isPeak() {
        if (!list.isEmpty()) {
            System.out.println("Peak item = " + list.getLast());
            return;
        }
        System.out.println("peak item null");
    }

    void display() {
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
    }

    static void main(String[] args) {
        Stack_ArrayList stack = new Stack_ArrayList();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.display();
        System.out.println("pop item = " + stack.pop());
        System.out.println("pop item = " + stack.pop());
        System.out.println("Is empty = " + stack.list.isEmpty());
        stack.display();
        stack.isPeak();
    }
}
