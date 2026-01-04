public class ThisKeyword{
    
      public static void main(String[] args)
      {
        System.out.println("Main program run...");
        Sample obj = new Sample(450);
        int[] arr = {10,564,100,10,5,6,46,4,14};

        Sample obj1 = new Sample("John",12,new int[] {10,20,30,40,50});  
        
        Sample obj2 = new Sample("John",12, arr );  
        Sample onb = new Sample(10,20,3,0);
      }

};

class Sample{
    //class attribute
    int value = 1;
    int temp = 100;
    public Sample(int value){
        int temp = 200;
      this.value = value * 2;       

    System.out.println(this.value);
    System.out.println(temp);
    System.out.println(this.temp);
    }

    public Sample(String name,int age,int []arr)
    {
        System.out.println("Name = " + name);
        System.out.println("age =" + age);
        //print value array using for each loop;

        for(var i :arr)
        {
            System.out.print(i + " ");
        }

    }
    public Sample(int ...arr){
        System.out.println();
       for(var ii:arr)
       {
        System.out.print(ii + " ");
       }
    }
    
};



