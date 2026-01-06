import java.util.Scanner;

public class FactorialNo07{
     public static void main(String[] args) {
         System.out.print("Enter number = ");
         Scanner sc = new Scanner(System.in);
         long inp = sc.nextLong();

         System.out.println("Factorial number! = "+factorial(inp));
     }
     public static long factorial(long inp)
     {
        if(inp < 1)
        {
            return 1;
        }
        return inp * factorial(inp -1); 
     } 
}