import java.util.Stack;

public class NextGreaterElement {
    Stack<Integer> stack = new Stack<>();
    int[] arr = {6, 8, 0, 1, 3};
    int[] nextGreater = new int[arr.length];

    void findNxtGtr() {
        stack.push(arr.length - 1);
        for (int i = arr.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[stack.peek()];
            }
            stack.push(i);

        }
    }

    static void main(String[] args) {
        System.out.println("Next Greater Element");
        NextGreaterElement nGE = new NextGreaterElement();
        nGE.findNxtGtr();
        for (int i = 0; i < nGE.nextGreater.length; i++) {
            System.out.print(nGE.nextGreater[i] + " ");
        }
    }
}
