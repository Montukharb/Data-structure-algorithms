import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Stack;

public class Reverse_Str_Stack {
    Stack<Character> stack = new Stack<>();
    StringBuilder strbuild = new StringBuilder();

    void reverseStringStack(Stack<Character> data, StringBuilder strbuild) {
        if (data.isEmpty()) {
            return;
        }
        char ch = data.pop();
        strbuild.append(ch);
        reverseStringStack(data, strbuild);
    }


    void display() {
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i) + " ");
        }
    }

    void push(String str) {
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
    }

    static void main(String[] args) {
        Reverse_Str_Stack obj = new Reverse_Str_Stack();
        System.out.println("Enter string");
        String str = new Scanner(System.in).next();
        obj.push(str);
        obj.display();
        obj.reverseStringStack(obj.stack, obj.strbuild);
        System.out.println("\nAfter reverse string");
        System.out.println(obj.strbuild);

    }
}
