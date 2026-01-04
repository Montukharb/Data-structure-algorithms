public class Sample{
   public static void main(String []args)
   {
        System.out.println("Oops");
     //object created here; 
        Demo obj = new Demo("hey constructor", new int[] {10,20,30,40,50,60,70,80,90,100});
        System.out.println(obj.x);
        obj.display();    
      //   obj.x = 520;   //error because x is final/constant; 
        System.out.println(obj.x);
        // System.out.println(Demo.x);
        
   };


}

class Demo{

   public Demo(String info, int []arr)
   {
      System.out.println("Constructor called infomation str = " + info );
      //using for each loop;
      for(var i : arr)
      {
         System.out.print(i + " ");
      }
   }
  final int x = 110; 
   float xyd;
    //class attribute
    void display()  // class method
    {  
        xyd = 45.5f;
        int xy = 56; //variable 
        System.out.println("i am another class method " + xy + "xyd = " + xyd);
        Addition();

    }
    void Addition()
    {
        int a = 10 , b = 20, c;
        c = a+b;
      //   int x = 10;
        System.out.println("The additon of two num = " + c);
        System.out.println("Global variable/class attribute value = " + this.x);  // this keyword is used to access class attribute in class method;
      System.out.println("The local variable value = " + x);

    }
    
   
 }

