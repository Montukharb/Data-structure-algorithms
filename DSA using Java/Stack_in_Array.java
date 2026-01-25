import java.util.Scanner;

public class Stack_in_Array {

    int top;
    int maxSize;
    int[] arr;

    private Stack_in_Array(int size) {
        arr = new int[size];
        maxSize = size;
        top = -1;
    }


    void push(int data) {
        if (top == maxSize - 1) {
            System.out.println("Stack is full");
            return;
        } else {
            top++;
            arr[top] = data;
        }
    }

    int pop() {
        int popItem = -1;

        if (!isEmpty()) {
            popItem = arr[top];
            top--;
        }

        return popItem;
    }

    int isPeak() {
        return arr[top];
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        System.out.println("stack overflow");
        return top == maxSize - 1;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Stack is underflow");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.println(arr[i]);
            }
        }
    }

    static void main(String[] args) {
        System.out.println("Stack using arrays");

        Stack_in_Array stack = new Stack_in_Array(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);

        stack.display();
        System.out.println("Stack peak element = " + stack.isPeak());
        System.out.println("Pop item = " + stack.pop());
        stack.display();
        System.out.println("Is empty = " + stack.isEmpty());
        System.out.println(stack.isFull());
    }
}
