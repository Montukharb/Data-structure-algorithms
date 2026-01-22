public class Recursion {

    private Recursion()
    {
    }
    static void main(String[] args)
    {
        System.out.println("hello recursion");
        Recursion obj = new Recursion();
        Integer a = 10;
        System.out.println("type check = "+obj.getClass());
        for (int i = 0;i<=5;i++)
        {
         System.out.print(obj.check(i) + " ");
        }
    }

   int check(int n)
    {
        if(n==1 || n==0)
        {
            return n;
        }

         int res =  check(n - 1) + check(n - 2);
        return res;
    }


}
