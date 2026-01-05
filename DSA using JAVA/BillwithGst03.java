import java.util.Scanner;

public class BillwithGst03{
    public static void main(String[] args){
        //Find the cose of three items with gst add on bill;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter pen cost = ");
        float pen = sc.nextFloat();
        System.out.print("\nEnter pencil cost = ");
        float pencil = sc.nextFloat();
        System.out.print("\nEnter eraser cost = ");
        float eraser = sc.nextFloat();

        float total = pen + pencil + eraser;
        System.out.println("Bill is = " + total);

        //with 18% GST bill;
        total = total + (0.18f * total); 
        System.out.println("With GST bill is = " + total);

    }
}