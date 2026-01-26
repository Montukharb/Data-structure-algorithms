import java.util.Stack;

public class Valid_Parentheses {
    Stack<Character> stack = new Stack<>();

    boolean isOpen(char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }

    boolean checkParentheses(String parentheses) {
        if (parentheses.isEmpty()) {
            return false;
        }
        for (int i = 0; i < parentheses.length(); i++) {
            char ch = parentheses.charAt(i);
            if (isOpen(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.peek();
                if ((top == '(' && ch == ')') || (top == '[' && ch == ']') || (top == '{' && ch == '}')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }

    static void main(String[] args) {
        Valid_Parentheses obj = new Valid_Parentheses();
        String parentheses = "()[]{}(({{}}))";

        System.out.println("valid parentheses = " + obj.checkParentheses(parentheses));

    }
}
