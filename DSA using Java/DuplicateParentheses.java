import java.util.Stack;

public class DuplicateParentheses {

    boolean dupPare(String equation) {
    Stack<Character> stack = new Stack<>();
        if (equation.isEmpty()) {

            System.out.println("Input null");
            return false;
        }
        for (int i = 0; i < equation.length(); i++) {
            char ch = equation.charAt(i);
            if (ch != ')') {
                stack.push(ch);
            } else {
                int count = 0;
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                    count++;
                }
                if (count < 1) {
                    return true;
                } else {
                    if (!stack.isEmpty()) {
                        stack.pop();

                    } else {
                        System.out.println("please give valid input");
                    }
                }
            }

        }
        if(!stack.isEmpty())
        {
            System.out.println("invalid expression");

        }
        return false;
    }

    static void main(String[] args) {
        System.out.println("Check duplicate Parentheses");
//        String equation = "(((a+(b)))+(c+d))";
//        String equation = "((((a)+(b))+c+d))";
        String equation = "((a+b)+(c+d))";

        DuplicateParentheses obj = new DuplicateParentheses();
        System.out.println("equation is duplicate = " + obj.dupPare(equation));
    }
}
