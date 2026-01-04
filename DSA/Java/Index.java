import java.util.Scanner;
public class Index{
    public static void main(String args[])
    {
        Users obj = new Users();

        obj.display();



        Scanner sc = new Scanner(System.in);
        System.out.println("hello world");
        // String str = "df";
        System.out.println("Enter your text");
        String name = sc.nextLine();
        int age = sc.nextInt();

        System.out.println(name + "\n" + age);
           
        //    var x = 100;
        //    System.out.println("x = "+ x);
        // byte xx = 10;
        //reverse a number from 123456 to 654321 ;

        int number = 123456;
        int revNumber = 0;
        int origNumber = number;   
        while(number!=0)
        {
            //find the last digit of number;
            revNumber = revNumber * 10 + number % 10;
            // remove the last digit from number;
            number /= 10;  
        } 
        System.out.println("The original number = " + origNumber);
        System.out.println("The Reverse number = " + revNumber);
      int a = 100, b = 12;
      System.out.println(Math.max(a,b));
    }
}

 class Users {
    int x = 100;

     void display()
     {
        System.out.println(x);
     } 
};



