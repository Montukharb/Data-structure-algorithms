public class ArrayQuestion11{
    public static void main(String[] args) {
        {
           ArrayQuestion11 obj = new ArrayQuestion11();
           int arr[] = {1,2,3,1},arr2[] = {1,2,3,4},arr3[] = {1,1,1,3,3,4,3,2,4,2};

           System.out.println("duplicate value availability = " + obj.DuplicateCheck(arr3));
        }
    } 
    boolean DuplicateCheck(int arr[]){
      int sample = arr[0];
      for(int i = 1;i<arr.length;i++)
      {
         if(sample == arr[i])
         {
           return true;
         }
      }
      return false;
    }
}