public class ConstructorMain{
    String modelName;
    int  modelYear;
    int age;
    private String pop = "god";
   //example of this keyword to call another constructor
   public ConstructorMain(String modelName) //normal constructor
   {
          this(2018,modelName); //call second constructor;
   }  
   public ConstructorMain(int modelYear,String modelName)
   {
        this.modelName = modelName;
        this.modelYear = modelYear;
        this(10);
   }
   public ConstructorMain(int age)
   {
          this.age = age; //set the class attribute age from to constructor paramter       
   }
   

   public void display()
   {
    System.out.println("vechile model name = " + modelName);
    System.out.println("vechile model year = " + modelYear);
    System.out.println("vechile Expire Age = " + age);
    System.out.println("pop = " + pop);

   }

    //main function
    public static void main(String[] args){
         System.out.println("working..");
         ConstructorMain obj = new ConstructorMain("Scorpio");
         obj.display();
         System.out.println(obj.pop);
         Temp tem = new Temp();
         tem.disp();
        //  System.out.println(tem.demo); 
    }
};


class Temp {
    private String demo = "This is demo string";

    void disp()
    {
        System.out.println("demo attribute value = " + demo);
    }
}