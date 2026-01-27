public class Queue_using_Array {
    int[] queue;
    int rear;
    int front;

    private Queue_using_Array(int size) {
        queue = new int[size];
        rear = -1;
    }

    boolean isEmpty() {
        return rear == -1;
    }

    boolean isFull() {
        return rear == queue.length - 1;
    }

    void enque(int data) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        } else if (rear == -1) {
            front = 0;
            rear = 0;
            queue[rear] = data;
            return;
        }
        rear++;
        queue[rear] = data;
    }

    int deque() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int item = queue[front];
        rear--;
        for (int i = 0; i <= rear; i++) {
            queue[i] = queue[i + 1];
        }
        return item;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty no more data");
            return;
        }
        for (int i = 0; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
    }

    static void main(String[] args) {
        System.out.println("Queue using array");
        Queue_using_Array q = new Queue_using_Array(5);
        q.enque(1);
        q.enque(2);
        q.enque(3);
        q.enque(4);
        q.enque(5);
        q.display();
        System.out.println();
        System.out.println("Deleted item = " + q.deque());
        System.out.println("Deleted item = " + q.deque());
        System.out.println("Deleted item = " + q.deque());
        q.display();
    }

}
