import java.util.Scanner;
public class LeapYear05{
    public static void main(String[] args)
    {
        //find leap year; 
        System.out.println("Enter a year");
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        if(((year % 4 == 0)&&(year % 100 !=0))||(year % 400 == 0) )
        {
            System.out.println("leap year");
        }
        else
        {
            System.out.println("Regular year");
        }
    }
}