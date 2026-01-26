import java.util.Stack;

public class Stock_Span {
    int[] stock = {100, 70, 80, 65, 55, 90, 100};
    int[] span = new int[stock.length];

    void stockSpan() {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        span[0] = 1;
        for (int i = 1; i < stock.length; i++) {
            int current = stock[i];
            while (!stack.isEmpty() && current >= stock[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                int peekIndex = stack.peek();
                span[i] = i - peekIndex;
            }
            stack.push(i);
        }
    }

    void displaySpan() {
        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
    }

    static void main(String[] args) {
        Stock_Span sSpan = new Stock_Span();
        System.out.println("Stock span count");
        sSpan.stockSpan();
        sSpan.displaySpan();

    }
}
