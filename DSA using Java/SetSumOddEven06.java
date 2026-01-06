import java.util.Scanner;
public class SetSumOddEven06{
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         System.out.println("Enter number");
         int size = sc.nextInt();
         int sumofEven = 0 ;
         int sumofOdd = 0;
         for(int i = 0; i<=size; i++)
        {
            if(i%2==0)
            {
            sumofEven += i;   
            }
            else
            {
             sumofOdd += i;
            }
         }
         System.out.println("Sum of Even number = " + sumofEven);
         System.out.println("Sum of odd number = " + sumofOdd);
     }
};





// import java.util.Scanner;
// public class SetSumOddEven06 {
// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// int number;
// int choice;
// int evenSum = 0;
// int oddSum = 0;
// do {
// System.out.print("Enter the number ");
// number = sc.nextInt();
// if( number % 2 == 0) {
// evenSum += number;
// } else {
// oddSum += number;
// }
// System.out.print("Do you want to continue? Press 1 for yes or 0 for no");
// choice = sc.nextInt();
// } while(choice==1);
// System.out.println("Sum of even numbers: " + evenSum);
// System.out.println("Sum of odd numbers :" + oddSum);
// }
// }