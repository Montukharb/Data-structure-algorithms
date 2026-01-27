public class Circular_Queue_Array {
    int[] queue;
    int rear;
    int front;

    private Circular_Queue_Array(int size) {
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    boolean isFull() {
        return (rear + 1) % queue.length == front;
    }

    void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = data;
    }

    int deque() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int res = queue[front];
        if (front == rear) {
            front = rear = -1; //last item;
        } else {
            front = (front + 1) % queue.length;
        }
        return res;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) {
                break;
            }
            i = (i + 1) % queue.length;
        }
    }

    static void main(String[] args) {
        System.out.println("Circular Queue using array");
        Circular_Queue_Array cQ = new Circular_Queue_Array(5);
        cQ.enqueue(1);
        cQ.enqueue(2);
        cQ.enqueue(3);
        cQ.enqueue(4);
        cQ.enqueue(5);
        System.out.println("Deleted item = " + cQ.deque());
        System.out.println("Deleted item = " + cQ.deque());
        System.out.println("Deleted item = " + cQ.deque());
        System.out.println("Deleted item = " + cQ.deque());
        cQ.enqueue(6);
        cQ.enqueue(7);
        cQ.enqueue(8);
        cQ.enqueue(9);

//        cQ.enqueue(10);  //queue full;

        cQ.display();
    }
}
