import java.util.Scanner;
public class Average01{
    public static void main(String[] args) {
       //find the average of there numbers.
       Scanner sc = new Scanner(System.in); 
        int a,b,c;
        
       System.out.println("Enter three numbers");
       a = sc.nextInt();
       b = sc.nextInt();
       c = sc.nextInt();

       int average = (a+b+c)/3; 
       System.out.println("Average of three numbers = "+average);
    }
}