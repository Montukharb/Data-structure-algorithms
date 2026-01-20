
import java.util.Scanner;

public class PalindromeNo08 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number");
        int num = sc.nextInt();
        PalindromeNo08 obj = new PalindromeNo08();
        System.out.println(obj.CheckNum(num));
        System.out.println("Sum of digits = " + obj.sumofDigits(num));

        System.out.println("palindrome string = " + obj.palindromeString("radar"));
    }

    public String CheckNum(int num) {
        String label;
        int originalNo = num;
        int revNum = 0;

        while (num > 0) {
            //find last digit and assign value;
            revNum = revNum * 10 + (num % 10);

            //remove last digit;
            num /= 10;
        }
        if (revNum == originalNo) {
            label = "Entered number is Palindrome Number = " + revNum;

        } else {
            label = "Entered number is not Palindrome Number = " + revNum;
        }
        return label;
    }

    ;

    // sum of digits;
    int sumofDigits(int num) {

        int sum = 0;
        while (num > 0) {
            sum += num % 10;

            num /= 10;
        }
        return sum;
    }

    boolean palindromeString(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {

                return false;
            }
        }

        return true;
    }
};
