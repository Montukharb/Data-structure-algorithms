import java.util.Scanner;
public class AreaSquare02{
   public static void main(String[] args) {
       //area of square;
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter side of square = ");

      int side = sc.nextInt();
      int area = side * side;
      System.out.println("The area of square = "+area);
   }
}