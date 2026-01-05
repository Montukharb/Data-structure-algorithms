import java.util.Scanner;
public class PositiveNegative04{
    public static void main(String[] args)
    {
        System.out.print("Enter any number = ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String label;
        if(num >= 0)
        {
            label = "Positive";
        }
        else
        {
            label = "Negative";
        }
        System.out.println("Entered number is = " + label);
    }
}